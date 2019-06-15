public class TrappingWater {

	public static void main(String[] args) {

		int[][] heigths = {null, // 0
	 			   {}, // 0
				   {1}, // 0
				   {1,0}, // 0
				   {1,2}, // 0
				   {3,0,3}, // 3
				   {3,1,2}, // 1
				   {3,4,5}, // 0
				   {3,0,2,0,4}, //7
		      {0,1,0,2,1,0,1,3,2,1,2,1} //6
						       };
		for(int i = 0; i < heigths.length; i++) {
				System.out.println(trappedRainWater(heigths[i]));
		}
	}

	
	public static int trappedRainWater(int[] heights) {
		
		if(heights == null || heights.length < 3) {
			return 0;
		}
		
		int leftIndex = 0;
		int rightIndex = heights.length - 1;
		
		int leftMax = heights[leftIndex];
		int rightMax = heights[rightIndex];
		
		int answer = 0;
		
		while(leftIndex < rightIndex) {
			if(heights[leftIndex] < heights[rightIndex]) {
				if(heights[leftIndex] >= leftMax) 
					leftMax = heights[leftIndex];					
				else 
					answer += leftMax - heights[leftIndex];
			leftIndex++;
			} else {
				if(heights[rightIndex] >= rightMax)
					rightMax = heights[rightIndex];
				else
					answer += rightMax - heights[rightIndex];
			rightIndex--;
			}
		}
	
		return answer;
	}
}
