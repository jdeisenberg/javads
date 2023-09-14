public class StackTest1 {

    public static void main(String[] args) {
    
        Stack<String> s = new Stack<>();
        System.out.println("isEmpty returns " + s.isEmpty());
        
        s.push("java");
        s.push("keyboard");
        System.out.println("Top of stack is " + s.peek());
        s.push("computer");
        System.out.println("Size of stack is " + s.size());
        System.out.println("Current stack is: " + s);
        
        s.push("program");
        System.out.println("Current stack is: " + s);
        
        System.out.println("Pop: " + s.pop());
        System.out.println("Pop: " + s.pop());
        
        System.out.println("Size of stack is " + s.size());
        System.out.println("Current stack is: " + s);
    }
}
