package domain;

public class BinarySearchTree {

    // member fields
    BSTNode root;

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
    private boolean addRecursively(BSTNode currentNode, String value) {
        if (value.compareTo((String) currentNode.getValue()) < 0) {
                if (currentNode.previous == null) {
                    currentNode.setPreviousItem(new BSTNode(value));
                } else {
                    return addRecursively((BSTNode) currentNode.previous, value);
                }
            } else if (value.compareTo((String) currentNode.getValue()) > 0) {
                if (currentNode.next == null) {
                    currentNode.setNextItem(new BSTNode(value));
                } else {
                    return addRecursively((BSTNode) currentNode.next, value);
                }
            } else {
                System.out.println("Duplicates not permitted; " + value + " already exists.");

            }
        return false;
    }

    // TODO finish
    public boolean removeNode(String value) {

        if (this.root == null) {
            System.out.println("The binary search tree is empty.");
            return false;
        } else {
            return root.removeNode(value, null);
        }
    }

    /**
     * Public facing method that handles
     * @param root head of Binary Search Tree
     * @param value to be searched for
     * @return
     */
    public boolean findNode(String value) {
        BSTNode itemSearched = search(this.root, value);                 // search from root     // TODO check functioning

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
    private BSTNode search(BSTNode currentNode, String value) {
        if (currentNode == null || currentNode.value.equals(value)) {
            return currentNode;
        }

        if (value.compareTo((String) currentNode.getValue()) < 0) {
            return search((BSTNode) currentNode.previous, value);
        }

        return search((BSTNode) currentNode.next, value);
    }

    /**
     * Public facing method to accessing private inOrder method.
     * Method invoked prints the Binary Search Tree in order.
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * Recursive method that prints the Binary Search Tree
     * in alphabetical order to the console.
     * @param node
     */
    private void inOrder(BSTNode node) {
        if (node == null) {
            return;
        }
        inOrder((BSTNode) node.previous);
        System.out.println(node.value);
        inOrder((BSTNode) node.next);
    }
}
