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
        
        System.out.println("Size of table: " + table.size());
        
        System.out.println("Is 99 a key? " + table.containsKey(99));
        System.out.println("Is 20 a key? " + table.containsKey(20));
        
        String removed = table.remove(44);
        System.out.println("Removal of key 44 with value " + removed);
        System.out.println("Is 44 a key? " + table.containsKey(44));
        
        System.out.println();
        System.out.println("End status:");
        System.out.println(table);
        
        
    }
}
