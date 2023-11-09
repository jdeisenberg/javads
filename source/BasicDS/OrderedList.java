class OrderedList<T extends Comparable<T>> extends UnorderedList<T> {

    public OrderedList() {
        super();
    }

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

    public boolean search(T item) {
        Node<T> current = this.getHead();
        while (current != null) {
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
