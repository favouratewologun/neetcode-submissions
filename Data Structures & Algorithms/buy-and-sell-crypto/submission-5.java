class Solution {
    public int maxProfit(int[] prices) {

        int l = 0;
        int maxP = Integer.MIN_VALUE;

        for (int r = 1; r < prices.length; r++) {
            if (prices[l] > prices[r]) {
                l = r;
            }

            int profit = prices[r] - prices[l];
            maxP = Math.max(maxP, profit);

        }

        return Math.max(maxP, 0);
        
    }
}
