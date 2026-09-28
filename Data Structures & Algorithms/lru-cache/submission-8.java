class LRUCache {

    public class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    HashMap<Integer, Node> cache;
    int capacity;
    Node first;
    Node last;  

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        //create head and tail nodes, all data nodes bw these
        first = new Node(-1, -1);
        last = new Node(-1, -1);
        first.next = last;
        last.prev = first;
        
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            //remove from current pos
            Node updated = cache.get(key);
            updated.prev.next = updated.next;
            updated.next.prev = updated.prev;
            
            //add to end
            last.prev.next = updated;
            updated.prev = last.prev;
            last.prev = updated;
            updated.next = last;

            return cache.get(key).val;
        }

        return -1;
        
    }
    
    public void put(int key, int value) {
        //need case for if cache contains key or if it doesnt
        if (cache.containsKey(key)) { //update val, remove it from curr pos
            Node updated = cache.get(key);
            cache.get(key).val = value;
            updated.prev.next = updated.next;
            updated.next.prev = updated.prev;
            
        } else {
            cache.put(key, new Node(key, value)); //create new node
        }

        //then add it to the end   
        Node updated = cache.get(key);
        last.prev.next = updated;
        updated.prev = last.prev;
        last.prev = updated;
        updated.next = last;
        updated.val = value;
        
        if (cache.size() > capacity) { //added smth new, need reduce
            Node removed = first.next;
            cache.remove(removed.key);
            first.next = first.next.next; //move ahead
            first.next.prev = first;

        }
    }
}
