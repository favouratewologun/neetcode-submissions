class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<>();

        for (String s : strs) {
            HashMap<Character, Integer> word = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                word.put(c, word.getOrDefault(c, 0) + 1);
            }

            if (map.containsKey(word)) {
                map.get(word).add(s);
            } else {
                map.put(word, new ArrayList<String>());
                map.get(word).add(s);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (ArrayList<String> e : map.values()) {
            res.add(e);
        }

        return res;
        
    }
}
