class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> frq = new HashMap<>();

        int l = 0;
        int longest = 0;

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);

            frq.put(ch, frq.getOrDefault(ch, 0) + 1); //update count with right letter

            //replacements needed is size of substring - count of most frequent letter
            int replacements = (r - l + 1) - Collections.max(frq.values());

            while (replacements > k) {
                //decrement count of left letter
                frq.put(s.charAt(l), frq.get(s.charAt(l)) - 1);
                l++;
                replacements = (r - l + 1) - Collections.max(frq.values());
            }

            longest = Math.max(longest, r - l + 1);

        }

        return longest;
        
    }
}
