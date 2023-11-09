import java.util.ArrayList;
import java.util.NoSuchElementException;

class Queue<T> {

    ArrayList<T> items;

    public Queue() {
        this.items = new ArrayList<T>();
    }

    public boolean isEmpty() {
        return (this.items.isEmpty());
    }

    public void enqueue(T item) {
        this.items.add(0, item);
    }

    public T dequeue() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return this.items.remove(this.size() - 1);
    }

    public T peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return this.items.get(this.size() - 1);
    }

    public int size() {
        return this.items.size();
    }

    public String toString() {

        if (!this.items.isEmpty()) {
            String arrString = this.items.toString();
            return "tail ->" + arrString + "-> head";
        } else {
            return "<<empty queue>>";
        }
    }
}
