class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frq = new HashMap<>();

        //create hashmap
        for (int num : nums)
            frq.put(num, frq.getOrDefault(num, 0) + 1);

        ArrayList<Integer> [] counts = new ArrayList[nums.length + 1]; //counts from 0 - num;

        for (int count = 0; count < counts.length; count++) {
            counts[count] = new ArrayList<Integer>(); 
        }

        for (Map.Entry<Integer, Integer> e : frq.entrySet()) {
            counts[e.getValue()].add(e.getKey());
            //e.getVal is an arraylist for the count, add the number than appeared that many times
        }

        int toK = 0;
        int [] result = new int[k];
        for (int i = counts.length - 1; i >= 0; i--) {
            ArrayList<Integer> numsInCount = counts[i];

            for (int num : numsInCount) {
                result[toK++] = num;
                if (toK == k)
                    return result;
            }
        }

        return new int[2];
        
    }
}
