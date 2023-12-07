'''Write a void function MultiplyHalfList() that takes in 1 integer list parameter, numList, and 1 integer multiplier.
This function should multiply ever element in the first half of numList by multiplier.
For example, if numList has 9 elements, the first 4 will be multiplied by multiplier.'''

# Correct Answer
def MultiplyHalfList(numList, multiplier):
    # Consider if the list has an odd or even number of elements
    middleIndex = len(numList) // 2

    for i in range(middleIndex):
        numList[i] *= multiplier

# Original Answer
'''def MultiplyHalfList(numList, multiplier):
    # Consider if list has an odd or even num of elements
    middleIndex = len(numList) // 2
    my_list = numList[0:middleIndex]

    for i in my_list:
        my_list[i] *= multiplier'''