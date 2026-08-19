class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frqs = new HashMap<>();

        ArrayList<Integer>[] sorted = new ArrayList[nums.length + 1];

        for (int num : nums) {
            frqs.put(num, frqs.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < sorted.length; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            sorted[i] = arr;
        }

        for (Map.Entry<Integer, Integer> e : frqs.entrySet()) {
            sorted[e.getValue()].add(e.getKey());
        }

        int count = 0;
        int[] result = new int[k];

        for (int i = nums.length; i >= 0; i--) {
            for (int num : sorted[i]) {
                result[count++] = num;
                if (count == k)
                    return result;
            }
        }

        return result;

        
    }
}
