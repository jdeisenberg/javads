import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Queue<T> {
    
    /*
     * The tail of the queue is at the beginning
     * of the ArrayList; the head is the last item
     */
    ArrayList<T> items;
    
    /*
     * Create a new Queue
     */
    public Queue() {
        this.items = new ArrayList<T>();
    }
    
    /*
     * Returns true if there are no items in the queue;
     * false otherwise.
     */
    public boolean isEmpty() {
        return (this.items.isEmpty());
    }
    
    /*
     * Add an item to the tail of the queue
     */
    public void enqueue(T item) {
        this.items.add(0, item);
    }
    
    /*
     * Remove the item at the head of the queue and return it.
     * If the queue is empty, throws an exception.
     */
    public T dequeue() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return this.items.remove(this.size() - 1);
    }

    /*
     * Return the item at the head of the queue, but do not remove it.
     * If the queue is empty, throws an exception.
     */
    public T peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return this.items.get(this.size() - 1);
    }
    
    /*
     * Returns the number of items in the queue.
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
            return "tail ->" + arrString + "-> head";
        } else {
            return "<<empty queue>>";
        }
    }
}
