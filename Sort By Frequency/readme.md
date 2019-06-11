```
Question
Sort by frequesncy of occurance then by value within each frequency. 

input Array ={3,1,2,2,4,0,0,0}
Output : [1,3,4,2,2,0,0,0]


Diagramming Solution
K(Integer)                   V(Frequency)
3                                 1
1                                 1
2                                 2
4                                 1
0                                 3

K(Integer)                    V(List of values)
  1                               {3,1,4}
  2                               {2}
  3                               {0}

  {3, 1, 4}
  {1,3,4}
  {2}
  {0}

  {1, 3, 4, 2, 2, 0, 0, 0}




1. Prepare a hash map with key as what appears in array and value as frequency
2. Prepare a Tree map with key as frequency and value is whatever was key
in step 1. Given that the same frequency may be present, the value has to be 
a list.
3. Traverse tree map, get list.
   Sort the list
   Print each element frequency times

```
