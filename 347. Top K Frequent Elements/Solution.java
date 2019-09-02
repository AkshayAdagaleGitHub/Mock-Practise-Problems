class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> occurances = new HashMap<>();
        for(int i : nums)
            occurances.put(i, occurances.getOrDefault(i, 0) + 1);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2) -> occurances.get(n1) - occurances.get(n2));
        
        for(int n : occurances.keySet()){
            pq.add(n);
            if(pq.size() > k)
                pq.poll();
        }
        
        List<Integer> result = new ArrayList<Integer>();
        
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }
        // for(int n : pq)
        //     result.add(n);
        Collections.reverse(result);
        return result;
    }
}
