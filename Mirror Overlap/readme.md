## Question
  https://leetcode.com/problems/image-over
------------
````
Two images A and B are given, represented as binary, square matrices of the same size.  
(A binary matrix has only 0s and 1s as values.)

We translate one image however we choose (sliding it left, right, up, or down any number of units), 
and place it on top of the other image.  
After, the overlap of this translation is the number of positions 
that have a 1 in both images.

(Note also that a translation does not include any kind of rotation.)
What is the largest possible overlap?
Example 1:

Input: A = [[1,1,0],
            [0,1,0],
            [0,1,0]]
       B = [[0,0,0],
            [0,1,1],
            [0,0,1]]
Output: 3
Explanation: We slide A to right by 1 unit and down by 1 unit.
Notes: 

1 <= A.length = A[0].length = B.length = B[0].length <= 30
0 <= A[i][j], B[i][j] <= 1

Input: A =   1,1,0
             0,1,0
             0,1,0

       B =   0,0,0
             0,1,1
             0,0,1

Step 1: Slide A to right by 1 unit
            0,1,1
            0,0,1
            0,0,1

        Down by 1 unit
            0,0,1
            0,1,1
            0,0,1


A:  0 1
    1 0

B:  1 0
    0 1

K         V
A          
                                    A,B
              A go left   A go right   B go left  B go right  A go up A go down B go up B go down                   
