public class QueueTest {

    public static void main(String[] args) {
    
        Queue<Integer> q = new Queue<>();
        System.out.println("isEmpty returns " + q.isEmpty());
        
        q.enqueue(4);
        q.enqueue(27);
        System.out.println("Queue is now: " + q);
        
        q.enqueue(1066);
        System.out.println("After another enqueue, size is " +
            q.size());
        System.out.println("isEmpty now returns " + q.isEmpty());
        
        q.enqueue(4711);

        System.out.println("After another enqueue, queue is " + q);
        
        Integer head = q.dequeue();
        System.out.println("Dequeue - head was: " + head);
        head = q.dequeue();
        System.out.println("Dequeue again - head was: " + head);
        
        
        System.out.println("Queue is now: " + q);
        System.out.println("Size is now: " + q.size());
        
    }
}

