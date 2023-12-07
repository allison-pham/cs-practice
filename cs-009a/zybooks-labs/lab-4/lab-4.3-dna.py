'''9.3 Analyze DNA
A DNA string is a string representing the order of nucleobases along one strand of a double-stranded DNA molecule; the other strand is given by the reverse complement of the string.
DNA strings are constructed from the alphabet {A, C, G, T}, whose symbols represent the bases adenine, cytosine, guanine, and thymine. As an example, "AAGATGCCGT" is a DNA string of length 10.
Let us write some code that reads in a DNA string from the user, and prints four integers which represent the number of times that the symbols 'A', 'C', 'G', and 'T' occur in the DNA string dnaSequence.

Example output if the input is ACTGAAAACTGGACTG
A: 6, C: 3, G: 4, T: 3'''

userInput = input()
dnaSequence = []

A_count = 0    # define 4 variables to keep track of the count
C_count = 0
G_count = 0
T_count = 0

# Add all values to list
for i in userInput:
    dnaSequence.append(i)

# Finds the # of times A, C, G, or T is in dnaSequence
for base in dnaSequence:
    # your code goes here
    # write code to evaluate whether the 'base' is equal to A, C, G, or T. 
    # update the appropriate variables (A_count, C_count, G_count, or T_count)
    if base == 'A':
        A_count += 1
    if base == 'C':
        C_count += 1
    if base == 'G':
        G_count += 1
    if base == 'T':
        T_count += 1
    
print(f'A: {A_count} C: {C_count} G: {G_count} T: {T_count}')