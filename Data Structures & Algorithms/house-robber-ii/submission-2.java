class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        //can do rob and go from first house to seocond last
        //can do rob and go from second house to last
        //get max of the two

        int[] rob1 = new int[nums.length];
        for (int i = 0; i < rob1.length; i++)
            rob1[i] = -1;
        rob1[rob1.length - 1] = nums[rob1.length - 1]; 
        dp(rob1, 0, nums, nums.length - 1);



        int[] rob2 = new int[nums.length];
        for (int i = 0; i < rob2.length; i++)
            rob2[i] = -1;
        rob2[rob2.length - 1] = nums[rob2.length - 1]; 
        dp(rob2, 1, nums, nums.length);


        return Math.max(rob1[0], rob2[1]);
        
    }

    public int dp(int[] rob, int i, int[] nums, int max) {
        if (i >= max)
            return 0;

        if (rob[i] != -1)
            return rob[i];

        //rob this house but not the next
        //rob next house, not this
        rob[i] = Math.max(dp(rob, i + 2, nums, max) + nums[i], dp(rob, i + 1, nums, max));
        return rob[i];
    }
}
