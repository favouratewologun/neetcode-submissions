class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap <Integer, Integer> frqs = new HashMap<>();

        for (int num : nums) {
            frqs.put(num, frqs.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (int i = 0; i < buckets.length; i++) {
            ArrayList<Integer> myList = new ArrayList<>();
            buckets[i] = myList;
        }

        for (Map.Entry<Integer, Integer> e : frqs.entrySet()) {
            buckets[e.getValue()].add(e.getKey());
        }

        int[] result = new int[k];

        int count = 0;
        //if last element != 0, then we've filled

        for (int i = nums.length; i >= 0; i--) {
            for (int j : buckets[i]) {
                result[count++] = j;
            }

            if (count == k)
                return result;
        }


        return new int [1];
        
    }
}
