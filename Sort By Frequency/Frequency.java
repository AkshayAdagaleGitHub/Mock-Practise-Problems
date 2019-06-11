import java.io.*;
import java.util.*;

class Frequency {
	public static void main (String[] args) {
		System.out.println("Hello Java");
    int[][] inputs = {
                         null,
                         {},
                         {1},
                         {1,1},
                         {1,1,2,2},
                         {1,1,2,2,3},
                         {3,1,2,2,4,0,0,0}
                     };

    for(int []input: inputs) {
      int[] result = sortByOccurenceFreqAndThenByValue(input);
      print(input, result);
    }
        
	}

  public static void print(int[] array1, int [] array2) {
    if (array1 == null || array1.length == 0)
       return;
    for(int element: array1)
       System.out.print(element + " ");
    System.out.print("       ");
     for(int element: array2)
       System.out.print(element + " ");
    System.out.println();
  }

  public static int[] sortByOccurenceFreqAndThenByValue(int[] array) {
      if (array == null || array.length == 0)
         return array;
      Map<Integer, Integer> frequencyMap = new HashMap<>();
      for(int element: array) {
        if(frequencyMap.containsKey(element)) {
          int count = frequencyMap.get(element); 
          frequencyMap.put(element, ++count); 
        } else 
          frequencyMap.put(element, 1); 
      }

      Map<Integer, List<Integer>> sortByFreqMap = new TreeMap<>();
      for(Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()) {
          int key = entry.getKey(); 
          int value = entry.getValue(); 
          if(sortByFreqMap.containsKey(value)) {
             List<Integer> list = sortByFreqMap.get(value);
             list.add(key);
          } else {
             List<Integer> list = new ArrayList<>();
             list.add(key);// {0}
             sortByFreqMap.put(value, list); 
          }
      }
                                              
      int[] result = new int[array.length];          
      int i = 0;
      for(Map.Entry<Integer, List<Integer>> entry: sortByFreqMap.entrySet()) {
          int key = entry.getKey();
          List<Integer> values = entry.getValue(); 
          Collections.sort(values); 
          for(int value: values) {
              for(int k = 0; k < key; k++) 
                 result[i++] = value; 
          }
      }
      return result; 

  }
}
