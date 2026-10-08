class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int right = stack.pop();
                int left = stack.pop();
                int res = 0;

                if (s.equals("+"))
                    res = left + right;
                else if (s.equals("-"))
                    res = left - right;
                else if (s.equals("*"))
                    res = left * right;
                else if (s.equals("/"))
                    res = left / right;

                stack.push(res);
            } else
                stack.push(Integer.parseInt(s));
        
        }

        return stack.pop();
        
    }
}
