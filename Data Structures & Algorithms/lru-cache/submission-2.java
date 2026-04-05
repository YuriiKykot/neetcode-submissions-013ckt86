class LRUCache {

    Map<Integer,Integer> map;
    Queue<Integer> q;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.q = new LinkedList<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            q.remove(key);
            q.offer(key);
            return map.get(key);
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            q.remove(key);
            q.offer(key);
        } else {
            map.put(key, value);
            q.offer(key);
            if (map.size() > capacity) {
                int oldest = q.poll();
                map.remove(oldest);
            }
        }
    }
}
