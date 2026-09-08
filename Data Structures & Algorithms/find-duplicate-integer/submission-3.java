class Solution {
    public int findDuplicate(int[] nums) {
        
        int slow = 0;
        int fast = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast)
                break;
        }

        int slow2 = 0;

        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow == slow2)
                return slow2;
        }


        // int slow = nums[0];
        // int fast = nums[0];

        // //fast should follow jumping, slow should be in order of nums

        // while (nums[slow] != nums[fast]) { //keep going if nums arent equal 
        //     slow = nums[slow];
        //     fast = nums[fast];
        //     fast = nums[fast];
        // }

        // //now nums are equal

        // int slow2 = 0;


        // while(nums[slow2] != nums[slow]) {
        //     slow = nums[slow];
        //     slow2 = nums[slow2];
        // }

        // return slow2;

        
        
    }
}
