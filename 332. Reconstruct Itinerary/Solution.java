class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        HashMap<String, PriorityQueue<String>> adjacencyList = new HashMap<>();
		traverseThroughList(tickets, adjacencyList);
        
        String currentCity = "JFK";
		List<String> result = new ArrayList<String>();
		generateItinerary(adjacencyList, currentCity, result);
        
        return result;
    }
    
    public static void 	traverseThroughList(List<List<String>>list, HashMap<String, PriorityQueue<String>> adjacencyList) {
		for(List<String> l : list) {
			if(!adjacencyList.containsKey(l.get(0))) {
				adjacencyList.put(l.get(0), new PriorityQueue<String>());
			}
			adjacencyList.get(l.get(0)).add(l.get(1)); //new PriorityQueue<String>());
		}
	}
    
    public static void generateItinerary(HashMap<String, PriorityQueue<String>> adjacencyList, String currentCity, List<String> result){
		PriorityQueue<String> pq = adjacencyList.get(currentCity);
		
        while(pq != null && !pq.isEmpty()) {
			generateItinerary(adjacencyList, pq.poll(), result);
        }
          result.add(0,currentCity);
	}    
}
