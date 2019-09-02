class Solution {
    public int minMeetingRooms(int[][] intervals) {
     if(intervals == null || intervals.length == 0) {
    	 return 0;
     }
     
     Arrays.sort(intervals, (a,b) -> a[0]- b[0]);
     PriorityQueue<Integer> meetingRoomQueues = new PriorityQueue<Integer>((a,b) -> a - b);
     meetingRoomQueues.add(intervals[0][1]);
     for(int i = 1; i < intervals.length; i++) {
    	 if(intervals[i][0] >= meetingRoomQueues.peek())
    		 meetingRoomQueues.poll();
    	  meetingRoomQueues.add(intervals[i][1]);
     }
     return meetingRoomQueues.size();
    }
}
