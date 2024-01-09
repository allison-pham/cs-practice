// https://learn.zybooks.com/zybook/UCRCS009CMontanoWinter2024/chapter/1/section/18
/*1.18 LAB: Input: Mad Lib
Mad Libs are activities that have a person provide various words, which are then used to complete a short story in unexpected (and hopefully funny) ways.
Complete the program to read the needed values from input, that the existing output statement(s) can use to output a short story.

Ex: If the input is:
  Eric 12 cars Chipotle 
the output is:
  Eric buys 12 different types of cars at Chipotle.*/

#include <iostream>
#include <string>
using namespace std;

int main() {
   string firstName;
   int wholeNumber;
   string pluralNoun;
   string genericLocation;
   
   /* Type your code here. */
   cin >> firstName;
   cin >> wholeNumber;
   cin >> pluralNoun;
   cin >> genericLocation;
   
   cout << firstName << " buys " << wholeNumber << " different types of " << pluralNoun << " at " << genericLocation << "." << endl;

   return 0;
}