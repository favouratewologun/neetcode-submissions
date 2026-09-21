class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] pref = new int[nums.length];
        int[] suff = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0)
                pref[i] = nums[i];
            else
                pref[i] = pref[i - 1] * nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1)
                suff[i] = nums[i];
            else
                suff[i] = nums[i] * suff[i + 1];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0)
                res[i] = suff[i + 1];
            else if (i == nums.length - 1)
                res[i] = pref[i - 1];
            else
                res[i] = pref[i - 1] * suff[i + 1];
        }

        return res;
    }
}  
