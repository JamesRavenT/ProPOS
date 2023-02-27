package com.wabizabi.wazabipos.Utilities.Libraries.Algorithm;

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
        Map<List<String>, Integer> paths = new HashMap<>();
        for (Node child : root.children) {
            getPaths(child, pathBuilder, paths);
        }
        paths.entrySet().removeIf(entry -> entry.getValue() < (minSuppThreshold));

        fpList.clear();
        for (Map.Entry<String, Integer> items : fqList.entrySet()) {
            String item = items.getKey();
            fpList.put(item, new ConcurrentHashMap<>());
        }

        for (Map.Entry<List<String>, Integer> path : paths.entrySet()) {
            List<String> itemset = path.getKey();
            String item = itemset.get(0);
            if(fpList.containsKey(item)){
                if(fpList.get(item).containsKey(itemset)){
                    fpList.get(item).put(itemset, fpList.get(item).get(itemset) + path.getValue());
                } else {
                    fpList.get(item).put(itemset, path.getValue());
                }
            }
        }
        fpList.entrySet().removeIf(entry -> entry.getValue().size() == 0);
    }

    static void getPaths(Node currentNode, List<Node> pathbuilder, Map<List<String>, Integer> paths) {
        pathbuilder.add(currentNode);
        if (currentNode.children.isEmpty()) {
            List<Node> nodePath = new ArrayList<>();
            for(Node node : pathbuilder){
                nodePath.add(new Node(node));
            }
            while(nodePath.size() != 1) {
                Node lastItem = nodePath.get(nodePath.size() - 1);
                List<String> pathInStrings = new ArrayList<>();
                for (Node node : nodePath) {
                    pathInStrings.add(node.itemName);
                }
                paths.put(pathInStrings, lastItem.support);
                nodePath.remove(nodePath.size() - 1);
            }
            pathbuilder.remove(pathbuilder.size() - 1);
            return;
        } else {
            for (Node child : currentNode.children) {
                getPaths(child, pathbuilder, paths);
            }
        }
        pathbuilder.remove(pathbuilder.size() - 1);
    }
}
