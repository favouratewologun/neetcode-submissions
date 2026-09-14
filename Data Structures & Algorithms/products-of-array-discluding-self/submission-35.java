class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] post = new int[nums.length];
        int[] pre = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0)
                pre[i] = nums[i];
            else
                pre[i] = pre[i - 1] * nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1)
                post[i] = nums[i];
            else
                post[i] = post[i + 1] * nums[i];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0)
                res[i] = post[i + 1];
            else if (i == nums.length - 1)
                res[i] = pre[i - 1];
            else
                res[i] = pre[i - 1] * post[i + 1];
        }

        return res;
        
    }
}  
