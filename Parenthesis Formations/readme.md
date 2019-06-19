# Question
```
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example:
n = 3
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
```
```
if (totalOpen < n)
  recur(n, totalOpen + 1, totalClose, "" + "(");
if (totalClose < totalOpen)
  recur(n, totalOpen, totalClose + 1, "" + ")");
```
```
                            ""
                          /
                        (  
                   /            \
             ((                   ()
           /    \                /   
        (((     (()            ()(
        \    /      \         /  \
     ((()  (()(      (())  ()((   ()() 
       \     \        /      \      /
    ((())  (()() (())(     ()(()  ()()( 
     \        \       \     \       \ 
    ((()))  (()())   (())() ()(()) ()()()
```
