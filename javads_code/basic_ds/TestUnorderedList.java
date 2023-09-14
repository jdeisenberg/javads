public class TestUnorderedList {
    public static void main(String[] args) {
        UnorderedList<Integer> myList = new UnorderedList<>();
        System.out.println(myList + " size: " + myList.size());
        myList.add(31);
        myList.add(77);
        myList.add(17);
        myList.add(93);
        myList.add(26);
        myList.add(54);
        System.out.println(myList + " size: " + myList.size());
        
        System.out.println("search for 17 returns " +
            myList.search(17));
        System.out.println("search for 1066 returns " +
            myList.search(1066));
            
        myList.remove(93);
        System.out.println("after removing 93: " + myList);
        
        myList.remove(54); // test removal of first item
        System.out.println("after removing 54: " + myList);
        
        myList.remove(31); // test removal of last item
        System.out.println("after removing 31: " + myList);
        
        try {
            myList.remove(1066);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
