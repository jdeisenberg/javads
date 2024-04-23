public class HashTableTest{

    public static void main(String[] args) {
        HashTable table = new HashTable();
        table.put(61820, "Champaign IL");  // %11 = 0
        table.put(48658, "Stanidsh MI");   // %11 = 5
        table.put(18222, "Drums PA");      // %11 = 6
        table.put(75394, "Dallas TX");     // %11 = 0
        table.put(83344, "Murtaugh ID");   // %11 = 8
        table.put(32157, "Lake Como FL");  // %11 = 4
        table.put(25101, "Cumberland MD"); // %11 = 10
        table.put(74457, "Proctor OK");    // %11 = 9
        table.put(24002, "Roanoke VA");    // %11 = 0
        table.put(46957, "Matthews IN");   // %11 = 9
        System.out.println(table);
        System.out.println();

        /* Access and modify elements in the table */
        System.out.println("key 32157, value " + table.get(32157)); // Lake Como
        System.out.println("key 61820, value " + table.get(61820)); // Champaign
        System.out.println("key 95135, value " + table.get(95135)); // null

        table.put(48658, "Standish MI");
        System.out.println("key 48658, value " + table.get(48658)); // Standish
    }
}

