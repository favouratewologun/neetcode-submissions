class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //buckets?
        //create hashmap to track frequencies
        //create priority queue., keep track of curr most freq.

        HashMap<Integer, Integer> frqs = new HashMap<>();

        for (int num : nums)
            frqs.put(num, frqs.getOrDefault(num, 0) + 1);

        ArrayList<Integer> [] buckets =  new ArrayList[nums.length + 1];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> e : frqs.entrySet()) {
            buckets[e.getValue()].add(e.getKey()); //freq is index, add to array list the num that appeared
        }

        int count = 0;
        int[] result = new int[k];

        for (int i = buckets.length - 1; i >= 0; i--) {
            ArrayList<Integer> numsOfThisFreq = buckets[i];
            for (int num : numsOfThisFreq) {
                result[count++] = num;
                if (count == k)
                    return result;
            }
        }

        return new int[1];


    }
}
