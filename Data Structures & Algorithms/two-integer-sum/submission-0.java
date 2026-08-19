class Solution {
    public int[] twoSum(int[] nums, int target) {

        java.util.HashSet<Integer> uniqueNums= new java.util.HashSet<Integer>();

        for (int elem : nums)
            uniqueNums.add(elem);

        for (int firstNumIndex = 0; firstNumIndex < nums.length; firstNumIndex++) {
            int diff = target - nums[firstNumIndex];
            if (uniqueNums.contains(diff)) {
                for (int secondNumIndex = firstNumIndex + 1; secondNumIndex < nums.length; secondNumIndex++) {
                    if (nums[secondNumIndex] == diff) {
                        int [] twoIndices = new int [2];
                        twoIndices[0] = firstNumIndex;
                        twoIndices[1] = secondNumIndex;
                        return twoIndices;
                    }
                    
                }
                        
            }
        }

        int [] twoIndices = new int [2];
        twoIndices[0] = 1;
        twoIndices[1] = 1;
        return twoIndices;
        
    }
}