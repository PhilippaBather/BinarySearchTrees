package domain;

public class LinkedList {

    // member fields
    private ListNode head;

    // constructor
    public LinkedList() {
        this.head = null;
    }

    // methods

    public void createNewItem(String str) {
        ListNode node = new ListNode(str);
        addItem(node);
    }

    private void addItem(ListNode newNode) {
        //if head of list is null, make head refer to the item to be added
        if (head == null) {
            head = newNode;
        } else {
            boolean exit = false;
            while(!exit) {
                if (newNode.compareTo(head) < 0) {
                    // if the item to be added is less than the current item in the list, add the item before the current item
                    // i.e. make the previous item's "next" refer to the new item, and the new item's "next" refer to the
                    // current item
                    newNode.setNextItem(head);                                          // set newNode to point to the head
                    if (head.previous != null) {
                        head = (ListNode) head.moveToPreviousItem();                    // go back to previous item
                        head.setNextItem(newNode);                                      // set previous item's next to newNode
                        newNode.setPreviousItem(head);                                  // set newNode to point to previous item
                        head = (ListNode) head.moveToNextItem().moveToNextItem();       // move forward two, i.e. to where head initially pointed
                    }
                    head.setPreviousItem(newNode);                                      // set head's previous to newNode
                    exit = true;
                } else if (newNode.compareTo(head) > 0) {
                    // if the item to be added node greater than the current item
                    if (head.next != null) {
                        head = (ListNode) head.moveToNextItem();                        // move onto next item and repeat cf
                    } else {
                        newNode.setPreviousItem(head);                                  // if there is no next item, add newNode pointing its previous to the head
                        head.setNextItem(newNode);                                      // and the head's next to the new node
                        exit = true;
                    }
                } else {
                    System.out.println("Duplicates are not permitted.");
                    exit = true;
                }
            }
            head = returnToHead();
        }
    }

    public boolean remove(String item) {
        return head.removeNode(item);
    }

    public void printLinkedList() {
        boolean exit = false;
        while (!exit) {
            System.out.println(head.getValue());
            if (head.next != null) {
                head = (ListNode) head.moveToNextItem();
            } else {
                exit = true;
            }
        }
        head = returnToHead();
    }

    private ListNode returnToHead() {
        while (head.previous != null) {
            head = (ListNode) head.moveToPreviousItem();
        }
        return head;
    }
}
