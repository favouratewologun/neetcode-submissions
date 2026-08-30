class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1)
            return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(row -> row[0])); //sort on start time

        // for (int[] interval : intervals) {
        //     System.out.println(interval[0] + ", " + interval[1]);
        // }

        int currS = intervals[0][0];
        int currE = intervals[0][1];

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

    
        for (int i = 1; i < intervals.length; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];

            if (s <= currE) {
                result.remove(result.size() - 1);
                currS = Math.min(s, currS);
                currE = Math.max(e, currE);
                result.add(new int[]{currS, currE});
            } else {
                result.add(intervals[i]);
                currS = s;
                currE = e;
            }
        }

        return result.toArray(new int[result.size()][]);

            // if (e < currS) { //no overlap, before
            //     result.add(intervals[i]);
            // } else if (s > currE) { //no overlap, after
            //     int[] newInt = {currS, currE};
            //     result.add(intervals[i]);
            //     result.add(newInt);

            //     if (i != intervals.length - 1) { //update curr vals
            //         currS = intervals[i + 1][0];
            //         currE = intervals[i + 1][1];
            //         System.out.println("new vals! curr s " + currS + " curr e " + currE);
            //     }
                
        //     } else { //over lap
        //         currS = Math.min(currS, s);
        //         currE = Math.max(currE, e);
        //         System.out.println("curr s " + currS + " curr e " + currE);
        //     } 

        // }

//if last item was currE and never added, need to do

        // if (result.isEmpty() || (currS != result.get(result.size() - 1)[0] && currE != result.get(result.size() - 1)[1])) {
        //     int[] newInt = {currS, currE};
        //     result.add(newInt);
        // }

        // return result.toArray(new int[result.size()][]);

        
    }
}
