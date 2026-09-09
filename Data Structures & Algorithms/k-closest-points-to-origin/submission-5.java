class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //create a minheap of k closest points...but each should be an int list of 3 (x,y,distance)
        //compare by distance pop by it

        // double[][] ptsAndDist = new double[points.length][3];

        // for (int i = 0; i < points.length; i++) {
        //     int xVal =  points[i][0];
        //     int yVal = points[i][1];
        //     ptsAndDist[i] = new double[]{xVal, yVal, Math.sqrt(Math.pow(xVal, 2) + Math.pow(yVal, 2))};
        //     System.out.println("x,y " + xVal + "," + yVal + " dist = " + ptsAndDist[i][2]); 
        // }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1]));

        //want a max heap of the smallest nums? so if size < k or num < peek, add it

        for (int[] point : points) {
            heap.offer(point);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[][] kClose = new int[k][2];

        for (int i = 0; i < k; i++) {
            kClose[i] = heap.poll();
        }

        return kClose;

        

    }
}
