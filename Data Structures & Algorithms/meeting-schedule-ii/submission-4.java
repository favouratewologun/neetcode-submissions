/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        //need to keep track of the latest time in each. iterate through. add if not

        //hashmap of rooms, iterate through all each time?? doesnt that affect time complexity...

        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (Interval inter : intervals) {
            int end = inter.end;

            if (!heap.isEmpty() && heap.peek() <= inter.start) {
                heap.poll();
            }
            heap.offer(end);
        }

        return heap.size();

        // if (intervals.size() == 0)
        //     return 0;

        // int roomTrack = 1;
        // HashMap<Integer, Integer> rooms = new HashMap<>();
        // rooms.put(roomTrack, intervals.get(0).end);

        // for (int i = 1; i < intervals.size(); i++) {
        //     Interval interval = intervals.get(i);

        //     //if hashmap end < curr start, add to room
        //     //if make it to the end, add a new room, but to hashmap
        //     int ind = 1;
        //     while (ind <= roomTrack) {
        //         if (rooms.get(ind) <= interval.start) {
        //             rooms.put(ind, interval.end); //might need to math.max? not sure
        //             break;
        //         } else {
        //             ind++;
        //             if (ind > roomTrack) { //no valid rooms
        //                 rooms.put(ind, interval.end); //wait so i can combbine them? nvm.
        //                 roomTrack++;
        //                 System.out.println("new room " + interval.start + " " + interval.end);
        //                 break;

        //                 //new room created
        //             }
        //             //should auto break loop
        //         }
        //     }


        // }

        // return rooms.size();

    }
}
