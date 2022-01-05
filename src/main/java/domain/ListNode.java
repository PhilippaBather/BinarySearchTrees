package domain;

public class ListNode extends ListItem {

    public ListNode(Object value) {
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
        if (item != null) {
            return ((String) super.getValue()).compareTo((String) item.getValue());
        } else {
            return -1;
        }
    }
}
