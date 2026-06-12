class LRUCache {

    Map<Integer, Integer> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        int value = map.get(key);
        map.remove(key);
        map.put(key, value);
        return value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else if (map.size() >= this.capacity) {
            // Remove the least recently used item (the first in the LinkedHashMap)
            map.remove(map.keySet().iterator().next());
        }
        map.put(key, value);
    }
}
