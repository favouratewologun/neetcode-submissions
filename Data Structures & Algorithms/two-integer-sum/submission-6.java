class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> pairs = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (pairs.containsKey(target - nums[i]))
                return new int[]{pairs.get(target - nums[i]), i};
            
            pairs.put(nums[i], i);
        
        }

        return new int[2];
        
    }
}

//create a hashmap mapping val:index. if contains wtv - then return second num (get), then self index
