class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> s_Lets = new HashMap<Character, Integer>();
        HashMap<Character, Integer> t_Lets = new HashMap<Character, Integer>();

        for (char c: s.toCharArray()) {
            s_Lets.put(c, s_Lets.getOrDefault(c, 0) + 1);
        }

        for (char c: t.toCharArray()) {
            t_Lets.put(c, t_Lets.getOrDefault(c, 0) + 1);
        }

        return (s_Lets.equals(t_Lets));

    }
}
