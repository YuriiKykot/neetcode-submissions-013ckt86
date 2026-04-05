class LinkedList {

    Node tail;
    Node head;
    int size = 0;

    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }

    public LinkedList() {
        
    }

    public int get(int index) {
        if(index < 0 || index >= size) return -1;

        Node n = head;
        int i = 0;

        while(n != null){
            if(i == index){
                return n.val;
            }

            i++;
            n = n.next;
        }

        return -1;
    }

    public void insertHead(int val) {
        if(head == null && tail == null){
            Node n = new Node(val);
            this.head = n;
            this.tail = n;
            size++;
            return;
        }

        Node n = new Node(val);
        n.next = head;
        head = n;
        size++;
    }

    public void insertTail(int val) {
        if(head == null && tail == null){
            Node n = new Node(val);
            this.head = n;
            this.tail = n;
            size++;
            return;
        }

        Node n = new Node(val);
        tail.next = n;
        tail = n;
        size++;
    }

    public boolean remove(int index) {
        if(index < 0 || index >= size) return false;
        if(index == 0){
            head = head.next;
            size--;
            return true;
        }
    
        Node n = head;
        int i = 0;

        while(n != null){
            if(i+1 == index){
                Node toRemove = n.next;
                if(toRemove.next == null){
                    tail = n;
                    size--;
                    return true;
                }else{
                    n.next = toRemove.next;
                    toRemove.next = null;
                    size--;
                    return true;
                }
            }

            i++;
            n = n.next;
        }

        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> result = new ArrayList<>();

        Node n = head;

        while(n != null){
            result.add(n.val);
            n = n.next;
        }

        return result;
    }
}
