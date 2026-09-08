class Solution {
    public int characterReplacement(String s, int k) {

    //create a hashmap of letters, while length of window - count most freq > k, move l forward + update hashmap, then add r
    //update longest at end

        int l = 0;
        int longest = 0;
        HashMap<Character, Integer> count = new HashMap<>();

        for (int r = 0; r < s.length(); r++)  {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            
            while (r - l + 1 - Collections.max(count.values()) > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }

            longest = Math.max(longest, r - l + 1);

        }

        return longest;

        
    }
}
