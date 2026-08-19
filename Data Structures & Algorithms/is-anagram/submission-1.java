class Solution {
    public boolean isAnagram(String s, String t) {

        java.util.HashMap<Character, Integer> s_letters = new java.util.HashMap<Character, Integer>();

        char [] s_arr = s.toCharArray();
        char [] t_arr = t.toCharArray();

        for (char letter : s_arr) {
            s_letters.put(letter, s_letters.getOrDefault(letter, 0) + 1);
        }

        java.util.HashMap<Character, Integer> t_letters = new java.util.HashMap<Character, Integer>();

        for (char letter : t_arr) {
            t_letters.put(letter, t_letters.getOrDefault(letter, 0) + 1);
        }

        return s_letters.equals(t_letters);




    }
}
