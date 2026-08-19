class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        // int r = prices.length;

        int maxProfit = Integer.MIN_VALUE;
        int prevProfit = Integer.MIN_VALUE;

        for (int r = 1; r < prices.length; r++) {
            if (prices[r] < prices[l]) {
                l = r;
            }

            int profit = prices[r] - prices[l];

            maxProfit = Math.max(maxProfit, profit);

        }



        return Math.max(maxProfit, 0);    
    }
}

//if max profit is < 0, return 0
//start at opp days, if right ever dips, move left,
//keep moving right while profit increases. if it decreases, move left, check
//keep track of prev profit, if it dropped, then stop and keep moving left until l = r??
