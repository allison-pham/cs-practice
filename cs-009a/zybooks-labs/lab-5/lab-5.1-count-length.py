'''11.1 LAB: Count input length without spaces, periods, exclamation points, or commas
Given a line of text as input, output the number of characters excluding spaces, periods, exclamation points, or commas.

Ex: If the input is:
Listen, Mr. Jones, calm down.

the output is:
21

Note: Account for all characters that aren't spaces, periods, exclamation points, or commas (Ex: "r", "2", "?").'''

user_text = input()

def counting(user_text):
    count = 0
    for i in user_text:
        if i != ' ' and i != '.' and i != '!' and i != ',':
            count += 1
    return count

print(f"{counting(user_text)}")

'''def counting(userInput):
    count = 0
    for i in userInput:
        if i != ' ' and i != '.' and i != '!' and i != ',':
            count += 1
    return len(userInput) - count'''