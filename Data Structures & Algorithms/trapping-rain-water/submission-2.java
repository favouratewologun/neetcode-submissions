class Solution {
    public int trap(int[] height) {
        int water = 0;

        int l = 0;
        int r = height.length - 1;

        int lMax = height[l];
        int rMax = height[r];

        while (l <= r) {
            if (height[l] < height[r]) {
                if (height[l] < lMax) {
                    water += lMax - height[l];
                } else {
                    lMax = height[l];
                }
                l++;
            } else {
                if (height[r] < rMax) {
                    water += rMax - height[r];
                } else {
                    rMax = height[r];
                }
                r--;
            }
        }

        return water;
        
    }
}
