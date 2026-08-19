class MinStack {

    //1 3 5 7
    // 7 5 1 3
    //if less than currtop, push to stack, pop if equal

    int minVal = 0;
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek())
            minStack.push(val);
        
    }
    
    public void pop() {
        int popped = stack.pop();

        if (popped == minStack.peek())
            minStack.pop();
        
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
        return minStack.peek();
        
    }
}
