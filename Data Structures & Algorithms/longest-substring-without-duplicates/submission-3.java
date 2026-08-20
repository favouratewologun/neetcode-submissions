class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> seen = new HashSet<Character>();

        int l = 0;
        int longest = 0;

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);

            while (seen.contains(ch)) {
                seen.remove(s.charAt(l++));
            }

            seen.add(ch);
            
            longest = Math.max(longest, r - l + 1);

        }

        return longest;
        
    }
}
