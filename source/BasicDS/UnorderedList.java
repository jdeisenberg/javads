class UnorderedList<T> {

    private Node<T> head;

    public UnorderedList() {
        head = null;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public void setHead(Node<T> newHead) {
        this.head = newHead;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void add(T item) {
        Node<T> temp = new Node<T>(item);
        temp.setNext(this.head);
        this.head = temp;
    }

    public int size() {
        Node<T> current = this.head;
        int count = 0;
        while (current != null) {
            count = count + 1;
            current = current.getNext();
        }
        return count;
    }

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

    public void remove(T item) {
        Node<T> current = this.head;
        Node<T> previous = null;

        while (current != null && (!current.getData().equals(item))) {
            previous = current;
            current = current.getNext();
        }
        if (current == null) {
            throw new java.util.NoSuchElementException(
                item + " is not in  the list.");
        }

        if (previous == null) {
            this.head = current.getNext();
        } else {
            previous.setNext(current.getNext());
        }
    }

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
