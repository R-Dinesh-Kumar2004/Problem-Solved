class LRUCache {
    class Node{
        int key,val;
        Node prev,next;
        Node(int key,int val){
            this.key = key;
            this.val = val;
            this.prev = this.next = null; 
        }
    }
    Node head,tail;
    int capacity;
    Map<Integer,Node> hm;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        hm = new HashMap<>();
    }
    
    public int get(int key) {
        if(!hm.containsKey(key)) return -1;
        Node node = hm.get(key);
        deleteNode(node);
        addFront(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node node = hm.get(key);
            node.val = value;
            deleteNode(node);
            addFront(node);
        }
        else{
            if(hm.size() == capacity){
                Node node = tail.prev;
                hm.remove(node.key);
                deleteNode(node);
            }
            Node node = new Node(key,value);
            hm.put(key,node);
            addFront(node);
        }
    }

    public void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addFront(Node node){
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        node.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */