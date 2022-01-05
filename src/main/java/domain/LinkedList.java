package domain;

/**
 * Class to create a LinkedList object of String values ordered alphabetically.
 */
public class LinkedList {

    // member fields
    private ListItem head;

    // constructor
    public LinkedList() {
        this.head = null;
    }

    // methods

    /**
     * Method adds a new item in alphabetical order to the linked list.
     * Duplicates are not permitted.
     * @param value String value of item to be added.
     * @return boolean
     */
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

    /**
     * Helper method calling private remove method
     * @param item String value to be removed
     * @return boolean
     */
    public boolean remove(String item) {
        return remove(this.head, item);
    }

    /**
     * Recursive function to remove node from the LinkedList.
     * @param currentNode traversal node starting from head (root).
     * @param item String value to be removed
     * @return boolean
     */
    private boolean remove(ListItem currentNode, String item) {
        if (item.compareTo((String) currentNode.value) < 0) {
            return false;       // item not found
        } else if (item.compareTo((String) currentNode.value) > 0) {
            if (currentNode.next != null) {
                return remove(currentNode.next, item);
            } else {
                return false;   // item not found
            }
        } else {                // item found
            if (currentNode.next != null) {
                currentNode.value = currentNode.moveToNextItem().value;
                currentNode.next = currentNode.moveToNextItem().next;
            } else {
                currentNode.moveToPreviousItem().setNextItem(null);
            }
            return true;
        }
    }

    /**
     * Method to print the ordered linked list.
     */
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
    }
}
