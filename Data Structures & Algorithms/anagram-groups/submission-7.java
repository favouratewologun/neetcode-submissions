class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        //have to create a hashmap of hashmaps to lists
        HashMap<HashMap<Character, Integer>, ArrayList<String>> anagrams = new HashMap<>();
        
        for (String str : strs) {
            HashMap<Character, Integer> anagram = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char let = str.charAt(i);

                anagram.put(let, anagram.getOrDefault(let, 0) + 1);
            }

            if (anagrams.containsKey(anagram)) {
                anagrams.get(anagram).add(str);
            } else {
                anagrams.put(anagram, new ArrayList<String>());
                anagrams.get(anagram).add(str);
            }

            //if empty string, do smth
        }

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<HashMap<Character, Integer>, ArrayList<String>> e : anagrams.entrySet()) {
            result.add(e.getValue());
        }

        return result;
        
    }
}
