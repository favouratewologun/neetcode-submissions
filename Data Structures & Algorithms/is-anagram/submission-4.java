class Solution {
    public boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> sMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        return sMap.equals(tMap);


    }
}
