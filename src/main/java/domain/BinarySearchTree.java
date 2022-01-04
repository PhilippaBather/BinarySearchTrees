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

    public boolean removeNode(String value) {

        if (this.root == null) {
            System.out.println("The binary search tree is empty.");
            return false;
        } else {
            return root.removeNode(value, null);
        }
    }

    public boolean findNode(BSTNode root, String value) {
        BSTNode itemSearched = search(root, value);

        if (itemSearched == null) {
            System.out.println(value + " not found within list.");
            return false;
        } else {
            System.out.println("Found: \n" + itemSearched);
            return true;
        }
    }

    private BSTNode search(BSTNode currentNode, String value) {
        if (currentNode == null || currentNode.value.equals(value)) {
            return currentNode;
        }

        if (value.compareTo((String) currentNode.getValue()) < 0) {
            return search((BSTNode) currentNode.previous, value);
        }

        return search((BSTNode) currentNode.next, value);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(BSTNode node) {
        if (node == null) {
            return;
        }
        inOrder((BSTNode) node.previous);
        System.out.println(node.value);
        inOrder((BSTNode) node.next);
    }
}
