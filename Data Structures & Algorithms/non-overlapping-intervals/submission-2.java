class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> result = new ArrayList<>();

        int removals = 0;

        int[] currInt = intervals[0];
        int currS = currInt[0];
        int currE = currInt[1];

        result.add(currInt);

        for (int i = 1; i < intervals.length; i++) {
            
            int s = intervals[i][0];
            int e = intervals[i][1];

            if (s < currE) {
                removals++;
                if (currE > e) { //curr interval should be dropped bc too long
                    currS = s;
                    currE = e;
                } //else curr interval can stay. we drop the new interval

            } else { //valid
                currS = s;
                currE = e;
            }
        }

        return removals;

        
    }
}
