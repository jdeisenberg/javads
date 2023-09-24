import java.util.Iterator;

public class Testor implements Iterator<Integer>, Iterable<Integer> {

    Integer value;
    
    public Testor() {
       // value = 1;
    }
    
    public Iterator<Integer> iterator() {
        this.value = 1;
        return this;
    }
 
    public boolean hasNext() {
        return (value < 128);
    }
    
    public Integer next() {
        value *= 2;
        return value;
    }

    public static void main(String[] args) {
        Testor t = new Testor();
        for (Integer i: t) {
            System.out.println(i);
        }
        System.out.println("-------------");
        for (Integer i: t) {
            System.out.println(i);
        }
       
    }
}
