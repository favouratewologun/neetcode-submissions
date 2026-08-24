class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String s : tokens) {
            if (s.equals("+")) {
                int right = stack.pop();
                int left = stack.pop();
                int result = left + right;
                stack.push(result);
            } else if (s.equals("-")) {
                int right = stack.pop();
                int left = stack.pop();
                int result = left - right;
                stack.push(result);
            } else if (s.equals("*")) {
                int right = stack.pop();
                int left = stack.pop();
                int result = left * right;
                stack.push(result);
            } else if (s.equals("/")) {
                int right = stack.pop();
                int left = stack.pop();
                int result = left / right;
                stack.push(result);
            } else { //an int
                stack.push(Integer.parseInt(s));
            }
 
        }

        return stack.pop();

        //if an operator, pop 2 then compute, push again
        //if a number, push

        //pop at the end
        
    }
}
