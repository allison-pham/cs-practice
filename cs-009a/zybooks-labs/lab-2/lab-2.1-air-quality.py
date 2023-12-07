'''4.1 LAB: Air Quality Index
The purpose of the Air Quality Index (AQI) is to help us understand what local air quality means to our health. The higher the AQI value, the greater the level of air pollution, which means the greater the health concerns. It's an easy way to determine if we can enjoy the outdoors as usual or if we should consider planning an indoor activity to reduce exposure to polluted air. If curious, checkout the air quality in Riverside on Weather Underground.

Good is 0 to 50. No health impacts are expected when air quality is in this range.
Moderate is 51 to 100. People who have a unique sensitivity to air pollution should consider limiting prolonged or heavy outdoor exertion.
Unhealthy for Sensitive Groups is 101 to 150. People with heart and lung disease, older adults and children are at a greater risk and should limit prolonged or heavy outdoor exertion.
Unhealthy is 151 to 200. Everyone may begin to experience some adverse health effects and should limit prolonged or heavy outdoor exertion. Members of the sensitive groups should avoid prolonged outdoor exertion.
Very Unhealthy is 201 to 300. People with heart and lung disease, older adults and children should avoid all outdoor physical activity. Everyone else should avoid prolonged or heavy outdoor exertion.
Hazardous is 301 to 500. The entire population is more likely to experience serious health effects and should avoid all outdoor physical activity, remain indoors and keep activity levels low.

Write a program that prompts a user to enter the AQI value and then determine the air quality level and corresponding message. If the user enters an invalid input or input out of range, then you should print out "Invalid input". Please note, the output must match exactly to pass the test cases.
Below is sample output (bold = user input)
Enter the AQI: 215
Very Unhealthy is 201 to 300. People with heart and lung disease, older adults and children should avoid all outdoor physical activity. Everyone else should avoid prolonged or heavy outdoor exertion

Enter the AQI: 600
Invalid Input

Enter the AQI: 15
Good is 0 to 50. No health impacts are expected when air quality is in this range.'''

air_quality_index = int(input('Enter in an AQI to see the quality of the air.'))

if 0 <= air_quality_index <= 50:
    print('Good is 0 to 50. No health impacts are expected when air quality is in this range.')

elif 51 <= air_quality_index <= 100:
    print('Moderate is 51 to 100. People who have a unique sensitivity to air pollution should consider limiting prolonged or heavy outdoor exertion.')

elif 101 <= air_quality_index <= 150:
    print('Unhealthy for Sensitive Groups is 101 to 150. People with heart and lung disease, older adults and children are at a greater risk and should limit prolonged or heavy outdoor exertion.')
        
elif 201 <= air_quality_index <= 300:
    print('Very Unhealthy is 201 to 300. People with heart and lung disease, older adults and children should avoid all outdoor physical activity. Everyone else should avoid prolonged or heavy outdoor exertion.')
        
elif 301 <= air_quality_index <= 500:
    print('Hazardous is 301 to 500. The entire population is more likely to experience serious health effects and should avoid all outdoor physical activity, remain indoors and keep activity levels low.')

else:
    print('Invalid Input')