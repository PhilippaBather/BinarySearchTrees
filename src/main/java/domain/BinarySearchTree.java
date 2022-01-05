package domain;

public class BinarySearchTree {

    // member fields
    ListItem root;

    // constructor

    public BinarySearchTree() {
        this.root = null;
    }

    // methods
    public boolean addNode(String value) {
        if (root == null) {
            root = new BSTNode(value);
        } else {
            return addRecursively(root, value);
        }
        return true;
    }

    /**
     * Method adds a new node recursively to the list.
     * @param currentNode traversal node
     * @param value of String to be added to a new node
     * @return boolean
     */
    private boolean addRecursively(ListItem currentNode, String value) {
        if (value.compareTo((String) currentNode.getValue()) < 0) {
            if (currentNode.previous == null) {
                currentNode.setPreviousItem(new BSTNode(value));
            } else {
                return addRecursively(currentNode.previous, value);
            }
        } else if (value.compareTo((String) currentNode.getValue()) > 0) {
            if (currentNode.next == null) {
                currentNode.setNextItem(new BSTNode(value));
            } else {
                return addRecursively(currentNode.next, value);
            }
        } else {
            System.out.println("Duplicates not permitted; " + value + " already exists.");

        }
        return false;
    }


    /**
     * Removes node that contains a value matching that provided.
     * Invokes the method within the BSTNode class.
     * @param value String value of item to be removed
     * @return boolean
     */
    public boolean removeNode(String value) {

        if (this.root == null) {
            System.out.println("The binary search tree is empty.");
            return false;
        } else {
            return ((BSTNode) root).removeNode(value, null);
        }
    }

    /**
     * Public facing method that handles
     * @param value to be searched for
     * @return boolean
     */
    public boolean findNode(String value) {
        ListItem itemSearched = search(this.root, value);

        if (itemSearched == null) {
            System.out.println(value + " not found within list.");
            return false;
        } else {
            System.out.println("Found: \n" + itemSearched);
            return true;
        }
    }

    /**
     * Recursive method that searches for a node whose value matches a given
     * String value.
     * @param currentNode traversal node
     * @param value of String to be matched
     * @return BST Node to caller method.
     */
    private ListItem search(ListItem currentNode, String value) {
        if (currentNode == null || currentNode.value.equals(value)) {
            return currentNode;
        }

        if (value.compareTo((String) currentNode.getValue()) < 0) {
            return search(currentNode.previous, value);
        }

        return search(currentNode.next, value);
    }

    /**
     * Public facing method to accessing private inOrder method.
     * Method invoked prints the Binary Search Tree in order.
     */
    public void inOrder() {
        inOrder(this.root);
    }

    /**
     * Recursive method that prints the Binary Search Tree
     * in alphabetical order to the console.
     * @param node traversed
     */
    private void inOrder(ListItem node) {
        if (node == null) {
            return;
        }
        inOrder(node.previous);
        System.out.println(node.value);
        inOrder(node.next);
    }
}
