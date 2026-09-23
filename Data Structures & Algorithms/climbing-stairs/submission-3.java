class Solution {
    public int climbStairs(int n) {
        int[] numWays = new int[n + 1]; //indices range from 0 to n -- at least 2 steps
        numWays[n] = 1;
        numWays[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            numWays[i] = numWays[i + 1] + numWays[i + 2];
        }

        return numWays[0]; //numways to get to top from bottom

        
    }
}
