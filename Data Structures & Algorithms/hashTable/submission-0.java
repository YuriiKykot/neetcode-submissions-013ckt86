class HashTable {
    // Пара (key, value)
    private static class Pair {
        final int key;
        int value;
        Pair(int k, int v) { key = k; value = v; }
    }

    private int size;                 // скільки ключів збережено
    private int capacity;             // кількість відер (buckets)
    private List<List<Pair>> buckets; // відра з ланцюжками

    public HashTable(int capacity) {
        if (capacity <= 1) throw new IllegalArgumentException("capacity > 1");
        this.capacity = capacity;
        this.size = 0;
        this.buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) buckets.add(new LinkedList<>());
    }

    // індекс відра
    private int idx(int key) {
        return (key & 0x7fffffff) % capacity; // гарантуємо невід’ємність
    }

    public int get(int key) {
        List<Pair> bucket = buckets.get(idx(key));
        for (Pair p : bucket) {
            if (p.key == key) return p.value;
        }
        return -1;
    }

    public void insert(int key, int value) {
        List<Pair> bucket = buckets.get(idx(key));
        for (Pair p : bucket) {
            if (p.key == key) {            // оновлення існуючого
                p.value = value;
                return;
            }
        }
        bucket.add(new Pair(key, value));  // новий ключ
        size++;

        if (loadFactor() >= 0.5) resize(); // авто-розширення
    }

    public boolean remove(int key) {
        List<Pair> bucket = buckets.get(idx(key));
        Iterator<Pair> it = bucket.iterator();
        while (it.hasNext()) {
            Pair p = it.next();
            if (p.key == key) {
                it.remove();
                size--;
                return true;
            }
        }
        return false;
    }

    public int getSize() { return size; }
    public int getCapacity() { return capacity; }

    // подвоєння capacity + повний rehash
    public void resize() {
        int newCap = capacity * 2;
        List<List<Pair>> newBuckets = new ArrayList<>(newCap);
        for (int i = 0; i < newCap; i++) newBuckets.add(new LinkedList<>());

        // ре-хеш усіх пар
        for (List<Pair> bucket : buckets) {
            for (Pair p : bucket) {
                int newIdx = (p.key & 0x7fffffff) % newCap;
                newBuckets.get(newIdx).add(new Pair(p.key, p.value));
            }
        }

        this.capacity = newCap;
        this.buckets = newBuckets;
        // size не змінюється
    }

    private double loadFactor() {
        return (double) size / capacity;
    }
}
