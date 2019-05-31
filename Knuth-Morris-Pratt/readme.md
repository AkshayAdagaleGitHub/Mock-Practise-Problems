# Find whether the s1 in present in s2 in O(N) Time
```
s1:  ABCDEFGHIJ
s2:   DEFG

s1:  ABABCABDABF
s2:  ABD

Input:  txt[] = "THIS IS A TEST TEXT"
                pat[] = "TEST"
Output: Pattern found at index 10

Input:  txt[] =  "AABAACAADAABAABA"
        pat[] =  "AABA"
Output: Pattern found at index 0
        Pattern found at index 9
        Pattern found at index 12
Input:  txt[] =  "AABAACAADAABAABA"
      pat[] =  "AABA"
```
```
-------------------------------------------------------------------------------------------------
               i
               0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26
 Text          a c b a c x a b c d a  b  x  a  b  c  d  a  c  b  a  c  d  a  b  c  y
 
               j 
               0 1 2 3 4 5 6 7 8 9 
 Pattern       a c b a c d a b c y
               0 0 0 1 2 0 1 0 0 0

------------------------------------------------------------------------------------------------
```

