class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;

        int maxWater = 0;

        while (l < r) {
            if (heights[l] < heights[r]) {
                maxWater = Math.max(maxWater, (r - l) * heights[l]);
                                   
                l++;
            } else {
               
                maxWater = Math.max(maxWater, (r - l) * heights[r]);
               
                r--;
            }
        }

        return maxWater;
        
    }
}
