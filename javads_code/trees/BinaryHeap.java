import java.util.ArrayList;

public class BinaryHeap<T extends Comparable<T>> {
    ArrayList<T> heap;
    
    public BinaryHeap() {
        this.heap = new ArrayList<T>();
    }
    
    private int compareItemsAt(int index1, int index2) {
        return heap.get(index1).compareTo(heap.get(index2));
    }
    
    private void swapItemsAt(int index1, int index2) {
        T temporary = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temporary);
    }
    
    private void percolateUp(int index) {
        while ((index > 0) && (index - 1) / 2 >= 0) {
            int parentIndex = (index - 1) / 2;
            if (compareItemsAt(index, parentIndex) < 0) {
                swapItemsAt(index, parentIndex);
            }
            index = parentIndex;
        }
    }

    public void insert(T item) {
        heap.add(item);
        percolateUp(heap.size() - 1);
    }
    
    private void percolateDown(int index) {
        while (2 * index + 1 < heap.size()) {
            int smallerChild = getSmallerChild(index);
            if (compareItemsAt(index, smallerChild) > 0) {
                swapItemsAt(index, smallerChild);
            } else {
                break;
            }
            index = smallerChild;
        }
    }
    
    private int getSmallerChild(int index) {
        if (2 * index + 2 > heap.size() - 1) {
            return 2 * index + 1;
        }
        if (compareItemsAt(2 * index + 1, 2 * index + 2) < 0) {
            return 2 * index + 1;
        }
        return 2 * index + 2;
    }

    public T delete() {
        T result = heap.get(0);
        swapItemsAt(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        percolateDown(0);
        return result;
    }
    
    public void heapify(T[] nonHeap) {
        heap = new ArrayList<T>(); // eliminate old data
        
        if (nonHeap.length != 0) {
            // copy non-heap into the new heap
            for (int i = 0; i < nonHeap.length; i++) {
                heap.add(nonHeap[i]);
            }
        
            int currIndex = heap.size() / 2 - 1;
            while (currIndex >= 0) {
                percolateDown(currIndex);
                currIndex = currIndex - 1;
            }
        }
    }
    
    public T getMin() {
        return heap.get(0);
    }
    
    public boolean isEmpty() {
        return heap.size() == 0;
    }
    
    public int size() {
        return heap.size();
    }
    
    public String toString() {
        return heap.toString();
    }
}
