import java.util.ArrayList;
import java.util.NoSuchElementException;


public class Stack<T> {
    
    /*
     * The top of the stack is at the beginning
     * of the ArrayList.
     */
    ArrayList<T> items;
    
    /*
     * Create a new stack
     */
    public Stack() {
        this.items = new ArrayList<T>();
    }
    
    /*
     * Returns true if there are no items on the stack;
     * false otherwise.
     */
    public boolean isEmpty() {
        return (this.items.isEmpty());
    }
    
    /*
     * Pushes given item on the top of the stack
     */
    public void push(T item) {
        this.items.add(0, item);
    }
    
    /*
     * Removes the item on top of the stack and returns it.
     * If the stack is empty, throws an exception.
     */
    public T pop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return this.items.remove(0);
    }
    
    /*
     * Returns the item on top of the stack without removing it.
     * If the stack is empty, throws an exception.
     */
    public T peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return this.items.get(0);
    }
    
    /*
     * Returns the number of items on the stack.
     */
    public int size() {
        return this.items.size();
    }
    
    /*
     * Convert to string as an array from top to bottom
     */
    public String toString() {
        
        if (!this.items.isEmpty()) {
            String arrString = this.items.toString();
            // remove open and closing bracket
            return "top ->" + arrString + "<- bottom";
        } else {
            return "<<empty stack>>";
        }
    }
}
