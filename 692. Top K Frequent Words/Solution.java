class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> hm = new HashMap<>();
        
        for(String s : words){
            hm.put(s, hm.getOrDefault(s, 0) + 1);
        }
        
     PriorityQueue<String> pq = new PriorityQueue<>((n1,n2) -> hm.get(n1).equals(hm.get(n2)) ? n2.compareTo(n1) :
                                                   hm.get(n1) - hm.get(n2));
        
        for(String n : hm.keySet()){
            pq.add(n);
            if(pq.size() > k)
                pq.poll();
        }
        
        List<String> result = new ArrayList<String>();
        
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }
        Collections.reverse(result);
        return result;
    }
}
