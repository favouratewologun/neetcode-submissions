class Solution {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // for (int num : nums)
        //     maxHeap.add(num);


        // for (int i = 0; i < k - 1; i++) {
        //     maxHeap.poll();
        // }

        // return maxHeap.poll();

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
            if (minHeap.size() > k)
                minHeap.poll();
            
        }

        return minHeap.poll();
        
    }
}
