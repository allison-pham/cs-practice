#include <iostream>
#include <string>
using namespace std;


int main()
{
    string userName;
    string password;
    
    cout << "Username: ";
    cin >> userName;

    cout << "Password: ";
    cin >> password;

    if(userName == "TeemoMain" && password == "Scouts_Code")
    {
        cout << "Login successful!" << endl;
    }
    else
    {
        cout << "Incorrect username/password" << endl;
    }

    return 0;
}