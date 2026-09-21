class Solution {
    public int[] topKFrequent(int[] nums, int k) {


        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        ArrayList<Integer>[] freqs = new ArrayList[nums.length + 1];
        for (int i = 0; i < freqs.length; i++)
            freqs[i] = new ArrayList<Integer>();

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            freqs[e.getValue()].add(e.getKey());
        } 

        int ind = 0;
        int[] res = new int[k];
        for (int i = freqs.length - 1; i >= 0; i--) {
            for (int num : freqs[i]) {
                res[ind++] = num;
                if (ind == k)
                    return res;
            }
        }
        
        return res;
    }
}
