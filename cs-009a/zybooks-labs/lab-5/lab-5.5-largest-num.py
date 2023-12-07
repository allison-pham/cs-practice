'''11.5 LAB: Largest Number (Nested Lists)
Write a Python function larger( L ) that accepts a list which contains nested lists of integers. It should return a list of integers containing the largest of each inner (nested) list.

Sample Input
[ [2, 3, 1] , [4, 5] , [6, 1, 3, 4] ]

Sample Output
[3, 5, 6]'''

def larger(L):
# define your function here
    out = []
    for i in L:
        largest = i[0]
        # largest = 0
        # Need to consider non-positive numbers
        for k in i:
            if k > largest:
                largest = k
        out.append(largest)
    return out
        
if __name__ == '__main__':
    inputList = [ [2, 3, 1] , [4, 5] , [6, 1, 3, 4] ]
    print (larger(inputList))
    inputList = [ [1], [1, 2, 5], [2, -1], [3, 8, 2, 4, 1] ]
    print (larger(inputList))