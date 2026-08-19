class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        int l = 0;
        int r = s.length() - 1;

        while (l <= r) {
            while (!Character.isLetterOrDigit(s.charAt(l)) && l < r) {
                l++;
            }

            while (!Character.isLetterOrDigit(s.charAt(r)) && l < r)
                r--;

            if ((s.charAt(l)) == (s.charAt(r))) {
                l++;
                r--;
            } else {
                return false;
            }
        }

        return true;
        
    }
}
