package com.wabizabi.wazabipos.Algorithm.Libraries;

import java.util.ArrayList;
import java.util.List;

public class Node {

    public String data;
    public int support;
    Node parent;
    Node edge;
    public List<Node> children = new ArrayList<>();

    //Default Constructor
    Node(){}

    //New Node Constructor
    Node(String item, int support, Node parent){
        this.data = item;
        this.support = support;
        this.parent = parent;
    }

    Node getChild(String item){
        for(Node child : children){
            if(child.data.equals(item)){
                return child;
            }
        }
        return null;
    }

}
