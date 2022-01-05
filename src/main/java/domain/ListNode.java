package domain;

public class ListNode extends ListItem {

    public ListNode(Object value) {
        super(value);
    }

    public ListNode(ListItem next, ListItem previous, Object value) {
        super(next, previous, value);
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
        if (item != null) {
            return ((String) super.getValue()).compareTo((String) item.getValue());
        } else {
            return -1;
        }
    }

    public boolean removeNode(String item) {
        return removeNode(this, item);
    }

    private boolean removeNode(ListNode currentNode, String item) {
        if (item.compareTo((String) currentNode.value) < 0) {
            return false;       // item not found
        } else if (item.compareTo((String) currentNode.value) > 0) {
            if (currentNode.next != null) {
                return removeNode((ListNode) currentNode.next, item);
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
}
