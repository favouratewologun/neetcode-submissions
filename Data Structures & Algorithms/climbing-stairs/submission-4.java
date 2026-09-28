class Solution {
    public int climbStairs(int n) {
        //index, create list

        int[] ways = new int[n + 1];
        for (int i = 0; i < ways.length; i++)
            ways[i] = -1;

        ways[ways.length - 1] = 1;
        ways[ways.length - 2] = 1;

        return dp(ways, 0);     

    }

    private int dp(int[] ways, int i) {
        if (i >= ways.length)
            return 0;

        if (ways[i] != -1)
            return ways[i];

        ways[i] = dp(ways, i + 1) + dp(ways, i + 2);

        return ways[i];

    }
}
