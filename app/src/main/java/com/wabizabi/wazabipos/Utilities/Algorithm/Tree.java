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

    public static Tree create(List<List<String>> listOfTransactions, Map<String, Integer> fqList) {
        Set<String> fqItemset = fqList.keySet();
        List<String> fqListItems = new ArrayList<>(fqItemset);
        for (List<String> transaction : listOfTransactions){
            transaction.removeIf(item -> !fqListItems.contains(item));
            transaction.sort(Comparator.comparingInt(fqListItems::indexOf));
        }
        listOfTransactions.removeIf(List::isEmpty);
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
        paths.entrySet().removeIf(entry -> entry.getValue() < minSuppThreshold);

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
