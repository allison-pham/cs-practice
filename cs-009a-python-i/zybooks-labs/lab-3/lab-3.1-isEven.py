'''7.1 isEven
Write a Python function called isEven(n) that accepts a single argument, an integer n, and returns True if n is even and False if n is odd.

You should use the % operator (the "mod" operator) to determine if a value is even or odd. Remember that in Python n % d returns the remainder when n is divided by d (assuming n >= 0).'''

# Define your function here
def isEven( n ) : 
     # write code here to return either True or False 
    if n % 2 == 0: # Even
        return True
    else:
        return False;

if __name__ == '__main__':
    # calls your function here
    input_value = int ( input ( "Enter a number ") ) 
    print ("Is the number even?  ", isEven(  input_value ) ) 