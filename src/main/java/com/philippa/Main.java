package com.philippa;

import domain.*;

public class Main {

    public static void main(String[] args) {
       LinkedList list = new LinkedList();     // create 'linked list' to be populated

        String stringData = "Darwin Adelaide Atherton Canberra Perth Melbourne Canberra Adelaide Sydney Canberra";
        String[] data = stringData.split(" ");
        // create new item with value set to the string s
        for (String s : data) {
            list.addItem(s);
        }

        System.out.println();
        list.printLinkedList();
        System.out.println();

        /*
        System.out.println(list.remove("Sydney") ? "Item removed" :"Item not found");
        System.out.println();
        list.printLinkedList();
        System.out.println();
        System.out.println(list.remove("Angmering") ? "Item removed" :"Item not found");
        System.out.println(list.remove("Canberra") ? "Item removed" : "Item not found");
        System.out.println();
        list.printLinkedList();

        /*
        BinarySearchTree bst = new BinarySearchTree();
        String stringData = "Darwin Adelaide Atherton Canberra Perth Melbourne Canberra Adelaide Sydney Canberra";

        if (!stringData.isEmpty()) {

            String[] data = stringData.split(" ");
            // create new item with value set to the string s
            for (String s : data) {
                bst.addNode(s);
            }
        }

        System.out.println();
        bst.inOrder();
        System.out.println("\nAdelaide to be removed.");
        bst.removeNode("Adelaide");
        System.out.println();
        bst.inOrder();
        System.out.println("\nDarwin to be removed.");
        bst.removeNode("Darwin");
        System.out.println();
        bst.inOrder();
        System.out.println("\nSydney to be removed");
        bst.removeNode("Sydney");
        System.out.println();
        bst.inOrder();
        */
    }
}
