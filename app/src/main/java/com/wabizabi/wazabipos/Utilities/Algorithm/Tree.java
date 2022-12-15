package com.wabizabi.wazabipos.Utilities.Algorithm;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Tree {
    public Node root = new Node();

    public Tree(){}
    /** STEP 2.1 : PREPARE THE DATASET
     * Create a Set based from the Keysets found in the F-List
     * For each transaction in the list of transactions, check each item in the transaction
     * Remove the item(s) if the item(s) is not found within the created Set
     * Sort the items in the transaction based on the order of the Set
     * **/
    public static Tree create(List<List<String>> listOfTransactions, Map<String, Integer> fqList) {
        Set<String> fqItemset = fqList.keySet();
        List<String> fqListItems = new ArrayList<>(fqItemset);
        for (List<String> transaction : listOfTransactions){
            transaction.removeIf(item -> !fqListItems.contains(item));
            transaction.sort(Comparator.comparingInt(fqListItems::indexOf));
        }
        listOfTransactions.removeIf(List::isEmpty);

        //-- F-LIST SAMPLE --//
        // Item     |   Frequency
        // Item B           5
        // Item A           4
        // Item D           4

        // F-LIST SET = [ B , A , D ]

        //-- TRANSACTION SAMPLE --//
        // BEFORE
        // TID 1 = [ Item D, Item C, Item A, Item E ]
        // AFTER
        // TID 1 = [ Item D, Item A ]
        // TID 1 = [ Item A, Item D ]

    /** STEP 2.2 : CREATE THE FP TREE
     * Create a Tree object
     * Add the transactions one by one to the tree
     * If current node does not have child, add the new node as a child
     * Else, add 1 in the value of the current node
     * **/
        Tree tree = new Tree();
        for (List<String> transaction : listOfTransactions) {
            tree.addTransaction(transaction);
        } return tree;
    }

    void addTransaction(List<String> transactions) {
        Node nodeOfFocus = root;
        for (String item : transactions) {
            Node child = nodeOfFocus.checkIfNodeHasAChildNamed(item);
            if (child == null) {
                Node newNode = new Node(item, 1, nodeOfFocus);
                nodeOfFocus.children.add(newNode);
                nodeOfFocus = newNode;
            } else {
                child.support++;
                nodeOfFocus = child;
            }
        }
    }

    //-- TREE SAMPLE --//
    //       root node
    //      /    |    \
    //    A:3   D:3   B:4
    //    / \    |    / \
    //  C:1 D:2 E:3 C:2 F:2

    /** STEP 3.1 : MINE THE TREE
     * Create a path builder
     * Create a list of Node Paths
     * Create a map of paths, this will be the output
     * For each child in the root, use a recursive function to mine the paths
     * Add the current node as into the path builder
     * If the current node's children is empty,
     * Add the current contents of the path builder as a path,
     * Then remove the current node in the builder and return to the previous function
     * Else, for each child in the current node, use a recursive function to mine the paths
     * Repeat the process till every path is mined
     * **/

    public static void mineToFindFrequentPatterns(Tree tree,
                            int minSuppThreshold,
                            Map<String, Integer> fqList,
                            Map<String, Map<List<String>, Integer>> fpList) {
        Node root = tree.root;
        List<Node> pathBuilder = new ArrayList<>();
        List<List<Node>> listOfNodePaths = new ArrayList<>();
        Map<List<String>, Integer> paths = new HashMap<>();
        for (Node child : root.children) {
            getPaths(child, pathBuilder, listOfNodePaths);
        }

        /** STEP 3.2 : EXTRACT THE PATHS
         * For each path of Nodes in the list of Node Paths,
         * Extract the items as a String and add them as a list to the list of String Paths
         * The number of times it will be done depends on the support of the last item
         * If the support reaches zero, remove the last item and then repeat till the Node Path size becomes 1
         * **/
        for (List<Node> nodePath : listOfNodePaths) {
            while(nodePath.size() != 1) {
                Node lastItem = nodePath.get(nodePath.size() - 1);
                List<String> pathInStrings = new ArrayList<>();
                for (Node node : nodePath) {
                    pathInStrings.add(node.itemName);
                }
                if(paths.containsKey(pathInStrings)){
                    paths.put(pathInStrings, paths.get(pathInStrings) +lastItem.support);
                } else {
                    paths.put(pathInStrings, 1);
                }
                nodePath.remove(nodePath.size() - 1);
            }
        }
        paths.values().removeIf(value -> value < minSuppThreshold);
        paths.entrySet().removeIf(entry -> entry.getValue() == 0);

        //PATHS
        //Key       | Value
        //[A, B, C] :   3
        //[A, D, E] :   2
        //[A, B, D] :   4

        /** STEP 3.3 : CREATE THE LIST OF FREQUENT PATTERNS
         * Initialize a Concurrent HashMap as the List of Frequent Patterns
         * Clear the entries of the FP-List
         * Copy the entries from F-List to the FP-List
         * Create another map to calculate the frequency of each path
         * Remove the entry in the second map if the frequency doesnt match the MST
         * If a key in the FP-list exists as an item inside a path, add that path to the said key
         * Remove the keysets in the FP-list who'se value = 0
         * **/

        fpList.clear();
        for (Map.Entry<String, Integer> items : fqList.entrySet()) {
            String item = items.getKey();
            fpList.put(item, new ConcurrentHashMap<>());
        }

        for (Map.Entry<List<String>, Integer> path : paths.entrySet()) {
            List<String> itemset = path.getKey();
            for(String item : itemset){
                if(fpList.containsKey(item)){
                    if(fpList.get(item).containsKey(itemset)){
                        fpList.get(item).put(itemset, path.getValue() + 1);
                    } else {
                        fpList.get(item).put(itemset, path.getValue());
                    }
                }
            }
        }
        fpList.entrySet().removeIf(entry -> entry.getValue().size() == 0);

        //PATHS
        //Key       |       Value
        //Item A    :   <[A, B, C] : 3> ,
        //              <[A, D, E] : 2> ,
        //              <[A, B, D] : 4>

        //Item E    :   <[A, D, E] : 2>

        //Item D    :   <[A, B, D] : 4> ,
        //              <[A, D, E] : 2>

    }

    static void getPaths(Node currentNode, List<Node> pathbuilder, List<List<Node>> nodePaths) {
        pathbuilder.add(currentNode);
        if (currentNode.children.isEmpty()) {
            List<Node> nodePath = new ArrayList<>(pathbuilder);
            nodePaths.add(nodePath);
            pathbuilder.remove(pathbuilder.size() - 1);
            return;
        } else {
            for (Node child : currentNode.children) {
                getPaths(child, pathbuilder, nodePaths);
            }
        }
        pathbuilder.remove(pathbuilder.size() - 1);
    }

}
