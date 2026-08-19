class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<>();

        for (String word : strs) {
            HashMap<Character, Integer> anagram = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                Character ch = word.charAt(i);
                anagram.put(ch, anagram.getOrDefault(ch, 0) + 1);
            }

            if (map.containsKey(anagram)) {
                map.get(anagram).add(word);
            } else {
                ArrayList<String> allWords = new ArrayList<>();
                allWords.add(word);
                map.put(anagram, allWords);
            }
        }

        for (Map.Entry<HashMap<Character, Integer>, ArrayList<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;

        //go through each of the words, create anagram
        //see wat it matches to, add to that list, or create new list
        //create a hashmap, with key as hashmap, value as list of strings. add if there, or not
        
    }
}
