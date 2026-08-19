class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque <Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < result.length; i++) {
            int currVal = temperatures[i];

            //do all comparisons and update
            while (!stack.isEmpty() && currVal > temperatures[stack.peek()]) {
                int otherInd = stack.pop();
                result[otherInd] = i - otherInd;
            }

            //push current index on
            stack.push(i);
        }

        return result;
        
    }
}
