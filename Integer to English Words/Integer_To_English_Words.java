''''
import java.io.*;

class MyCode {
 static String[] withInTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", 
 "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
 "Nineteen"};
 static String[] ten = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
 "Ninety"};
 static String[] thousand ={"", "Thousand", "Million", "Billion"};
 
	public static void main (String[] args) {
		System.out.println("Hello Java");
    int num = 1234567891;
    int i = 0;
    String previousWord = "";
    while(num > 0){
        if(num % 1000 != 0){
            previousWord =   breaking(num%1000)  + thousand[i] + " " + previousWord;
        num = num / 1000;
        System.out.println("Number is "+ num);
        i++;
        }
    }
    System.out.println(previousWord);
	}

  public static String breaking(int num){
    if(num == 0){
        return "";
    }else if(num < 20) {
      return withInTwenty[num] + " ";
    }else if (num < 100){
        return ten[num/10] + " " + breaking(num%10); 
    }
    else
      return withInTwenty[num/100] +" "+ "Hundred" + " " + breaking(num%100); 
  }
}
''''
