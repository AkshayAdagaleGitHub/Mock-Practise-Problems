## Array of Array Products
Given an array of integers arr, you’re asked to calculate for each index i the product of all integers except the integer at that index (i.e. except arr[i]). Implement a function arrayOfArrayProducts that takes an array of integers and returns an array of the products.

Solve without using division and analyze your solution’s time and space complexities.

## Examples:

input:  arr = [8, 10, 2]
output: [20, 16, 80] # by calculating: [10*2, 8*2, 8*10]

input:  arr = [2, 7, 3, 4]
output: [84, 24, 56, 42] # by calculating: [7*3*4, 2*3*4, 2*7*4, 2*7*3]
## Constraints:

[time limit] 5000ms

[input] array.integer arr

0 ≤ arr.length ≤ 20
[output] array.integer


## Array of Array Products
A brute force approach would be to use two nested loops: for each index i in arr[i], loop over arr while multiplying all the other values and place the result in the ith element of the new array.

## Pseudocode:

function calcProductArray(arr):
    n = arr.length
    if (n == 0 OR n == 1):
        # nothing to multiply if n equals to 0 or 1
        return []

    productArr = []
    for i from 0 to n-1:
        product = 1
        for j from 0 to n-1:
            if(i != j):
                product *= arr[j]

        productArr[i] = product

    return productArr
This gives us an O(N^2) time complexity. We can do better.

When we multiply all values of arr before and after each index, we get our answer — the product of all the integers except arr[i].

function calcProductArray(arr):
    n = arr.length
    if(n == 0 OR n == 1):
        # no values to multiply if n equals to 0 or 1
        return []

    productArr = []
    product = 1
    for i from 0 to n-1:
        productArr[i] = product
        product *= arr[i]

    product = 1
    for i from n-1 to 0:
        productArr[i] *= product
        product *= arr[i]

    return productArr
Time Complexity: two passes through arr and constant time work for each value in it, bring us to linear O(N) runtime complexity.

Space Complexity: from using an additional array of length n (i.e. productArr) to hold the products, we get a linear O(N) space complexity.
