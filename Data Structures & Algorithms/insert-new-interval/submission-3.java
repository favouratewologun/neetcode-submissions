class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<int[]> res = new ArrayList<>();
        int nS = newInterval[0];
        int nE = newInterval[1];

        for (int i = 0; i < intervals.length; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];

            if (e < nS) {
                res.add(new int[]{s, e});
            } else if (nE < s) {
                res.add(new int[]{nS, nE});
                for (int j = i; j < intervals.length; j++)
                    res.add(intervals[j]);

                int[][] result = new int[res.size()][2];
                for (int j = 0; j < res.size(); j++) {
                    result[j] = res.get(j);
                }

                return result;
            } else { //overlap
                nS = Math.min(nS, s);
                nE = Math.max(nE, e);
            }
        }

        res.add(new int[]{nS, nE});

        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;


        
    }
}
