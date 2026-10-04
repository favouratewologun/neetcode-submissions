class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String word : strs) {
            sb.append(word.length());
            sb.append("#");
            sb.append(word);
        }

        return sb.toString();

    }

    public List<String> decode(String str) {
        int l = 0;
        int r = 0;

        List<String> res = new ArrayList<>();

        while (r < str.length()) {
            while(str.charAt(r) != '#') {
                r++;
            }

            int len = Integer.parseInt(str.substring(l, r));
            l = r + 1;
            r += 1;

            if (len == 0) {
                res.add("");
            } else {
                String word = str.substring(l, l + len);
                res.add(word);
                l = l + len;
                r = l;
            }
        }

        return res;

    }
}
