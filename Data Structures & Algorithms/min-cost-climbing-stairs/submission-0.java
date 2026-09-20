class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int[] cache = new int[cost.length];
        for (int i = 0; i < cost.length - 2; i++)
            cache[i] = -1;

        cache[cost.length - 2] = cost[cost.length - 2];
        cache[cost.length - 1] = cost[cost.length - 1];


        work(cache, cost, 0);

        return Math.min(cache[0], cache[1]);

        // int one = cost[cost.length - 2];
        // int two = cost[cost.length - 1];

        // int temp;

        // for (int i = 0; i < cost.length - 1; i++) {
        //     temp = one;
        //     one = one + two;
        //     two = temp;
        // }

        // return Math.min(one, two);
        
    }

    private int work(int[] cache, int[] cost, int i) {
        if (i < 0 || i >= cost.length)
            return 0;
        if (cache[i] != -1)
            return cache[i];

        cache[i] = Math.min(work(cache, cost, i + 1), work(cache, cost, i + 2)) + cost[i];
        return cache[i];
        
    }
}
