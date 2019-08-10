import java.io.*;
import java.util.*;

class MyCode {
	public static void main (String[] args) {
		System.out.println("Hello Java");
    Map<String,Integer> names = new HashMap<>();
    names.put("chris", 5);
    names.put("kris",15);
    names.put("christopher",3);
    names.put("kate",6);
    names.put("cate",7);
    names.put("catherine",12);

    ArrayList<String> pairs = new ArrayList<String>();
    pairs.add("chris,christopher");
    pairs.add("christopher,kris");
    pairs.add("catherine,cate");
    pairs.add("cate,kate");

    generateadjacencyList(names, pairs);

  }


  public static void generateadjacencyList(Map<String, Integer> names, ArrayList<String> pairs){
      Map<String, ArrayList<String>> vertices = new HashMap<>();

      for(Map.Entry<String,Integer> key : names.entrySet()){
          if(!vertices.containsKey(key.getKey())){
             vertices.put(key.getKey(), new ArrayList<String>());
          }
      }

      for(String s : pairs){
        String[] split = s.split(",");
            if(vertices.containsKey(split[0])){
                vertices.get(split[0]).add(split[1]);
               // System.out.println(vertices);
                vertices.get(split[1]).add(split[0]);
            }
      }
      
    traverseList(vertices, names);
  }
    //
  public static void traverseList(Map<String, ArrayList<String>> vertices, Map<String, Integer> names){
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        HashMap<String, Integer> result = new HashMap<>();
      
      for(Map.Entry<String,Integer> key : names.entrySet()){   
        if(!visited.contains(key.getKey())){
          queue.add(key.getKey());
          bfs(queue, visited, result, names, vertices);
        }
      }
      System.out.println(result);

  }

  public static void bfs(Queue<String> queue, Set<String> visited,HashMap<String, Integer> result, Map<String, Integer> names,Map<String, ArrayList<String>> vertices){
      String firstName = "";
      boolean isSet = false;
      int sum = 0;
      while(!queue.isEmpty()){
          String name = queue.remove();
          if(!isSet){
              firstName = name;
              isSet = true;
              result.put(name, result.getOrDefault(name, 0) + names.get(name));
          }
          if(!visited.contains(name)){
              visited.add(name);
              List<String> edges = vertices.get(name);
              for(String edge : edges){
                if(!visited.contains(edge)){
                    queue.add(edge);
                    sum = sum + names.get(edge);
                  }
                }
          }
      }
      result.put(firstName, result.getOrDefault(firstName, 0) + sum);
  }
}
