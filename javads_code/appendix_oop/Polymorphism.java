public class Polymorphism {
    public static void main(String[] args) {
        Item item1 = new Item("Cat Food", "CF-909", 7.85);
        Item item2 = new SaleItem("Lima Beans", "LB-104",
            5.95, 0.075);
            
        // SaleItem badNews = new Item("Oops", "X-001", 6.66);
            
        System.out.println("item 1: " + item1);
        System.out.println("item 2: " + item2);
    }
}
