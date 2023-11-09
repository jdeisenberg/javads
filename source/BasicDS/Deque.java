import java.util.ArrayList;
import java.util.NoSuchElementException;

class Deque<T> {

    ArrayList<T> items;

    public Deque() {
        this.items = new ArrayList<T>();
    }

    public boolean isEmpty() {
        return (this.items.isEmpty());
    }

    public void addHead(T item) {
        this.items.add(item);
    }

    public void addTail(T item) {
        this.items.add(0, item);
    }

    public T removeHead() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Deque is empty.");
        }
        return this.items.remove(this.size() - 1);
    }

    public T removeTail() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Deque is empty.");
        }
        return this.items.remove(0);
    }

    public T peekHead() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Deque is empty.");
        }
        return this.items.get(this.size() - 1);
    }

    public T peekTail() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Deque is empty.");
        }
        return this.items.get(0);
    }

    public int size() {
        return this.items.size();
    }

    public String toString() {
        if (!this.items.isEmpty()) {
            String arrString = this.items.toString();
            return "tail " + arrString + " head";
        } else {
            return "<<empty deque>>";
        }
    }
}
