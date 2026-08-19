class Solution {
    public int evalRPN(String[] tokens) {
        Deque <Integer> stack = new ArrayDeque<Integer>();

        for (String token : tokens) {
            int right, left, result;
            if (token.equals("+")) {
                right = stack.pop();
                left = stack.pop();
                result = right + left;
                stack.push(result);
            } else if (token.equals("-")) {
                right = stack.pop();
                left = stack.pop();
                result = left - right;
                stack.push(result);
            } else if (token.equals("*")) {
                right = stack.pop();
                left = stack.pop();
                result = left * right;
                stack.push(result);
            } else if (token.equals("/")) {
                right = stack.pop();
                left = stack.pop();
                result = left / right;
                stack.push(result);
            } else { //if a number
                result = Integer.parseInt(token);
                stack.push(result);
            }
        }

        return stack.pop();
        
    }
}
