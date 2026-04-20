class MyCircularQueue {
    private int size;
    private Node head;
    private Node tail;

    public MyCircularQueue(int k) {
        this.size = k;
        this.head = new Node(0);
        this.tail = head;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;

        Node cur = new Node(value);

        if(isEmpty()){
            this.tail.next = cur;
            this.head = cur;
        }else{
            this.head.next = cur;
            this.head = cur;
        }

        this.size--;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;

        this.tail.next = this.tail.next.next;
        if(this.tail.next == null){
            this.head = this.tail;
        }


        this.size++;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;

        return tail.next.val;
    }
    
    public int Rear() {
        if(isEmpty()) return -1;

        return this.head.val;
    }
    
    public boolean isEmpty() {
        return this.tail.next == null;
    }
    
    public boolean isFull() {
        return this.size == 0;
    }

    class Node{
        public int val;
        public Node next;

        public Node(){}

        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */