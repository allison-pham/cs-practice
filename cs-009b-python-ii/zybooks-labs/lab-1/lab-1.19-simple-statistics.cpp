// https://learn.zybooks.com/zybook/UCRCS009CMontanoWinter2024/chapter/1/section/19
/*1.19 LAB: Simple statistics
Part 1
  Given 4 integers, output their product and their average using integer arithmetic.

  Ex: If the input is:
    8 10 5 4
  the output is:
    1600 6

  Note: Integer division discards the fraction. Hence the average of 8 10 5 4 is output as 6, not 6.75.
  Note: The test cases include four very large input values whose product results in overflow. You do not need to do anything special, but just observe that the output does not represent the correct product (in fact, four positive numbers yield a negative output; wow).
  Submit the above for grading. Your program will fail the last test cases (which is expected), until you complete part 2 below.

Part 2
  Also output the product and average using floating-point arithmetic.
  Output each floating-point value with three digits after the decimal point, which can be achieved by executing
    cout << fixed << setprecision(3); once before all other cout statements.
  Hint: Convert the input values from int to double.

  Ex: If the input is:
    8 10 5 4
  the output is:
    1600 6
    1600.000 6.750

  Note that fractions aren't discarded, and that overflow does not occur for the test case with large values.*/

#include <iostream>
#include <iomanip>
using namespace std;

int main() {
   int num1;
   int num2;
   int num3;
   int num4;
   
   cin >> num1;
   cin >> num2;
   cin >> num3;
   cin >> num4;
   
   // Part 1: int
   int product1 = num2 * num3 * num4;
   int average1 = num1 + num2 + num3 + num4;
   
   cout << num1 * product1 << " " << average1 / 4 << endl;
   
   // Part 2: double
   double product2 = static_cast<double>(num1) * static_cast<double>(num2) * static_cast<double>(num3) * static_cast<double>(num4);
   double average2 = static_cast<double>(average1) / 4;
   
   cout << fixed << setprecision(3);
   cout << product2 << " " << average2 << endl;
   

   return 0;
}