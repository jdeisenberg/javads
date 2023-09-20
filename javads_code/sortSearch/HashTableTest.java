public class HashTableTest{

    public static void main(String[] args) {
        HashTable table = new HashTable();
        table.put(54, "cat");
        table.put(26, "dog");
        table.put(93, "lion");
        table.put(17, "tiger");
        table.put(77, "bird");
        table.put(31, "cow");
        table.put(44, "goat");
        table.put(55, "pig");
        table.put(20, "chicken");
        System.out.println(table);
        System.out.println();
        
        /* Access and modify elements in the table */
        System.out.println("key 20, value " + table.get(20)); // chicken
        System.out.println("key 17, value " + table.get(17)); // tiger
        System.out.println("key 99, value " + table.get(99)); // null
        
        table.put(20, "duck");
        System.out.println("key 20, value " + table.get(20)); // duck
    }
}
