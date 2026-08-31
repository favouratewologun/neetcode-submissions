class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<int[]> result = new ArrayList<>();

        int prevS = newInterval[0];
        int prevE = newInterval[1];

        for (int i = 0; i < intervals.length; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];

            if (e < prevS) { //curr is before new intervals
                result.add(intervals[i]);
            } else if (s > prevE) { //completely after
                result.add(new int[]{prevS, prevE});

                for (int j = i; j < intervals.length; j++)
                    result.add(intervals[j]);

                return result.toArray(new int[result.size()][]);

            } else { //overlap
                prevS = Math.min(prevS, s);
                prevE = Math.max(prevE, e);
            }
        }

        result.add(new int[]{prevS, prevE}); //if here, newInterval still not added
        return result.toArray(new int[result.size()][]);
        
    }
}
