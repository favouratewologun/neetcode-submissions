class KthLargest {
    PriorityQueue<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            if (heap.isEmpty() || heap.size() < k )
                heap.add(num);
            else if (heap.size() == k && num > heap.peek()) {
                heap.add(num);
                heap.poll();
            }
            
        }
        
    }
    
    public int add(int val) {
        if (heap.isEmpty() || heap.size() < k ) {
            heap.add(val);
            return heap.peek();
        }
            
        else if (heap.size() == k && val > heap.peek()) {
            heap.add(val);
            heap.poll();
            return heap.peek();
        } else
            return heap.peek(); //val < heap.peek, dont need to add it


            
        

        // return 0;
    
    }
}
