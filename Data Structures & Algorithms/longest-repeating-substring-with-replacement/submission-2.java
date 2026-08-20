class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int longest = 0;
        int r = 0;

        HashMap<Character, Integer> frq = new HashMap<>();

        //make hashmap to start
        for (r = 0; r < s.length(); r++) {
            frq.put(s.charAt(r), frq.getOrDefault(s.charAt(r), 0) + 1);
            int replacements = (r - l + 1) - Collections.max(frq.values()); 
            //calc replacement needed
            if (replacements <= k) //if less than k, valid, replace longest
                longest = Math.max(longest, r - l + 1);
            else {
                while (replacements > k) { //update until valid
                    frq.put(s.charAt(l), frq.get(s.charAt(l)) - 1); //update hashmap
                    l++;
                    replacements = (r - l + 1) - Collections.max(frq.values());
                }
            }
        }

        return longest;
        
    }
 }

 //NEW BETTER
       //make hashmap to start
        // for (; r < k; r++) {
        //     frq.put(s.charAt(r), frq.getOrDefault(s.charAt(r), 0) + 1);
        // }

        // for (r = k; r < s.length(); r++) {
        //     frq.put(s.charAt(r), frq.getOrDefault(s.charAt(r), 0) + 1);
        //     int replacements = (r - l + 1) - Collections.max(frq.values()); 
        //     //calc replacement needed
        //     if (replacements <= k) //if less than k, valid, replace longest
        //         longest = Math.max(longest, r - l + 1);
        //     else {
        //         while (replacements > k) { //update until valid
        //             frq.put(s.charAt(l), frq.get(s.charAt(l)) - 1); //update hashmap
        //             l++;
        //             replacements = (r - l + 1) - Collections.max(frq.values());
        //         }
        //     }
        // }
 //NEW BETTER END

//         //go through letters while consistent
//         //when meet inconsistent,
//         //if count replacements and is <= k go until out of replacements.
//         //math.max longest, 0
//         //when out of replacements, move up to new char
        
//         int l = 0;
//         char currCh = s.charAt(0);
//         int longest = 1; //first letter
//         int currCount = 0;
//         int kReplace = k;

//         //OR DO a whole new format where we do a forloop based on kreplace

//         for (int r = 1; r < s.length(); r++) {
//             //if matching char, update and continue
//             if (s.charAt(r) == currCh) {
//                 currCount++;
//                 longest = Math.max(longest, currCount);
//                 continue;
//             }
            
//             //not matching char
//             if (kReplace > 0) {
//                 currCount++;
//                 longest = Math.max(longest, currCount);
//                 kReplace--;
//             } else { //reset, current is no longer good
//                 // while (s.charAt(l) == currCh) { //move l pointer forward until at new letter
//                 //     l++;
//                 // }
//                 currCount = 0;
//                 kReplace = k;
//                 currCh = s.charAt(l);
//                 l = r;
//                 //cant be right bc l != r (kreplace)...but i dont think should auto do l = r
//             }

//             //AAABBAABAAABAAAAAA

//         }

//         return longest;