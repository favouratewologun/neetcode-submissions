class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> counts = new HashMap<>();            

        //created hashmap

        int l = 0;
        int maxWindow = 0;

        for (int r = 0; r < s.length(); r++) {
            counts.put(s.charAt(r), counts.getOrDefault(s.charAt(r), 0) + 1);

            while (r - l + 1 - Collections.max(counts.values()) > k) {
                counts.put(s.charAt(l), counts.get(s.charAt(l)) - 1);
                l++;
            }

            maxWindow = Math.max(maxWindow, r - l + 1);

        }

        return maxWindow;
        
    }
}
