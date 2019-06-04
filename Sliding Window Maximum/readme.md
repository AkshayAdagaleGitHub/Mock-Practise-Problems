# Question
-------------------------
```
Sliding Window Maximum (Maximum of all subarrays of size k) using stack in O(n) time
Give an array arr[] of N integers and another integer k ≤ N.
The task is to find the maximum element of every sub-array of size k.

Examples:

Input: arr[] = {9, 7, 2, 4, 6, 8, 2, 1, 5}, k = 3
Output: 9 7 6 8 8 8 5
Window 1: {9, 7, 2}, max = 9
Window 2: {7, 2, 4}, max = 7
Window 3: {2, 4, 6}, max = 6
Window 4: {4, 6, 8}, max = 8
Window 5: {6, 8, 2}, max = 8
Window 6: {8, 2, 1}, max = 8
Window 7: {2, 1, 5}, max = 5

Input: arr[] = {6, 7, 5, 2, 1, 7, 2, 1, 10}, k = 2
Output: 7 7 5 2 7 7 2 10
```
