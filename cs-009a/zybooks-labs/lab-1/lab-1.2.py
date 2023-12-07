'''2.2 LAB: Convert to dollars
Given three input values representing counts of nickels, dimes, and quarters, output the total amount as dollars and cents.

Output each floating-point value with two digits after the decimal point using the following statement:
print(f'Amount: ${dollars:.2f}')

Ex: If the input is:
3
1
4

where 3 is the number of nickels (at $0.05 each), 1 is the number of dimes (at $0.10 each), and 4 is the number of quarters (at $0.25 each), the output is:
Amount: $1.25

For simplicity, assume input is non-negative.'''

nickels = input()
dimes = input()
quarters = input()

c5 = float(nickels) * 0.05
c10 = float(dimes) * 0.10
c25 = float(quarters) * 0.25
dollars = c5 + c10 + c25

print(f'Amount: ${dollars:.2f}')