class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> seen = new HashSet<Character>();

        int longest = 0;
        int curr = 0;

        int l = 0;
        
        for (int r = 0; r < s.length(); r++) {
            Character let = s.charAt(r);

            //if contaisn letter, fix until doesnt
            while (seen.contains(let)) {
                seen.remove(s.charAt(l++));
                curr--;
            }

            seen.add(let);
            curr++;

            longest = Math.max(longest, curr);

            //add new unseen letter
            
            
        }

        return longest;
        
    }
}
