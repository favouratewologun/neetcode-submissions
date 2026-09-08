class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<HashMap<Character, Integer>, List<String>> maps = new HashMap<>();

        for (String str : strs) {
            HashMap<Character, Integer> frq = new HashMap<>();

            for (int i = 0; i < str.length(); i++) 
                frq.put(str.charAt(i), frq.getOrDefault(str.charAt(i), 0) + 1);

            //created hashmap for a string. check if adding ot a key, or making a new one

            if (maps.containsKey(frq))
                maps.get(frq).add(str);
            else {
                ArrayList<String> tracks = new ArrayList<>();
                tracks.add(str);
                maps.put(frq, tracks);
            }

        }

        for (Map.Entry<HashMap<Character, Integer>, List<String>> e : maps.entrySet()) {
            result.add(e.getValue());
        }

        return result;
        
    }
}
