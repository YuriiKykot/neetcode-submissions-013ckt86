class TimeMap {
    Map<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair p = new Pair(timestamp,value);
        if(map.containsKey(key)){
            map.get(key).add(p);
        }else{
            List<Pair<Integer, String>> l = new ArrayList<>();
            l.add(p);
            map.put(key,l);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        List<Pair<Integer, String>> l = map.get(key);
        int left = 0, right = l.size() - 1;

        String res = "";

        while(left <= right){
            int mid = left + (right - left) / 2;

            if (l.get(mid).getKey() <= timestamp){ 
                res = l.get(mid).getValue();
                left = mid + 1;
                
            }else right = mid - 1;
        }

        return res;
    }

    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
