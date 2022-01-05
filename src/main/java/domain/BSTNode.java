package domain;

public class BSTNode extends ListItem {

    public BSTNode(Object value) {
        super(value);
    }

    @Override
    ListItem moveToNextItem() {
        return this.next;
    }

    @Override
    ListItem moveToPreviousItem() {
        return this.previous;
    }

    @Override
    ListItem setNextItem(ListItem item) {
        this.next = item;
        return this.next;
    }

    @Override
    ListItem setPreviousItem(ListItem item) {
        this.previous = item;
        return this.previous;
    }

    @Override
    int compareTo(ListItem item) {
        int value;
        if (item != null) {
            value = ((String) super.getValue()).compareTo((String) item.getValue());
            return value;
        } else {
            return -1;
        }
    }

    public boolean removeNode(String value, BSTNode parent) {
        if (value.compareTo((String) this.getValue()) < 0) {
            if (this.previous != null) {
                return ((BSTNode) this.previous).removeNode(value, this);
            } else {
                return false;   // node not found
            }
        } else if (value.compareTo((String) this.getValue()) > 0) {
            if (this.next != null) {
                return ((BSTNode) this.next).removeNode(value, this);
            } else {
                return false;   // node not found
            }
        } else {
            if (this.previous != null && this.next != null) {
                this.value = ((BSTNode) this.next).findSuccessor(); // right child of current value (this.value) used to invoke method
                ((BSTNode) this.next).removeNode((String) this.value, this);
            } else if (parent.previous == this) {
                parent.previous = (this.previous != null) ? this.previous : this.next;
            } else if (parent.next == this) {
                parent.next = (this.previous != null) ? this.previous : this.next;
            }
            return true;
        }
    }

    /**
     * Recursive method to find and return the lowest value successor node.
     * @return (recursively) the left child (previous) until value is null
     */
    private String findSuccessor() {
        if (this.previous == null) {
            return (String) this.value;
        }
        return ((BSTNode) this.previous).findSuccessor(); // left child of parent successor used to invoke method
    }

    @Override
    public String toString() {
        return "BSTNode{" +
                "next=" + next +
                ", previous=" + previous +
                ", value=" + value +
                '}';
    }
}
