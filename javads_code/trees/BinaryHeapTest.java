public class BinaryHeapTest {
    public static void main(String[] args) {
        BinaryHeap<Integer> myHeap = new BinaryHeap<>();
        myHeap.insert(5);
        myHeap.insert(7);
        myHeap.insert(3);
        myHeap.insert(11);
        System.out.println("Min value: " + myHeap.getMin());
        System.out.println("Size: " + myHeap.size());
        
        System.out.println("Deleting items: ");
        System.out.println(myHeap.delete());
        System.out.println(myHeap.delete());
        System.out.println(myHeap.delete());
        System.out.println(myHeap.delete());
    }
}


