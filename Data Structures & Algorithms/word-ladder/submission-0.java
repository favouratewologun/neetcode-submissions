class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        char[] endWordChar = endWord.toCharArray();
        HashSet<String> wordSet = new HashSet<>();
        HashSet<String> seen = new HashSet<>();

        for (String word : wordList)
            wordSet.add(word);

        Queue<String> queue = new ArrayDeque<>();
        int wordLength = beginWord.length();
        int minWords = 0;
        queue.offer(beginWord);

        if (beginWord.equals(endWord))
            return minWords;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord))
                    return minWords + 1;
                
                char[] wordChar = word.toCharArray();

                for (int pos = 0; pos < wordLength; pos++) {    //go through all positions 
                    char oldLet = wordChar[pos];
                    for (int let = 0; let < 26; let++) { //go through all letters
                        char newLet = (char) ((int)'a' + let);
                        if (newLet == oldLet)
                            continue;
                        wordChar[pos] = newLet; //replace the letter
                        String editedWord = new String(wordChar);
                        if (wordSet.contains(editedWord) && !seen.contains(editedWord)){//if valid, add to queue
                            queue.offer(editedWord);
                            seen.add(editedWord);
                        } 
                            
                         //go through all 26 replace, if in wordlist, add. 
                        //replace letter to normal before going to next letter to replace
                    }
                    wordChar[pos] = oldLet; //fix to old, before editing  next pos
                }

            }
            minWords++; //might only do if word != end, like found is false
        }

        return 0;

        //do it as bfs, process as a queue
        //keep track of minwords, check size, so can increment when finished a whole "row"
        //
        
    }
}
