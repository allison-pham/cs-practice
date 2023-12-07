'''4.3 LAB: What is your personality type? (optional)
In this lab, you will create a Myer-Briggs Personality quiz. To determine the user's personality, you need to ask them 4 questions and follow the chart below to determine their personality and output the relevant description.
Myers Briggs Types
To begin, ask the user to answer each of the four questions. For example, for Question 1 you can write code to ask user to enter "E" for Extraversion or "I" for Introversion based on what they identify with the most. Note, the below code prompts the user to E or I and then uses the .upper() operation to capitalize the input. Hence, if the user enters lowercase 'e', the .upper() operation would uppercase the result.
Q1 = input("Are you outwardly or inwardly focused? E-Extraversion or I-Introversion ").upper()
Once the user has answered all 4 questions, proceed to combine all the results into one variable called personality.
For example, assume you have two variables X = "Hello and Y = "World", and you would like to combine the two strings. To do this, you can simple assign the result to a third variable Z as follows: Z = X + Y and now Z holds the value "HelloWorld".
X = "Hello"
Y = "World"
Z = X + Y        # generates the value 'HelloWorld'
Once you have the full results as a String, proceed to use If - Else If - Else statements to determine the personality type and output the appropriate message. You can use the following personality short descriptions in your output. Sample output is displayed at the bottom of this page.

if personality == "ISTJ":
    print ("Your personality type is  ISTJ. Factual, practical, organized, steadfast")
elif personality == "ISFJ":
  print ("Your personality type is ISFJ. Detailed, traditional, service-minded, devoted")
...... 
......
By the way, what do you think happens if the user types an invalid output? For example, for Q1 instead of entering an I or an E, the user accidentally enters a G, Does your program catch that an invalid selection is made? Could you add a case that would capture an invalid selection, i.e. a selection that would equal one of the 16 options below?
ISTJ => Factual, practical, organized, steadfast
ISFJ => Detailed, traditional, service-minded, devoted
INFJ => Committed, creative, determined, idealistic
INTJ => Independent, visionary, original, global
ISTP => Logical, realistic, adventurous, self-determined
ISFP => Caring, adaptable, gentle, harmonious
INFP => Compassionate, original, creative, empathetic
INTP => Independent, theoretical, analytical, reserved
ESTP => Activity-oriented, versatile, pragmatic, outgoing
ESFP => Enthusiastic, friendly, cooperative, tolerant
ENFP => Creative, versatile, perceptive, imaginative
ENTP => Enterprising, outspoken, challenging, resourceful
ESTJ => Logical, systematic, organized, conscientious
ESFJ => Thorough, responsible, detailed, traditional
ENFJ => Loyal, verbal, energetic, congenial
ENTJ => Logical, strategic, fair, straightforward

Sample output
Are you outwardly or inwardly focused? E-Extraversion or I-Introversion
i
How do you prefer to take in information? S-Sensing or N-Intuition
s
How do you prefer to make decisions? T-Thinking or F-Feeling
t
How do you prefer to live your outer life? J=Judging or P-perceiving
j
Your personality type is ISTJ. Factual, practical, organized, steadfast'''