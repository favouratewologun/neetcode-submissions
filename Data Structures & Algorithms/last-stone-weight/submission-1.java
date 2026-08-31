class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones)
            heap.add(stone);

        while (!heap.isEmpty()) {
            int x = heap.poll();
            if (heap.isEmpty()) //last stone remaining, then return
                return x;

            int y = heap.poll();

            if (x < y)
                heap.add(y - x);
            else if (x > y)
                heap.add(x - y);
            //else they are equal, so get rid of both
        }

        return 0;
        
    }
}
