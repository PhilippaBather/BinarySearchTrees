package domain;

public class LinkedList {

    // member fields
    private ListItem head;

    // constructor
    public LinkedList() {
        this.head = null;
    }

    // methods

    public boolean addItem(String value) {
        ListItem newNode = new ListNode(value);
        ListItem traversal = this.head;

        if (this.head == null) {
            this.head = newNode;
            return true;                        // newNode set as head (root) of list
        } else {
            while (traversal != null) {
                if (value.compareTo((String)traversal.value) < 0) {
                    if (traversal.previous != null) {
                        traversal.moveToPreviousItem().setNextItem(newNode).setPreviousItem(traversal.previous);
                        newNode.setNextItem(traversal).setPreviousItem(newNode);
                    } else {
                        newNode.setNextItem(traversal).setPreviousItem(newNode);
                        this.head = newNode;
                    }
                    return true;
                } else if (value.compareTo((String) traversal.value) > 0) {
                    if (traversal.next == null) {
                        traversal.setNextItem(newNode).setPreviousItem(traversal);
                        return true;
                    } else {
                        traversal = traversal.moveToNextItem();
                    }
                } else {        // duplicates not permitted
                    System.out.println("Duplicates not permitted; " + value + " already in list.");
                    return false;
                }
            }
        }
        return true;
    }


    /*
    public boolean remove(String item) {
        return head.removeNode(item);
    } */

    public void printLinkedList() {
        ListItem traversal = this.head;
        boolean exit = false;
        while (!exit) {
            System.out.println(traversal.getValue());
            if (traversal.next != null) {
                traversal = traversal.moveToNextItem();
            } else {
                exit = true;
            }
        }
        //head = returnToHead();
    }
}
