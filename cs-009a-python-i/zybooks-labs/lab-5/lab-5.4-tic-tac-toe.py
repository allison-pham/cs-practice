'''11.4 Tic Tac Toe
Create a nested list to represent the tic tac toe board below.
Then lets write a function to determine if there is a winner. Write a function called winner (L) that takes the list as input and returns True if there is a winner and False otherwise.'''

def winner ( L ):
    # check for winner
    if L[0][0] == L[0][1] == L[0][2] :  # if all values on first row match, return True
        return True
    elif L[1][0] == L[1][1] == L[1][2]: # TODO write condition to check 2nd row
        return True
    elif L[2][0] == L[2][1] == L[2][2]: # TODO write condition to check 3rd row
        return True   
    elif L[0][0] == L[1][0] == L[2][0]: # TODO write condition to check 1st column
        return True   
    elif L[0][1] == L[1][1] == L[2][1]: # TODO write condition to check 2nd column
        return True   
    elif L[0][2] == L[1][2] == L[2][2]: # TODO write condition to check 3rd column
        return True   
    elif L[0][0] == L[1][1] == L[2][2]: # TODO write condition to check diagonal
        return True   
    elif L[0][2] == L[1][1] == L[2][0]: # TODO write condition to check diagonal
        return True   
    else:
        return False # no winner 

if __name__ == '__main__':
    L =  [ ["X","X","O"] , ["O","X","O"], ["O","X","X"] ]
    if winner(L):
        print('Winner')
    else:
        print('No winner')