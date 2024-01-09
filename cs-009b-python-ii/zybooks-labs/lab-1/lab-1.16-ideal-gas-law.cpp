// https://learn.zybooks.com/zybook/UCRCS009CMontanoWinter2024/chapter/1/section/16
/*1.16 LAB: Expression for Ideal Gas Law
The following equation approximates the behavior of a hypothetical ideal gas, rearranged to solve for pressure:
  Pressure = ( (Amount of Substance x 8.314 x ( ( Temperature - 32 ) x 5/9 + 273.15) ) / Volume )
Write a program using inputs amount of substance (moles), temperature (Fahrenheit), and volume (Liters), respectively. Output the approximate pressure for a hypothetical ideal gas.

Output each floating-point value with two digits after the decimal point, which can be achieved by executing
cout << fixed << setprecision(2); once before all other cout statements.

Hint: Keep in mind that integer division truncates the result i.e. 1/2 = 0, while 1.0/2.0 = 0.5

Ex: If the input is:
  115 335 13
the output is:
  Pressure: 32469.74 pascals*/

#include <iostream>
#include <iomanip>
using namespace std;

int main() {
   float substance;
   float temperature;
   float volume;
   float pressure;
   
   cin >> substance;
   cin >> temperature;
   cin >> volume;
   
   pressure = ((substance * 8.314 * ((temperature - 32) * 5/9 + 273.15)) / volume);
   // Pressure = ( (Amount of Substance x 8.314 x ( ( Temperature - 32 ) x 5/9 + 273.15) ) / Volume )
   
   cout << fixed << setprecision(2);
   
   cout << "Pressure: " << pressure << " pascals" << endl;
   
   return 0;
}
