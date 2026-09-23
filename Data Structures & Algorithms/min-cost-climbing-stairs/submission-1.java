class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] cache = new int[cost.length]; //track of min cost to get to the top from that pt

        for (int i = 0; i < cache.length; i++)
            cache[i] = -1;

        //first 2 are jsut cost of selves
        cache[cache.length - 1] = cost[cost.length - 1];
        cache[cache.length - 2] = cost[cost.length - 2];
        

        dp(cache, cost, 0);

        return Math.min(cache[0], cache[1]);
    }

    private int dp(int[] cache, int[] cost, int i) {
        if (i >= cache.length)
            return 0;
        
        if (cache[i] != -1) //if already calced min cost, just use it
            return cache[i];

        cache[i] = Math.min(dp(cache, cost, i + 1), dp(cache, cost, i + 2)) + cost[i]; //calc new min from this point
        
        return cache[i];
            
    }
}
