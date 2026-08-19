class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> seen = new HashSet<Character>();

        int l = 0; 
        int maxL = 0;

        for (int r = 0; r < s.length(); r++ ) {
            while (seen.contains(s.charAt(r))) {
                seen.remove(s.charAt(l++));
            }

            seen.add(s.charAt(r));
            maxL = Math.max(maxL, r - l + 1);
        }

        return maxL;
        
    }
}
