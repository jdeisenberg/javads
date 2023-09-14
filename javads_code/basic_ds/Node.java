public class Node<T> {
    
    public T data;
    public Node next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
    
    public T getData() {
        return this.data;
    }
    
    public void setData(T data) {
        this.data = data;
    }
    
    public Node<T> getNext() {
        return this.next;
    }
    
    public void setNext(Node<T> next) {
        this.next = next;
    }
    
    public String toString() {
        return this.data.toString();
    }
}

