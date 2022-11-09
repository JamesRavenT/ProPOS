package com.wabizabi.wazabipos.Utilities.Algorithm;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Tree {
    public Node root = new Node();

    public Tree(){}
    /** STEP 2.1 : PREPARE THE DATASET
     * Create a Set based from the Keysets found in the F-List
     * For each transaction in the list of transactions, check each item in the transaction
     * Remove the item(s) if the item(s) is not found within the created Set
     * Sort the items in the transaction based on the order of the Set
     * **/
    public static Tree create(List<List<String>> transactions, Map<String, Integer> fqList) {
        Set<String> fqItemset = fqList.keySet();
        List<String> fqListItems = new ArrayList<>(fqItemset);
        for (List<String> transaction : transactions){
            transaction.removeIf(item -> !fqListItems.contains(item));
            transaction.sort(Comparator.comparingInt(fqListItems::indexOf));
        }
        transactions.removeIf(List::isEmpty);

        //-- F-LIST SAMPLE --//
        // Item     |   Frequency
        // Item B           5
        // Item A           4
        // Item D           4

        //-- TRANSACTION SAMPLE --//
        // BEFORE
        // TID 1 = [ Item D, Item C, Item A, Item E ]
        // AFTER
        // TID 1 = [ Item A, Item D ]

    /** STEP 2.2 : CREATE THE FP TREE
     * Create a Tree object
     * Add the transactions one by one to the tree
     * If current node does not have child, add the new node as a child
     * Else, add 1 in the value of the current node
     * **/
        Tree tree = new Tree();
        for (List<String> transaction : transactions) {
            tree.addTransaction(transaction);
        } return tree;
    }

    void addTransaction(List<String> transactions) {
        Node currentNode = root;
        for (String item : transactions) {
            Node child = currentNode.checkIfNodeHasAChildNamed(item);
            if (child == null) {
                Node newNode = new Node(item, 1, currentNode);
                currentNode.children.add(newNode);
                currentNode = newNode;
            } else {
                child.support++;
                currentNode = child;
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
     * Create a list of String Paths, this will be the output
     * For each child in the root, use a recursive function to mine the paths
     * Add the current node as into the path builder
     * If the current node's children is empty,
     * Add the current contents of the path builder as a path,
     * Then remove the current node in the builder and return to the previous function
     * Else, for each child in the current node, use a recursive function to mine the paths
     * Repeat the process till every path is mined
     * **/

    public static Map<List<String>, Integer>  mine(Tree tree, int minSuppThreshold) {
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
            while (nodePath.size() != 1) {
                Node lastItem = nodePath.get(nodePath.size() - 1);
                while (lastItem.support != 0) {
                    List<String> pathInStrings = new ArrayList<>();
                    for (Node node : nodePath) {
                        pathInStrings.add(node.itemName);
                    }
                    if(paths.containsKey(pathInStrings)){
                        paths.put(pathInStrings, paths.get(pathInStrings) +1);
                    } else {
                        paths.put(pathInStrings, 1);
                    }
                    lastItem.support--;
                }
                nodePath.remove(nodePath.size() - 1);
            }
        }
        paths.values().removeIf(value -> value < minSuppThreshold);
        return paths;
    }

    // list of node paths = [ [ A : 3, C : 1 ] , [ A : 3, D : 2 ] ]

    //[ A : 3, D : 2 ]

    // list of string paths = [[ A , D ], [ A , D ]]


    //-- PATH SAMPLE --//
    // List =   [
    //          [Item A, Item D],
    //          [Item A, Item D],
    //          [Item A, Item C]
    //          ]

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
    //-- TREE SAMPLE --//
    //       root node
    //      /    |    \
    //    A:3   D:3   B:4
    //    / \    |    / \
    //  C:1 D:2 E:3 C:2 F:2


    // pathbuilder = [ D:3 ]
    // list of node paths = [ [ A : 3, C : 1 ] , [ A : 3, D : 2 ], [ A : 3 ] ]
}
