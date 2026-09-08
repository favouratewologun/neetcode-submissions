class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        //only want the beginnings of a sequence, which is when there is no num 1 less

        HashSet<Integer> seen = new HashSet<>();

        int longestSeq = 0;
        int currNum;
        int currSeq;

        for (int num : nums)
            seen.add(num);

        for (int i = 0; i < nums.length; i++) {
            if (seen.contains(nums[i] - 1)) //not start of seq, skip
                continue; 

            currSeq = 1;
            currNum = nums[i];

            while(seen.contains(currNum + 1)) {
                currSeq++;
                currNum++;
            }
            longestSeq = Math.max(currSeq, longestSeq);
            
        }

        return longestSeq;
        
    }
}
