class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length())
            return false;

        int[] s1Letts = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            Character ch = s1.charAt(i);
            int num = (int) ch - 97;
            s1Letts[num]++;  
        }

        int[] perm = new int[26];

        int l = 0;
        int r = 0;

        for (r = 0; r < s1.length(); r++) {
            Character ch = s2.charAt(r);
            int num = (int) ch - 97;
            perm[num]++;  
        }

        if (Arrays.equals(s1Letts, perm))
            return true;


        for (; r < s2.length(); r++) {
            Character leftCh = s2.charAt(l++);
            int leftNum = (int) leftCh - 97;
            perm[leftNum]--;

            Character rightCh = s2.charAt(r);
            int rightNum = (int) rightCh - 97;
            perm[rightNum]++;

            if (Arrays.equals(s1Letts, perm))
                return true;

        }

        return false;


        
    }
}
