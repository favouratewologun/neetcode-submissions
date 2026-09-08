class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sAn = new HashMap<>();

        for (int i = 0; i < s.length(); i++)
            sAn.put(s.charAt(i), sAn.getOrDefault(s.charAt(i), 0) + 1);

        HashMap<Character, Integer> tAn = new HashMap<>();

        for (int i = 0; i < t.length(); i++)
            tAn.put(t.charAt(i), tAn.getOrDefault(t.charAt(i), 0) + 1);

        return sAn.equals(tAn);

    }
}
