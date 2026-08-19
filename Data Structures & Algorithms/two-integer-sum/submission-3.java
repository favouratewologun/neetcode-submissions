class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indices = new HashMap<>();

        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int otherHalf = target - nums[i];

            if (indices.keySet().contains(otherHalf)) {
                result[0] = indices.get(otherHalf);
                result[1] = i;
                return result;
            }

            indices.put(nums[i], i);
        }

        return result;
        
    }
}
