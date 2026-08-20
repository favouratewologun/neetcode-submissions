class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int longest = 0;
        int r = 0;

        HashMap<Character, Integer> frq = new HashMap<>();

        //make hashmap to start
        for (r = 0; r < s.length(); r++) {
            frq.put(s.charAt(r), frq.getOrDefault(s.charAt(r), 0) + 1);
            int replacements = (r - l + 1) - Collections.max(frq.values()); 
            //calc replacement needed
            while (replacements > k) { //update until valid
                frq.put(s.charAt(l), frq.get(s.charAt(l)) - 1); //update hashmap
                l++;
                replacements = (r - l + 1) - Collections.max(frq.values()); 
            }

            longest = Math.max(longest, r - l + 1);
            
        }

        return longest;
        
    }
 }