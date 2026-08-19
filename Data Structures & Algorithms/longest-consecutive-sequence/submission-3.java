class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            seen.add(num);
        }

        int currSeqVal = 0;
        int maxSeqLen = 0;
        int currSeqLen = 0;

        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            if (!seen.contains(currNum - 1)) {
                currSeqLen = 1;

                while(seen.contains(currNum + 1)) {
                    currNum++;
                    currSeqLen++;
                }

                if (currSeqLen > maxSeqLen)
                    maxSeqLen = currSeqLen;

            }

        }

        return maxSeqLen;
        
    }
}
