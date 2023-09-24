import java.util.ArrayList;

public class HeapifyTest {
    public static void main(String[] args) {
        BinaryHeap<Integer> myHeap = new BinaryHeap<>();
        Integer[] nonHeap = {9, 6, 5, 2, 3};
        
        myHeap.heapify(nonHeap);
        System.out.println(myHeap);
    }
}


