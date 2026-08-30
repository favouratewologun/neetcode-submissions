class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1)
            return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(row -> row[0])); //sort on start time

        int currS = intervals[0][0];
        int currE = intervals[0][1];

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
    
        for (int i = 1; i < intervals.length; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];

            if (s <= currE) { //if overlap, remove the one it overlaps with, create merged int, then add
                result.remove(result.size() - 1);
                currS = Math.min(s, currS);
                currE = Math.max(e, currE);
                result.add(new int[]{currS, currE});
            } else { //if no overlap, just add the interval, make this the new curr
                result.add(intervals[i]);
                currS = s;
                currE = e;
            }
        }

        return result.toArray(new int[result.size()][]);
        
    }
}
