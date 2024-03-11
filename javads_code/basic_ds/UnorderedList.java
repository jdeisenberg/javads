public class UnorderedList<T> {
    
    private Node<T> head;
    
    /* Construct an empty list */
    public UnorderedList() {
        head = null;
    }
    
    /* Returns the head of the list */
    public Node<T> getHead() {
        return this.head;
    }
    
    /* Sets the head of the list to the given Node */
    public void setHead(Node<T> newHead) {
        this.head = newHead;
    }
    
    /* Return true if list is empty, false otherwise */
    public boolean isEmpty() {
        return this.head == null;
    }
    
    /*
     * Add given item at the head of the list.
     * Presume that the item is not already in the list.
     */
    public void add(T item) {
        Node<T> temp = new Node<T>(item);
        temp.setNext(this.head);
        this.head = temp;
    }
    
    /* Return the number of items in the list */
    public int size() {
        Node<T> current = this.head;
        int count = 0;
        while (current != null) {
            count = count + 1;
            current = current.getNext();
        }
        return count;
    }
    
    /*
     * Check to see if the given item is in the list.
     * Return true if it is, false if not.
     */
    public boolean search(T item) {
        Node<T> current = this.head;
        while (current != null) {
            if (current.getData().equals(item)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /*
     * Remove the given item from the list.
     * Leave list unchanged if the item is not in the list
     */
    public void remove(T item) {
        Node<T> current = this.head;
        Node<T> previous = null;
        
        while (current != null && (!current.getData().equals(item))) {
            previous = current;
            current = current.getNext();
        }
        
        if (current != null) {
			if (previous == null) {
				this.head = current.getNext();
			} else {
				previous.setNext(current.getNext());
			}
		}
    }

    /*
     * Convert the list to a comma-separated series of
     * values in brackets, starting with the head of the list.
     */
    public String toString() {
        String result = "[";
        Node<T> current = this.head;
        while (current != null) {
            result = result + current.getData().toString();
            current = current.getNext();
            if (current != null) {
                result = result + ", ";
            }
        }
        result = result + "]";
        return result;
    }
}

