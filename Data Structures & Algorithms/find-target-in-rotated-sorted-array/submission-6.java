class Solution {
    public int search(int[] nums, int target) {
        //find peak

        int l = 0;
        int r = nums.length - 1;
        int last = nums[nums.length - 1];

        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > last)
                l = m + 1;
            else
                r = m;
        }
        //now l = m = r;

        int res = binarySearch(nums, 0, l - 1, target); //search first half
        if (res != -1)
            return res;
        return binarySearch(nums, l, nums.length - 1, target); //search second half

        
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) 
                l = m + 1;
            else if (nums[m] > target)
                r = m - 1;
            else
                return m;
        }

        return -1;
    }
}


