class Solution {
    public int findKthLargest(int[] nums, int k) {
        //create a priority queue of size k, all first k elements quickly

        //then for every element after, see if bigger than curr min, if so add, if not continue

        //then return min

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }

        return pq.peek();
        
    }
}
