public class OrderedList<T extends Comparable<T>> extends UnorderedList<T> {
    
    // No extra properties in this class; they are inherited from
    // UnorderedList.
    
    /*
     * Call superclass constructor to set the head property
     * to null.
     */
    public OrderedList() {
        super();
    }
    
    /*
     * Add given item at its correct position in the list.
     * Presume that the item is not already in the list.
     */
    public void add(T item) {
        Node<T> current = this.getHead();
        Node<T> previous = null;
        
        while (current != null && (current.getData()).compareTo(item) < 0) {
            previous = current;
            current = current.getNext();
        }
        Node<T> itemNode = new Node<T>(item);

        if (previous == null)
        {
            itemNode.setNext(this.getHead());
            this.setHead(itemNode);
        } else {
            itemNode.setNext(current);
            previous.setNext(itemNode);
        }
    }
    
    /*
     * Check to see if the given item is in the list.
     * Return true if it is, false if not.
     */
    public boolean search(T item) {
        Node<T> current = this.getHead();
        while (current != null) {
            System.out.println("comparing " + current.getData() +
                " and " + item);
            if (current.getData().equals(item)) {
                return true;
            }
            if (current.getData().compareTo(item) > 0) {
                return false;
            }
            current = current.getNext();
        }
        return false;
    }

}
