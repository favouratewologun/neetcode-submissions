class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //keep array count of letters, if equal then return true, else return false

        if (s1.length() > s2.length())
            return false;

        int[] oneLetts = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            int ind = (int) (s1.charAt(i) - 'a');
            oneLetts[ind]++;
        }

        int[] twoLetts = new int[26];

        int l = 0;
        int r = 0;
        for (; r < s1.length(); r++) {
            int ind = (int) (s2.charAt(r) - 'a');
            twoLetts[ind]++;
        }

        int matches = 0;

        for (int i = 0; i < oneLetts.length; i++) {
            if (oneLetts[i] == twoLetts[i])
                matches++;
        }

        if (matches == 26)
            return true;
        
        for (; r < s2.length(); r++) {
            matches = 0;
            int lInd = (int) (s2.charAt(l++) - 'a');
            twoLetts[lInd]--;

            int rInd = (int) (s2.charAt(r) - 'a');
            twoLetts[rInd]++;

            for (int i = 0; i < oneLetts.length; i++) {
                if (oneLetts[i] == twoLetts[i])
                    matches++;
            }

            if (matches == 26)
                return true;


        }

        return false;

        
    }
}
