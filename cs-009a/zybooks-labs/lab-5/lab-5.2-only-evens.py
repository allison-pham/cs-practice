'''11.2 LAB: Only Evens
Write a function called onlyEvens( L ) that accepts a list of integers (not in any sorted order) and returns a new list of integers where every odd number has been replaced by 0.

Sample Input: [1, 5, 2, 3, 4]
Sample Output: [0, 0, 2, 0, 4]

def onlyEvens( L ):
       # TODO - use a loop to update L such that each odd numbers replaced by 0
       return L'''

def onlyEvens(L):
    for i in range(len(L)):
        if L[i] % 2 != 0:
            L[i] = 0
    return L
        
if __name__ == '__main__':
    result = onlyEvens ( [ 3,5,6,2,10,8] ) 
    print(result)