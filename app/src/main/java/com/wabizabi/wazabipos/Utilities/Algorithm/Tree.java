package com.wabizabi.wazabipos.Utilities.Algorithm;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Tree {

    public Node root = new Node();

    public Tree(){}

    public static Tree create(List<List<String>> listOfTransactions, Map<String, Integer> fqList) {
        List<List<String>> transactions = new ArrayList<>();
        for(List<String> transaction : listOfTransactions){
            transactions.add(transaction);
        }
        Set<String> fqItems = fqList.keySet();
        List<String> filteredItems = new ArrayList<>(fqItems);
        for (List<String> transaction : transactions){
            transaction.removeIf(item -> !filteredItems.contains(item));
            transaction.sort(Comparator.comparingInt(filteredItems::indexOf));
        }
        transactions.removeIf(List::isEmpty);

        Tree tree = new Tree();
        for (List<String> transaction : transactions) {
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
                currentNode = newNode;
            } else {
                child.support++;
                currentNode = child;
            }
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
