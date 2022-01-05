package domain;

public abstract class ListItem {

    // member fields

    protected ListItem next;
    protected ListItem previous;
    protected Object value;

    // constructor

    public ListItem(Object value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    // getters

    public Object getValue() {
        return value;
    }

    // abstract methods

    abstract ListItem moveToNextItem();
    abstract ListItem moveToPreviousItem();
    abstract ListItem setNextItem(ListItem item);
    abstract ListItem setPreviousItem(ListItem item);
    abstract int compareTo(ListItem item);
}
