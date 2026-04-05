class Deque {

    class Node{
        int val;
        Node next;
        Node prev;
        public Node(int val, Node next, Node prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    Node head;
    Node tail;
    int size = 0;

    public Deque() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void append(int value) {
       Node appendNode = new Node(value, null, tail);
       if(tail != null) tail.next = appendNode;
       if(head == null) head = appendNode;
       tail = appendNode;
       size++;
    }

    public void appendleft(int value) {
        Node appendNode = new Node(value, head, null);
        if(head != null) head.prev = appendNode;
        if(tail == null) tail = appendNode;
        head = appendNode;
        size++;
    }

    public int pop() {
        if(size == 0) return -1;
        Node remove = tail;
        tail = remove.prev;
        if(tail != null) tail.next = null;
        remove.prev = null;
        size--;
        return remove.val;
    }

    public int popleft() {
        if(size == 0) return -1;
        Node remove = head;
        head = remove.next;
        if(head != null) head.prev = null;
        remove.next = null;
        size--;
        return remove.val;
    }
}
