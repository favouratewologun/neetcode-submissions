class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //go through all, if neither start nor end contained in new interval, then insert

        List<int[]> results = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int iStart = intervals[i][0];
            int iEnd = intervals[i][1];

            int nStart = newInterval[0];
            int nEnd = newInterval[1];

            if (iEnd < nStart) { //before newInt
                results.add(intervals[i]);
            } else if (iStart > nEnd) { //after new int
                results.add(newInterval);
                for (int j = i; j < intervals.length; j++)
                    results.add(intervals[j]);
                    
                return results.toArray(new int[results.size()][]);
            } else {
                newInterval[0] = Math.min(iStart, nStart);
                newInterval[1] = Math.max(iEnd, nEnd);
            }
                
        }

        results.add(newInterval);
        return results.toArray(new int[results.size()][]);


        

        
        
        
    }
}
