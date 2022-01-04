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

    public ListItem(ListItem next, ListItem previous, Object value) {
        this.next = next;
        this.previous = previous;
        this.value = value;
    }

    // getters

    public ListItem getNext() {
        return next;
    }

    public ListItem getPrevious() {
        return previous;
    }

    public Object getValue() {
        return value;
    }

    // abstract methods

    abstract ListItem moveToNextItem();
    abstract ListItem moveToPreviousItem();
    //abstract void setNextItem(ListItem item);
    abstract ListItem setNextItem(ListItem item);
    //abstract void setPreviousItem(ListItem item);
    abstract ListItem setPreviousItem(ListItem item);
    abstract int compareTo(ListItem item);
}
