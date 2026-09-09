class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> close = new HashMap<>();
        close.put(')', '(');
        close.put('}', '{');
        close.put(']', '[');

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (close.values().contains(c))
                stack.push(c);
            else { //is a closing brace
                if (stack.isEmpty())
                    return false;

                char open = stack.pop();
                if (open != close.get(c))
                    return false;
            }


        }

        return stack.isEmpty();
        
    }
}
