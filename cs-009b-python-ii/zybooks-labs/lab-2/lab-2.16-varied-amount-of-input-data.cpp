// https://learn.zybooks.com/zybook/UCRCS009CMontanoWinter2024/chapter/2/section/16
/*2.16 LAB: Varied amount of input data
Statistics are often calculated with varying amounts of input data. Write a program that takes any number of non-negative integers as input, and outputs the max and average. A negative integer ends the input and is not included in the statistics. Assume the input contains at least one non-negative integer.
Output each floating-point value with two digits after the decimal point, which can be achieved by executing cout << fixed << setprecision(2); once before all other cout statements.

Ex: When the input is:
  15 20 0 3 -1
the output is:
  20 9.50*/

#include <iostream>
#include <iomanip>
using namespace std;

int main() {
    // Negative int ends input & not included in calculations
    double valueInput;
    double total;
    int ctr;
    double average;
    double maxVal = 0;

    cin >> valueInput;
    while(valueInput >= 0) {
        if(valueInput > maxVal) {
            maxVal = valueInput;
        }

        total += valueInput;
        ctr++;

        cin >> valueInput;
    }

    average = total / ctr;
    cout << fixed << setprecision(2);

    cout << total << " " << average << endl;

   return 0;
}