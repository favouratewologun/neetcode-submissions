class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        //push if less, pop if greater, all init to 0 so that's fine

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek()) {
                stack.pop(); //remove temp;
                int prevInd = stack.pop(); //remove ind
                result[prevInd] = i - prevInd;
            } 
            stack.push(i);
            stack.push(temperatures[i]);

            //while loop for val = 0? then reset i to normal?? -- push i and temp
        }

        return result;
        
    }
}
