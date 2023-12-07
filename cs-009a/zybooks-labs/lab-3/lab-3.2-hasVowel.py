'''7.2 hasVowel
Write a function called hasVowel ( input_string) that takes in a string and returns True if the String has a vowel (a, e, i , o, or u) and False otherwise.

Example:
hasVowel ("apple") # returns True hasVowel ("banana") # return True hasVowel ("gym") # returns False hasVowel ("rhythm") # returns False'''

# Define your function here
def hasVowel ( input_string ):
    if 'a' in input_string:
       return True
    elif 'e' in input_string:
       return True
    elif 'i' in input_string:
       return True
    elif 'o' in input_string:
       return True
    elif 'u' in input_string:
       return True
    else:
        return False

if __name__ == '__main__':
    # calls your function here
    input_string = input("")
    print ( "Does the input string " , input_string , " have a vowel? ",    hasVowel ( input_string) ) 