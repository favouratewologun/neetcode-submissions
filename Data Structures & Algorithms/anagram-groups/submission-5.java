class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        java.util.List<java.util.List<String>> allAnagrams = new java.util.ArrayList<java.util.List<String>>();
        java.util.HashSet<HashMap> allWordMaps = new java.util.HashSet<HashMap>();

        for (String word : strs) {
            char [] wordLetters = word.toCharArray();
            java.util.HashMap <Character, Integer> wordMap= new java.util.HashMap <Character, Integer>();
            for (char character : wordLetters) {
                wordMap.put(character, wordMap.getOrDefault(character, 0) + 1);
            }
            System.out.println(wordMap);

            if (allWordMaps.contains(wordMap)) {
                for (int i = 0; i < allAnagrams.size(); i++) {
                    System.out.println("in for loop, " + i);
                    java.util.HashMap <Character, Integer> compareTo = new java.util.HashMap <Character, Integer>();
                    String compareWord = allAnagrams.get(i).get(0);
                    for (int k = 0; k < compareWord.length(); k++) {
                        compareTo.put(compareWord.charAt(k), compareTo.getOrDefault(compareWord.charAt(k), 0) + 1);
                    }
                    System.out.println("compare word make " + compareTo);
                    if (wordMap.equals(compareTo)) {
                        allAnagrams.get(i).add(word);
                        System.out.println("match!" + allAnagrams);

                    }

                }
            } else {
                java.util.ArrayList<String> newAnagram = new java.util.ArrayList<String>();
                newAnagram.add(word);
                allAnagrams.add(newAnagram);
            }

            allWordMaps.add(wordMap);
            System.out.println("all word maps "  + allWordMaps);
        }


        return allAnagrams;
    }
}
