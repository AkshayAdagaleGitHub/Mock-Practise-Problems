class Reverse {

  static char[] reverseWords(char[] arr) {
    // your code goes here
    int n = arr.length;
    reverse(arr, 0 , n-1);
    int wordStart = -1;
      
    for(int i = 0; i <= n-1; i++){
      if(arr[i] == ' '){
          if(wordStart != -1){
            reverse(arr, wordStart, i-1);
            wordStart = -1;
          }
      }else if(i == n-1){
        if(wordStart != -1){
          reverse(arr, wordStart, i);
        }
          }else{
            if(wordStart == -1){
              wordStart = i;
            }
          }
      }
    return arr;
  }
  
  public static void reverse(char[] arr, int start , int end){
    char temp = ' ';
    while(start < end){
      temp = arr[end];
      arr[end] = arr[start];
      arr[start] = temp;
      end--;
      start++;
    }
  }
  public static void main(String[] args) {
    char[] arr = {'p', 'e', 'r', 'f', 'e', 'c', 't', ' ','m', 'a', 'k', 'e', 's', ' ','p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};
    reverseWords(arr);
  }

}
