class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length];
        minCost[cost.length - 1] = cost[cost.length - 1];
        minCost[cost.length - 2] = cost[cost.length - 2];

        for (int i = 0; i < minCost.length - 2; i++)
            minCost[i] = -1;

        backtracking(minCost, cost, 0);   
        return Math.min(minCost[0], minCost[1]);     
    }

    private int backtracking(int[] minCost, int[] cost, int i) {
        if (i >= minCost.length) //out of bounds ignore
            return 0;

        if (minCost[i] != -1) //already found, return
            return minCost[i];
        
        minCost[i] = Math.min(backtracking(minCost, cost, i + 1), backtracking(minCost, cost, i + 2)) + cost[i];
        //min of steps ahead + cost of self
        return minCost[i];
        
    }
}
