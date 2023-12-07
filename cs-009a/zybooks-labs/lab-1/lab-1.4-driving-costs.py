'''2.4 LAB: Driving costs (optional)
Driving is expensive. Write a program with a car's gas mileage (miles/gallon) and the cost of gas (dollars/gallon) as floating-point input, and output the gas cost for 20 miles, 75 miles, and 500 miles.

Output each floating-point value with two digits after the decimal point, which can be achieved as follows:
print(f'{your_value1:.2f} {your_value2:.2f} {your_value3:.2f}')

Ex: If the input is:
25.0
3.1599

where the gas mileage is 25.0 miles/gallon and the cost of gas is $3.1599/gallon, the output is:
2.53 9.48 63.20

Note: Real per-mile cost would also include maintenance and depreciation.'''

mileage = float(input())
gas_cost = float(input())

miles_20 = (20 / mileage) * gas_cost
# gas needed / mileage = % wanted
# (% wanted) * cost
miles_75 = (75 / mileage) * gas_cost
miles_500 = (500 / mileage) * gas_cost

print(f'{miles_20:.2f} {miles_75:.2f} {miles_500:.2f}')