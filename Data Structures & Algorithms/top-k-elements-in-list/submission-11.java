class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frqs = new HashMap<>();

        for (int num : nums) {
            frqs.put(num, frqs.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList();
        }

        for (Map.Entry<Integer, Integer> e : frqs.entrySet()) {
            buckets[e.getValue()].add(e.getKey());
        }

        int[] result = new int[k];
        int count = 0;

        for (int i = buckets.length - 1; i >= 0; i--) {
            for (int num : buckets[i]) {
                result[count++] = num;
                if (count == k)
                    return result;
            }
        }

        return new int[k];
        
    }
}
