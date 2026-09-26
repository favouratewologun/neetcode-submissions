class Solution {
    public int trap(int[] height) {
        if (height.length < 2)
            return 0;

        int totalWater = 0;

        //initialize left and right
        //take whichever is smaller
        //if less than leftmax/right max, add difference bw leftmax and self
        //else, leftmax = self
        //while l <= r
        //might have missing edge case, deal with when walk through

        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];

        while (left <= right) {
            if (height[left] < height[right]) { //do shorter val
                if (height[left] < leftMax) { //if less than a wall 
                    totalWater += leftMax - height[left]; //add the water
                } else
                    leftMax = height[left]; //update the max height of the wall
                left++; //either way move forward
            } else {
                if (height[right] < rightMax) {
                    totalWater += rightMax - height[right];
                } else
                    rightMax = height[right];
                
                right--;
            }
        }

        return totalWater;

        
    }
}
