public class DequeTest {
    
    /*
     * Show the operation, its result (if any), and the resulting deque
     */
    public static void display(String operation, String result, Deque d) {
        System.out.printf("%-17s | %-7s | %s%n", operation, result,
            d.toString());
    }

    public static void main(String[] args) {
    
        Deque<Integer> d = new Deque<>();
        display("d.isEmpty()", Boolean.toString(d.isEmpty()), d);
        
        d.addTail(4);
        display("d.addTail(4)", "", d);
            
        d.addTail(505);
        display("d.addTail(505)", "", d);
            
        d.addHead(1066);
        display("d.addHead(1066)", "", d);

        d.addHead(4711);
        display("d.addHead(4711)", "", d);
            
        display("d.size", Integer.toString(d.size()), d);
       
        display("d.isEmpty()", Boolean.toString(d.isEmpty()), d);
        
        d.addTail(217);
        display("d.addTail(217)", "", d);
        
        Integer value = d.removeTail();
        display("d.removeTail()", Integer.toString(value), d);
        
        value = d.removeHead();
        display("d.removeHead()", Integer.toString(value), d);
        
    }
}
/*


      <row>
        <cell><c>d.addTail(217)</c></cell>
        <cell><c>[217, 505, 4, 1066, 4711]</c></cell>
        <cell></cell>
      </row>
      <row>
        <cell><c>d.removeTail()</c></cell>
        <cell><c>[505, 4, 1066, 4711]</c></cell>
        <cell><c>217</c></cell>
      </row>
      <row>
        <cell><c>d.removeHead()</c></cell>
*/
