class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (freq.get(num) > 1)
                return true;
        }

        return false;
        
    }
}