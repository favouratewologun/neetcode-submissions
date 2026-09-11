class KthLargest {

    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int myK = 0;

    public KthLargest(int k, int[] nums) {
        myK = k;
        for (int i = 0; i < nums.length; i++) {
            if (heap.size() < k)
                heap.add(nums[i]);
            else {
                if (nums[i] > heap.peek()) {
                    heap.poll();
                    heap.add(nums[i]);
                }

            }
        }
        
    }
    
    public int add(int val) {
        if (heap.peek() == null || heap.size() < myK)
            heap.add(val);
        else if (val > heap.peek()) {
            heap.poll();
            heap.add(val);
        }
        return heap.peek();
        
    }
}
