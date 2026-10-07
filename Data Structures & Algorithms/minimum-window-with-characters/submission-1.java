class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length() || t.length() == 0)
            return new String();

        //create hashmap for t
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) 
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);

        HashMap<Character, Integer> sMap = new HashMap<>();

        int have = 0;
        int need = tMap.size();
        int[] inds = new int[]{-1, -1};
        int len = Integer.MAX_VALUE;

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            //add letter
            char c = s.charAt(r);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            //check if satisfied all conts
            if (tMap.containsKey(c) && sMap.get(c).equals(tMap.get(c)))
                have++;

            //if in valid substring
            while (have == need) {
                //update best length
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    inds[0] = l;
                    inds[1] = r;
                }
                //try to remove left letter
                char left = s.charAt(l);
                sMap.put(left, sMap.get(left) - 1);
                //if removing left affects it, will continue until r hits a letter to help
                if (tMap.containsKey(left) && tMap.get(left) > sMap.get(left))
                    have--;
                l++;
            }

        }
        //if updating length at least once, have smth valid
        if (len < Integer.MAX_VALUE)
            return s.substring(inds[0], inds[1] + 1);
        else
            return "";                
        
    }


}
