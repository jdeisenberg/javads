class HashTable {
    int size;
    Integer[] slots;
    String[] data;
    
    public HashTable() {
        this.size = 11;
        this.slots = new Integer[this.size];
        this.data = new String[this.size];
    }
    
    public String toString() {
        String result = "{\n";
        for (int i = 0; i < slots.length; i++) {
            result = result + "  " + slots[i];
            if (slots[i] != null) {
                result = result + " --> " + data[i];
            }
            result = result + "\n";
        }
        result = result + "}";
        return result;
    }
    
    
    public void put(Integer key, String value) {
        int hashSlot = hashFunction(key, slots.length);
        if (slots[hashSlot] == null) {
            slots[hashSlot] = key;
            data[hashSlot] = value;
        } else {
            while (slots[hashSlot] != null && !(slots[hashSlot].equals(key))) {
                hashSlot = rehash(hashSlot, slots.length);
            }
            if (slots[hashSlot] == null) {
                slots[hashSlot] = key;
                data[hashSlot] = value;
            } else {
                data[hashSlot] = value;
            }
        }
    }
    

    private int hashFunction(Integer key, int size) {
        return key % size;
    }
    
    private int rehash(int oldHash, int size) {
        return (oldHash + 1) % size;
    }

    public String get(Integer key) {
        int startSlot = hashFunction(key, slots.length);
        int position = startSlot;
        
        while (slots[position] != null) {
            if (slots[position].equals(key)) {
                return data[position];
            } else {
                position = rehash(position, slots.length);
                if (position == startSlot) {
                    return null;
                }
            }
        }
        return null;
    }
}

