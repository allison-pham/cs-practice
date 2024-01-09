// https://learn.zybooks.com/zybook/UCRCS009CMontanoWinter2024/chapter/1/section/14
/*1.14 LAB: Warm up: Basic output with variables
This zyLab activity prepares a student for a full programming assignment. Warm up exercises are typically simpler and worth fewer points than a full programming assignment, and are well-suited for an in-person scheduled lab meeting or as self-practice.
A variable like userNum can store a value like an integer. Extend the given program as indicated.
  1. Output the user's input. (2 pts)
  2. Output the input squared and cubed. Hint: Compute squared as userNum * userNum. (2 pts)
  3. Get a second user input into userNum2, and output the sum and product. (1 pt)

Note: This zyLab outputs a newline after each user-input prompt. For convenience in the examples below, the user's input value is shown on the next line, but such values don't actually appear as output when the program runs.

  Enter integer:
  4
  You entered: 4
  4 squared is 16 
  And 4 cubed is 64!!
  Enter another integer:
  5
  4 + 5 is 9
  4 * 5 is 20*/

#include <iostream>
using namespace std;

int main() {
   int userNum;
   int userNum2;
   int squared;
   int cubed;

   cout << "Enter integer:" << endl;
   cin  >> userNum;
   
   /* Type your code here */
   cout << "You entered: " << userNum << endl;
   
   squared = userNum * userNum;
   cubed = userNum * userNum * userNum;
   
   cout << userNum << " squared is " << squared << endl;
   cout << "And " << userNum << " cubed is " << cubed << "!!" << endl;
   cout << "Enter another integer:" << endl;
   cin >> userNum2;
   cout << userNum << " + " << userNum2 << " is " << userNum + userNum2 << endl;
   cout << userNum << " * " << userNum2 << " is " << userNum * userNum2 << endl;

   return 0;
}