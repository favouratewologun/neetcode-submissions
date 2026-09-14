class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frqs = new HashMap<>();

        for (int num : nums)
            frqs.put(num, frqs.getOrDefault(num, 0) + 1);

        ArrayList<Integer>[] counts = new ArrayList[nums.length + 1];
        for (int i = 0; i < counts.length; i++)
            counts[i] = new ArrayList<>();

        for (Map.Entry<Integer, Integer> e : frqs.entrySet()) {
            counts[e.getValue()].add(e.getKey());
        }

        int ind = 0;
        int[] res = new int[k];

        for (int i = counts.length - 1; i >= 0; i--) {
            for (int num : counts[i]) {
                res[ind++] = num;
                if (ind == k)
                    return res;
            }

        }

        return new int[1];
        
        
    }
}
