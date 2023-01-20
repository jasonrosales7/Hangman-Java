package com.company;

public class Node {
    String data;
    Node left;
    Node right;

    public Node(String data) {
        this.data = data;
    }

    public Node() {
        this.data = null;
        this.left = null;
        this.right = null;
    }

}
