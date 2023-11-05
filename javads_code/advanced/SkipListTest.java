
class SLNode<K extends Comparable<K>, V> {
    private SLNode<K, V> next;
    private SLNode<K, V> down;
    private K key;
    private V value;
    
    public SLNode() {
        this.next = null;
        this.down = null;
        this.key = null;
        this.value = null;
    }
    
    public SLNode(K key, V value) {
        this.next = null;
        this.down = null;
        this.key = key;
        this.value = value;
    }
    
    public SLNode<K, V> getNext() {
        return this.next;
    }
    
    public void setNext(SLNode<K, V> next) {
        this.next = next;
    }
    
    public SLNode<K, V> getDown() {
        return this.down;
    }
    
    public void setDown(SLNode<K, V> down) {
        this.down = down;
    }

    public K getKey() {
        return this.key;
    }
    
    public V getValue() {
        return this.value;
    }
    
}

class SkipList<K extends Comparable<K>, V> {
    private SLNode<K, V> head;
    
    public SkipList() {
        this.head = null;
    }
    
    public SLNode<K, V> getHead() {
        return this.head;
    }
    
    public void setHead(SLNode<K, V> head) {
        this.head = head;
    }
    
    public V search(K key) {
        SLNode<K, V> current = this.head;
        while (current != null) {
            if (current.getNext() == null) {
                current = current.getDown();
            } else {
                K testKey = current.getNext().getKey();
                if (testKey.equals(key)) {
                    return current.getNext().getValue();
                }
                if (key.compareTo(testKey) < 0) {
                    current = current.getDown();
                } else {
                    current = current.getNext();
                }
            }
        }
        return null;
    }
    
    public void insert(K key, V value) {
        SLNode<K, V> temp;
        SLNode<K, V> top;
        SLNode<K, V> newHead;

        if (head == null) {
            this.head = new SLNode<K, V>();
            temp = new SLNode<K, V>(key, value);
            this.head.setNext(temp);
            top = temp;
            while ((int) (Math.random() * 2) == 1) {
                newHead = new SLNode<K, V>();
                temp = new SLNode<K, V>(key, value);
                temp.setDown(top);
                newHead.setNext(temp);
                newHead.setDown(this.head);
                this.head = newHead;
                top = temp;
            }
        } else {
            Stack<SLNode<K, V>> tower = new Stack<>();
            SLNode<K, V> current = this.head;
            while (current != null) {
                if (current.getNext() == null) {
                    tower.push(current);
                    current = current.getDown();
                } else {
                    if (current.getNext().getKey().compareTo(key) > 0) {
                        tower.push(current);
                        current = current.getDown();
                    } else {
                        current = current.getNext();
                    }
                }
            }
                        
            SLNode<K, V> lowestLevel = tower.pop();
            temp = new SLNode<>(key, value);
            temp.setNext(lowestLevel.getNext());
            lowestLevel.setNext(temp);
            top = temp;
            
            while ((int) (Math.random() * 2) == 1) {
                if (tower.isEmpty()) {
                    newHead = new SLNode<K, V>();
                    temp = new SLNode<K, V>(key, value);
                    temp.setDown(top);
                    newHead.setNext(temp);
                    newHead.setDown(this.head);
                    this.setHead(newHead);
                    top = temp;
                } else {
                    SLNode<K, V> nextLevel = tower.pop();
                    temp = new SLNode<K, V>(key, value);
                    temp.setDown(top);
                    temp.setNext(nextLevel.getNext());
                    nextLevel.setNext(temp);
                    top = temp;
                }
            }
        }
    }
    
    public void display() {
        SLNode<K, V> vertical = this.head;
        while (vertical != null) {
            System.out.print( "| --> ");
            SLNode<K, V> horizontal = vertical.getNext();
            while (horizontal != null) {
                System.out.print(horizontal.getKey().toString() + ": " +
                    horizontal.getValue().toString());
                horizontal = horizontal.getNext();
                if (horizontal != null) {
                    System.out.print(" --> ");
                }
            }
            System.out.println();
            vertical = vertical.getDown();
        }
    }
}

class Map<K extends Comparable<K>, V> {
    private SkipList<K, V> collection;
    
    public Map() {
        this.collection = new SkipList<K, V>();
    }
    
    public void put(K key, V value) {
        this.collection.insert(key, value);
    }
    
    public V get(K key) {
        return this.collection.search(key);
    }
    
    public SkipList<K, V> getCollection() {
        return this.collection;
    }
}

public class SkipListTest {
    public static void main(String[] args) {
        Map<Integer, String> myMap = new Map<>();
        myMap.put(26, "at");
        myMap.put(54, "it");
        myMap.put(93, "be");
        myMap.put(31, "or");
        myMap.put(17, "by");
        myMap.put(77, "of");
        myMap.getCollection().display();
    }
}
    
