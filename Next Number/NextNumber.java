import java.io.*;
import java.util.Arrays;


class NextNumber {
	public static void main (String[] args) {
		System.out.println("Hello Java");
    int n[] = {1234, 2138765, 12, 10, 84, 9};
    
    for(int num : n){
     System.out.println("Number is " + num + " " + nextNumber(num));
    }

	}
  

  public static int nextNumber(int number){
    
    if(number == 0){
        return 0;
    }

    String sNumber = ""+number;
    int length = sNumber.length() - 1;
    char numberArray[] = sNumber.toCharArray(); 

    int pos = -1;
    
    for(int i = length - 1; i >= 0; i--){
        if(numberArray[length] > numberArray[i] ){
            char temp = numberArray[length];
            numberArray[length] = numberArray[i];
            numberArray[i] = temp;
            pos = i;
            break;
        }
    }

      if(pos >= 0){
          char sortA[] = new char[length - pos];
          for (int i = pos + 1, j=0; i <= length; i++,j++) 
             sortA[j] = numberArray[i];
          Arrays.sort(sortA);
          for (int i = pos + 1, j=0; i <= length; i++,j++) 
              numberArray[i] = sortA[j];
        }

    return Integer.parseInt(new String(numberArray));
  }
}
