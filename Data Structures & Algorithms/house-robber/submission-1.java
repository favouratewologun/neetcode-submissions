class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int[] made = new int[nums.length];
        made[nums.length - 1] = nums[nums.length - 1];
        made[nums.length - 2] = Math.max(nums[nums.length - 2], nums[nums.length - 1]);

        for (int i = 0; i < made.length - 2; i++)
            made[i] = -1;

        backtracking(made, nums, 0);

        return Math.max(made[0], made[1]);

    }

    private int backtracking(int[] made, int[] nums, int i) {
        if (i >= made.length)
            return 0;

        if (made[i] != -1)
            return made[i];

        int useSelf = nums[i] + backtracking(made, nums, i + 2);
        int notSelf = backtracking(made, nums, i + 1);

        made[i] = Math.max(useSelf, notSelf);
        return made[i];

    }
}
