public class TestOrderedList {
    
    public static void main(String[] args) {
        OrderedList<Integer> myList = new OrderedList<>();
        
        System.out.println("Is list empty? " + myList.isEmpty());
        myList.add(505);
        myList.add(217);
        myList.add(1066);
        System.out.println("After adding 505, 217, and 1066: " + myList);
        System.out.println("Is 505 in the list? " + myList.search(505));
        System.out.println("Is 300 in the list? " + myList.search(300));
    }
}
