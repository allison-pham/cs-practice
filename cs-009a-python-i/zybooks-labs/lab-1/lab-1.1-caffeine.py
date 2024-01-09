'''2.1 LAB: Input and formatted output: Caffeine levels
A half-life is the amount of time it takes for a substance or entity to fall to half its original value. Caffeine has a half-life of about 6 hours in humans. Given caffeine amount (in mg) as input, output the caffeine level after 6, 12, and 24 hours. Use a string formatting expression with conversion specifiers to output the caffeine amount as floating-point numbers.

Output each floating-point value with two digits after the decimal point, which can be achieved as follows:
print(f'{your_value:.2f}')

Ex: If the input is:
100

the output is:
After 6 hours: 50.00 mg
After 12 hours: 25.00 mg
After 24 hours: 6.25 mg

Note: A cup of coffee has about 100 mg. A soda has about 40 mg. An "energy" drink (a misnomer) has between 100 mg and 200 mg.'''

caffeine_mg = float(input())
c6 = caffeine_mg / 2
c12 = c6 / 2
c24 = c12 / 4
print('After 6 hours:' + f'{c6: 0.2f}', 'mg')
print('After 12 hours:' + f'{c12: 0.2f}', 'mg')
print('After 24 hours:' + f'{c24: 0.2f}', 'mg')