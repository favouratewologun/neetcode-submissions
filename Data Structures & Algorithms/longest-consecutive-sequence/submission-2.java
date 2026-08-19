class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> allNums = new HashSet<Integer>();

        for (Integer num : nums)
            allNums.add(num);

        System.out.println(allNums);

        int longestSeq = 0;
        int currSeqLen = 0;
        for (int num : nums) {
            System.out.println("on num " + num);
            boolean doneGoing = false;
            currSeqLen = 1;
            while (doneGoing == false) {
                
                if (allNums.contains(num - 1)) {
                    System.out.println("one less found");
                    currSeqLen++;
                    num -=1;
                } else {
                    System.out.println("one less not found");
                    System.out.println("curr is " + currSeqLen + " longest is " + longestSeq);
                    if (currSeqLen > longestSeq) {
                        System.out.println("curr length is greater, update");
                        longestSeq = currSeqLen;
                    }
                    currSeqLen = 1;
                    doneGoing = true;
                }
            }
        }

        return longestSeq;
        
    }
}
