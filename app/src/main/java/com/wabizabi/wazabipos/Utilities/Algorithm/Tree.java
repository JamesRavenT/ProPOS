package com.wabizabi.wazabipos.Utilities.Algorithm;

import static com.wabizabi.wazabipos.Utilities.GlobalVariables.filteredTransactions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Tree {

    public Node root = new Node();
    Map<String, Node> mapItemNodes = new HashMap<>();
    Map<String, Node> mapItemLastNodes = new HashMap<>();
    boolean hasMoreThanOnePath = false;

    public Tree(){}

    public static Tree create(List<List<String>> unfilteredTransactions, Map<String, Integer> fqList) {
        for(List<String> transact : unfilteredTransactions){
            filteredTransactions.add(transact);
        }
        Set<String> fqItems = fqList.keySet();
        List<String> filteredItems = new ArrayList<>(fqItems);
        for (List<String> transactions : filteredTransactions){
            transactions.removeIf(item -> !filteredItems.contains(item));
            transactions.sort(Comparator.comparingInt(filteredItems::indexOf));
        }
        filteredTransactions.removeIf(List::isEmpty);





        Tree tree = new Tree();
        for (List<String> transaction : filteredTransactions) {
            tree.addTransaction(transaction);
        } return tree;
    }

    void addTransaction(List<String> transactions) {
        Node currentNode = root;
        for (String item : transactions) {
            Node child = currentNode.getChild(item);
            if (child == null) {
                Node newNode = new Node(item, 1, currentNode);
                currentNode.children.add(newNode);
                if (!hasMoreThanOnePath && currentNode.children.size() > 1) {
                    hasMoreThanOnePath = true;
                }
                currentNode = newNode;
                linkNodes(item, newNode);
            } else {
                child.support++;
                currentNode = child;
            }
        }
    }

    void linkNodes(String item, Node newNode) {
        Node lastNode = mapItemLastNodes.get(item);
        if (lastNode != null) {
            lastNode.edge = newNode;
        }
        mapItemLastNodes.put(item, newNode);
        Node headerNode = mapItemNodes.get(item);
        if (headerNode == null) {
            mapItemNodes.put(item, newNode);
        }
    }


    public static List<List<String>> mine(Tree tree) {
        Node root = tree.root;
        List<Node> paths = new ArrayList<>();

        List<List<Node>> nodePaths = new ArrayList<>();
        List<List<String>> stringPaths = new ArrayList<>();
        for (Node child : root.children) {
            getPaths(child, paths, nodePaths);
        }
        for (List<Node> nodePath : nodePaths) {
            while (nodePath.size() != 1) {
                Node lastItem = nodePath.get(nodePath.size()-1);
                while(lastItem.support != 0){
                    List<String> items = new ArrayList<>();
                    for(Node node : nodePath){
                        items.add(node.data);
                    }
                    stringPaths.add(items);
                    lastItem.support--;
                }
                nodePath.remove(nodePath.size()-1);
            }
        }
        return stringPaths;
    }

    static void getPaths(Node node, List<Node> paths, List<List<Node>> nodePaths) {
        paths.add(node);
        if (node.children.isEmpty()) {
            List<Node> nodePath = new ArrayList<>(paths);
            nodePaths.add(nodePath);
            paths.remove(paths.size() - 1);
            return;
        } else {
            for (Node child : node.children) {
                getPaths(child, paths, nodePaths);
            }
        }
        paths.remove(paths.size() - 1);
    }

}
