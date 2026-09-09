class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //create a minheap of k closest points...but each should be an int list of 3 (x,y,distance)
        //compare by distance pop by it

        double[][] ptsAndDist = new double[points.length][3];

        for (int i = 0; i < points.length; i++) {
            int xVal =  points[i][0];
            int yVal = points[i][1];
            ptsAndDist[i] = new double[]{xVal, yVal, Math.sqrt(Math.pow(xVal, 2) + Math.pow(yVal, 2))};
            System.out.println("x,y " + xVal + "," + yVal + " dist = " + ptsAndDist[i][2]); 
        }

        PriorityQueue<double[]> heap = new PriorityQueue<>((a, b) -> Double.compare(b[2], a[2]));

        //want a max heap of the smallest nums? so if size < k or num < peek, add it

        for (double[] dist : ptsAndDist) {
            if (heap.size() < k) //auto add if less than k
                heap.offer(dist);
            else if (dist[2] < heap.peek()[2]) { //if found smaller than curr biggest, replace
                heap.poll();
                heap.offer(dist);
            }
        }

        int[][] kClose = new int[k][2];

        for (int i = 0; i < k; i++) {
            double[] newPts = heap.poll();
            kClose[i] = new int[]{(int) newPts[0], (int) newPts[1]};
        }

        return kClose;

        

    }
}
