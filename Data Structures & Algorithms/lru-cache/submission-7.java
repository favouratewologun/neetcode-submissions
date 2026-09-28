class LRUCache {
    //need a queue to keep track of recent uses?
    //poll from the queue if = to whats being used

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
        // usage = new LinkedList<>();
        this.capacity = capacity;
        first = new Node(-1, -1);
        last = new Node(-1, -1);
        first.next = last;
        last.prev = first;
        
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node updated = cache.get(key);
            updated.prev.next = updated.next;
            updated.next.prev = updated.prev;
            
            last.prev.next = updated;
            updated.prev = last.prev;
            last.prev = updated;
            updated.next = last;

            return cache.get(key).val;
        }

        return -1;

        //considered used if get or put operation called
        
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

        //then add it to cache (.put, and move to end)   
        Node updated = cache.get(key);
        last.prev.next = updated;
        updated.prev = last.prev;
        last.prev = updated;
        updated.next = last;
        updated.val = value;

        // cache.put(key, value);
        
        if (cache.size() > capacity) { //added smth new, need reduce
            Node removed = first.next;
            cache.remove(removed.key);
            first.next = first.next.next; //move ahead
            first.next.prev = first;
            //remove least recently used.
            //updated.removeFirst();
            // int removedK = queue.poll(); //get least used key
            // //might have to remove until peek = key, and then remove that again?
            // cache.remove(removedK); //remove least used key-value from cache
        }

        //  //might need an else or smth
        // else if (queue.size() > 0 && queue.peek() == key)
        //     queue.poll(); //remove from back of recently used if updated key
               
        // updated.offer(key);
    }
}
