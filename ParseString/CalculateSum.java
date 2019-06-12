```
import java.io.*;

class CalculateSum {
	public static void main (String[] args) {
		System.out.println("Hello Java");
    System.out.println(calculateSum("+10b20 -50 +5b60 +100", 0));
	}


  public static int calculateSum(String inputString, int total){
    
    if(inputString == null || inputString.isEmpty()){
        return 0;
      }

        String array[] = inputString.split(" ");
          for(int i = 0; i < array.length; i++){
            String s = array[i];
            if(s.contains("b")){
                
                String splitByBArray[] =  s.split("b");    // +10 | 20
                String stringSign = splitByBArray[0];
                String sign = stringSign.substring(0);
                String splitFirstNumber = splitByBArray[0].substring(1,splitByBArray[0].length()); // +10
              
                int first = Integer.parseInt(splitFirstNumber);
                int second =  Integer.parseInt(splitByBArray[1]);
                int sum = first * second;
                    if(sign == "-"){
                        total = total - sum;
                    } else {
                      total = total + sum;
                    }
                } else 
                 {
                  int first = Integer.parseInt(s.substring(1,s.length())); // 50
                   if(s.charAt(0) == '-'){
                          total = total - first;
                    } else {
                        total = total + first;
                    }
                }             
          }
    return total;
  }
}
```
