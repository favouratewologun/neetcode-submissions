class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        HashMap<Character, Character> match = new HashMap<>();

        match.put(')', '(');
        match.put('}', '{');
        match.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            if (match.containsValue(s.charAt(i))) //push opening brace to stack
                stack.push(s.charAt(i));
            
            else { //if closing brace
                if (stack.isEmpty())
                    return false;
                
                Character close = s.charAt(i);
                Character matchingBrace = stack.pop();

                if (match.get(close) != matchingBrace)
                    return false;
            }

        }

        return stack.isEmpty();
    }
}
