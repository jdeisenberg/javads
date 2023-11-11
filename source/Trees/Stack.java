class Stack<T> {
    ArrayList<T> items;

    public Stack() {
        this.items = new ArrayList<T>();
    }

    public boolean isEmpty() {
        return (this.items.isEmpty());
    }

    public void push(T item) {
        this.items.add(item);
    }

    public T pop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return this.items.remove(items.size() - 1);
    }

    public T peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return this.items.get(items.size() - 1);
    }

    public int size() {
        return this.items.size();
    }

    public String toString() {

        if (!this.items.isEmpty()) {
            String arrString = this.items.toString();
            // remove open and closing bracket
            return "bottom ->" + arrString + "<- top";
        } else {
            return "<<empty stack>>";
        }
    }
}
