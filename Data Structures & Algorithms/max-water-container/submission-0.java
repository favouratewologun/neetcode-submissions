class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;

        int maxVol = 0;

        while (l <= r) {
            int width = r - l;
            int height = Math.min(heights[l], heights[r]);

            int vol = width * height;
            maxVol = Math.max(maxVol, vol);

            if (heights[l] < heights[r])
                l++;
            else
                r--;

        }

        return maxVol;
        
    }
}
