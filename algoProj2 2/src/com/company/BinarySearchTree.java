package com.company;

public class BinarySearchTree {

    Node root;
    String autocorrect = "";

    public void buildTree(String[] array) {
        root = buildTree(array, 0, array.length - 1);
    }

    private Node buildTree(String[] array, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end)/2;
        Node node = new Node(array[mid]);
        node.left = buildTree(array, start, mid - 1);
        node.right = buildTree(array, mid + 1, end);
        return node;
    }

    public String search(String word) {
        return search(root, word);
    }

    private String search(Node node, String word) {
        if (node == null) {
            System.out.println("Sorry, word was not found as a node in the binary tree! ");
            System.out.println("Input was autocorrected to the following: " + autocorrect);
            return autocorrect;
        }
        if (word.compareTo(node.data) == 0) {
            System.out.println("Word was found as a node in the binary tree! ");
            return node.data;
        }
        autocorrect = node.data;
        if (word.compareTo(node.data) < 0) {
            return search(node.left, word);
        } else {
            return search(node.right, word);
        }
    }

}
