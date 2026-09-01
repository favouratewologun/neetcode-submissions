class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //map tracking the frequencies

        //create an array of size (nums + 1) to represent the frqs
        //append the numbers based on frequencies
        //starting from the end of the array backwards, add nums to result array until full

        HashMap<Integer, Integer> frq = new HashMap<>();

        for (int num : nums)
            frq.put(num, frq.getOrDefault(num, 0) + 1);

        ArrayList<Integer> [] arrByFreq = new ArrayList[nums.length + 1];

        for (int i = 0; i < arrByFreq.length; i++) {
            arrByFreq[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> e : frq.entrySet()) {
            arrByFreq[e.getValue()].add(e.getKey());
        }

        int count = 0;
        int[] res = new int[k];

        for (int i = arrByFreq.length - 1; i >= 0; i--) {
            ArrayList<Integer> thisFreq = arrByFreq[i];

            for (int num : thisFreq) {
                res[count++] = num;
                if (count == k)
                    return res;
            }

        }

        return new int[1];
        
    }
}
