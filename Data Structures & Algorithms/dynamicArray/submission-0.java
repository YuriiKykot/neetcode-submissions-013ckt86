class DynamicArray {

    int[] array;
    int size;

    public DynamicArray(int capacity) {
        if (capacity < 0) {
            throw new RuntimeException("Capacity must be non-negative");
        }
        array = new int[capacity];
        size = 0;
    }

    public int get(int i) {
        if (i < size) {
            return array[i];
        }
        throw new RuntimeException("Index out of bounds");
    }


    public void set(int i, int n) {
        if (i < size) {
            array[i] = n;
        } else {
            throw new RuntimeException("Index out of bounds");
        }
    }

    public void pushback(int n) {
        if (size == array.length) {
            resize();
        }
        array[size] = n;
        size++;
    }

    public int popback() {
        if (size == 0) {
            throw new RuntimeException("Array is empty");
        }
        int val = array[size - 1];
        size--;
        return val;
    }

    private void resize() {
        int[] buffer = new int[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            buffer[i] = array[i];
        }
        array = buffer;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return array.length;
    }
}
