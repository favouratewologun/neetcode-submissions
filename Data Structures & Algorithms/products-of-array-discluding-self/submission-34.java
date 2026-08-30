class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0)
                prefix[i] = nums[i];
            else
                prefix[i] = prefix[i - 1] * nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) 
                postfix[i] = nums[i];
            else
                postfix[i] = nums[i] * postfix[i + 1];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            if (i == 0)
                result[i] = postfix[i + 1];
            else if (i == result.length - 1)
                result[i] = prefix[i - 1];
            else
                result[i] = prefix[i - 1] * postfix[i + 1];
        }

        return result;
        
    }
}  
