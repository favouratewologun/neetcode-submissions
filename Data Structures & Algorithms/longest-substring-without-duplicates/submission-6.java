class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> seen = new HashSet<Character>();

        int l = 0;
        int longest = 0;

        for (int r = 0; r < s.length(); r++) {

            while (seen.contains(s.charAt(r))) {
                seen.remove(s.charAt(l++));
            }

            seen.add(s.charAt(r));
            
            longest = Math.max(longest, r - l + 1);

        }

        return longest;
        
    }
}
