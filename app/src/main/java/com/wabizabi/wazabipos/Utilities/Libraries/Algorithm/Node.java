package com.wabizabi.wazabipos.Utilities.Libraries.Algorithm;

import java.util.ArrayList;
import java.util.List;

public class Node {
    Node parent;
    public String itemName;
    public int support;
    public List<Node> children = new ArrayList<>();

    Node(){}

    Node(Node node){
        this.itemName = node.itemName;
        this.support = node.support;
        this.parent = node.parent;
    }

    Node(String item, int support, Node parent){
        this.itemName = item;
        this.support = support;
        this.parent = parent;
    }

    Node checkIfNodeHasAChildNamed(String item){
        for(Node child : children){
            if(child.itemName.equals(item)){
                return child;
            }
        }
        return null;
    }

}
