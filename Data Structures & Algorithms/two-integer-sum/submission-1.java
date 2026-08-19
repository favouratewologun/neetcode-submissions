class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> pairings = new HashMap<>();

        int ind1, ind2;

        for (int i = 0; i < nums.length; i++) {
            int otherHalf = target - nums[i];

            if (pairings.containsKey(otherHalf)) {
                int[] result = new int[2];
                result[0] = pairings.get(otherHalf);
                result[1] = i;
                return result;
            } else {
                pairings.put(nums[i], i);
            }
        }

        return new int[1];
        
    }
}
