import java.util.HashMap;

public class HashMapExample {

    public static void main(String[] args) {
        
        HashMap<String, Integer> cityInfo = new HashMap<>();
        cityInfo.put("New York City", 7_888_121);
        cityInfo.put("Tokyo", 13_515_271);
        cityInfo.put("Dhaka", 8_906_039);
        cityInfo.put("Luanda", 2_165_867);
        
        System.out.println(cityInfo);
        for (String key: cityInfo.keySet()) {
            System.out.format("Key %s has value %,d.%n",
                key, cityInfo.get(key));
        }
            
    }
}

