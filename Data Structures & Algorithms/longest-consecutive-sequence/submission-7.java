class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums)
            seen.add(num);

        //iteratre through the list
        //if start of sequence (no num 1 below it in seen), go through nums to see when seq stops
        //keep track of currSeqLength, longest

        int longest = 0;
        int currSeqLength = 0;

        for (int i = 0; i < nums.length; i++) {
            if (seen.contains(nums[i] - 1)) //not a start of sequence
                continue;
            
            //now found a start of sequence
            currSeqLength = 0;
            int currNum = nums[i];
            while (seen.contains(currNum++)) {
                currSeqLength++;
            }

            longest = Math.max(longest, currSeqLength);
        }

        return longest;

    }

}
