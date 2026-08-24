class Solution {
    public int characterReplacement(String s, int k) {
        //create hashmap to keep track of characters
        //as move forward, check if replacements is < k
        //if so, update longest
        //while not so, move left forward, update hashmap

        int longest = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            //replacements = length of substring - max freq
            while ((r - l + 1) - Collections.max(map.values()) > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1); //remove curr l from hashmap
                l++; //move l forward
            }

            longest = Math.max(longest, r - l + 1);

        }

        return longest;
        
    }
}
