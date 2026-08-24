class Solution {
    public int search(int[] nums, int target) {
        // if (nums[0] < nums[nums.length - 1])
        //     return binarySearch(nums, 0, nums.length - 1, target);

        int l = 0;
        int r = nums.length - 1;
        int pivot;
        int rightNum = nums[nums.length - 1];

        //3 4 5 6 1 2
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        pivot = l;

        int result = binarySearch(nums, 0, pivot - 1, target);

        if (result != -1)
            return result;

        return binarySearch(nums, pivot, nums.length - 1, target);

        
    }

    int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
            else
                return mid;
        }

        return -1;
    }
}
