import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Deque<T> {
    
    /*
     * The tail of the deque is at the beginning
     * of the ArrayList; the head is the last item
     */
    ArrayList<T> items;
    
    /*
     * Create a new Deque
     */
    public Deque() {
        this.items = new ArrayList<T>();
    }
    
    /*
     * Returns true if there are no items in the deque;
     * false otherwise.
     */
    public boolean isEmpty() {
        return (this.items.isEmpty());
    }
    
    /*
     * Add an item to the head of the deque
     */
    public void addHead(T item) {
        this.items.add(item);
    }
    
    /*
     * Add an item to the tail of the deque
     */
    public void addTail(T item) {
        this.items.add(0, item);
    }
    
    /*
     * Remove the item at the head of the deque and return it.
     * If the deque is empty, throws an exception.
     */
    public T removeHead() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Deque is empty.");
        }
        return this.items.remove(this.size() - 1);
    }

    /*
     * Remove the item at the tail of the deque and return it.
     * If the deque is empty, throws an exception.
     */
    public T removeTail() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Deque is empty.");
        }
        return this.items.remove(0);
    }

    /*
     * Return the item at the head of the deque, but do not remove it.
     * If the deque is empty, throws an exception.
     */
    public T peekHead() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Deque is empty.");
        }
        return this.items.get(this.size() - 1);
    }
    
    /*
     * Return the item at the tail of the deque, but do not remove it.
     * If the deque is empty, throws an exception.
     */
    public T peekTail() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Deque is empty.");
        }
        return this.items.get(0);
    }

    /*
     * Returns the number of items in the deque.
     */
    public int size() {
        return this.items.size();
    }
    
    /*
     * Convert to string as an array from tail to head
     */
    public String toString() {
        
        if (!this.items.isEmpty()) {
            String arrString = this.items.toString();
            return "tail " + arrString + " head";
        } else {
            return "<<empty deque>>";
        }
    }
}
