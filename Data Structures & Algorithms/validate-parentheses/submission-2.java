class Solution {
    public boolean isValid(String s) {
        Deque <Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);

            //opening bracket
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                stack.push(bracket);
            }
            
            //closing bracket
            else {
                if (stack.isEmpty()) //closing bracket but nothing to match
                    return false;

                char open = stack.pop();

                if ((open == '(' && bracket != ')') || (open == '{' && bracket != '}') ||(open == '[' && bracket != ']'))
                    return false;
                
            }


        }

        return stack.isEmpty();

       
    }
}
