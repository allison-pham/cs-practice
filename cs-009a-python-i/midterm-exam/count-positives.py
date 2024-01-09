'''Write a function CountPositives() that takes in one integer list parameter, data_list,
and returns the number of positive integers in data_list'''

# Correct Answer
def CountPositives(data_list):
    positiveNums = 0

    for i in data_list:
        if i > 0:
            positiveNums += 1

    return positiveNums

# Original Answer
'''def CountPositives(data_list):
    positiveNums = 0

    for i in data_list:
        if data_list[i] > 0:
            positiveNums += 1

    return positiveNums'''