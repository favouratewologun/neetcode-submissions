class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> closing = new HashMap<>();

        closing.put(')', '(');
        closing.put('}', '{');
        closing.put(']', '[');

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (closing.values().contains(ch)) { //if opening brace
                stack.push(ch);
            } else { //closing brace
                if (stack.isEmpty())
                    return false;
                if (closing.get(ch) != stack.peek())
                    return false;
                else
                    stack.pop();
            }
        }

        return stack.isEmpty();

    }
}
