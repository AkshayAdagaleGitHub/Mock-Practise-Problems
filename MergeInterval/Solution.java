 /*
56. Merge Intervals
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. 
Please reset to default code definition to get new method signature.

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]


 [[1,3],[2,6],[8,10],[15,18]]


   [1,3],[2,6]
  
StartT = list.get(0)[0] -> 1
EndT = list.get(0)[1]  -> 3

 currentStartT = 2
 currentEndT = 6
 
 2 >= 1 && 6 >= 3
 if( st <= cst <= et )
  et = max(et, cet)
  
 startT = 1
 EndT = 6
 [1,6]
  
  [1,3],[2,6] => pervStart=1, prevEnd=3=>6 , currStart=2,currEnd=6
  outputPair=1,6
*/

public static int[][] mergeIntervals(int intervals[][]){
  
  // Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
  Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

  List<int[]> result = new LinkedList<>();
  result.add(new int[]{intervals[0][0], intervals[0][1]});
  
  for(int i[] : intervals){
      int currStartTime = i[0];
      int currEndTime = i[1];
      int getLast[] = result.get(result.size() - 1);
      if(getLast[0] <= currStartTime && currStartTime <= getLast[1] ){
        result.remove(result.size() - 1);
        result.add(new int[]{getLast[0], Math.max(currEndTime, getLast[1])});
      }else{
        result.add(new int[]{currStartTime, currEndTime});
      }
   }
  
  return result.toArray(new int[result.size()][]);
  
}
