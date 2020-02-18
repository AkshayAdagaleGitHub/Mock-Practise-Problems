 /* LC# 127 Word Ladder
  Given two words (beginWord and endWord), and a dictionary's word list,
   find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

beginWord = "hit",
endWord = "cog",

wordList = ["hot","dot","dog","lot","log","cog"]


  hot   dot   "dog",  "lot",  "log",  "cog"
  hit -> hot,
  hot -> dot, hit
  dot -> hot, dog
  dog -> dot, log, cog
  lot -> hot, dot, log
  log -> lot, cog, 
  cog -> log, dog, 
 
Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
  */
   static class Tuple{
     String word;
     int distance;
     
     public Tuple(String word, int distance){
       this.word = word;
       this.distance = distance;
     }
   } 
   
  public static boolean oneDiff(String w1, String w2){
    int diffCount=0;
    if(w1.equals(w2)){
      return false;
    }
    for(int i = 0; i < w1.length(); i++){ 
      if(w1.charAt(i) != w2.charAt(i) ){
        diffCount++;
      }
      if(diffCount > 1 ){
        return false;
      }
    }
    return diffCount==1;
  }
  
  public static int wordLadder(String beginWord, String endWord, List<String> wordList){
    Map<String, List<String>> map = new HashMap<>();
    System.out.println(endWord);
    for(int i = -1; i < wordList.size(); i++){
      String startWord =  beginWord; 
      
      if(i == -1){
        startWord = beginWord;
        } else {
          startWord =  wordList.get(i);
        }
        for(int j = 0; j < wordList.size(); j++){
          if(oneDiff(startWord, wordList.get(j))){
            if(!map.containsKey(startWord)){
              map.put(startWord, new ArrayList<>());
            }
              map.get(startWord).add(wordList.get(j));
          }
        }
    }
    System.out.println(map);
    
    Queue<Tuple> queue = new LinkedList<>();
    queue.add(new Tuple(beginWord, 1));
    Map<String, Integer> visited = new HashMap<>();
    
    while(!queue.isEmpty()){
      Tuple currentWord = queue.remove();
      String word = currentWord.word;
      int distance = currentWord.distance;
      System.out.println(map.get(currentWord.word));
        if(map.get(word) != null){
          for(String adjWord : map.get(word)){
              if(!visited.containsKey(adjWord)){
                  visited.put(adjWord, distance+1);
                  queue.add(new Tuple(adjWord, distance + 1));
                  if(adjWord.equals(endWord)){
                    System.out.println(visited.get(adjWord));
                    return visited.get(adjWord);
                  }
              }      
          }
        }
    }
    return 0;
  }
