class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;

        HashMap<Character, Integer> used = new HashMap<>();
        int maxLen = 0;

        for (int r = 0; r < s.length(); r++) {
            while (used.containsKey(s.charAt(r)) && used.getOrDefault(s.charAt(r), 0) > 0) {
                used.put(s.charAt(l), used.get(s.charAt(l)) - 1);
                l++;
            }

            used.put(s.charAt(r), used.getOrDefault(s.charAt(r), 0) + 1);
            maxLen = Math.max(maxLen, r - l + 1);
            
        }

        return maxLen;
        
    }
}
