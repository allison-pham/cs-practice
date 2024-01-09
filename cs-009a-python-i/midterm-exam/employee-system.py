'''Write a program that continuously asks the user if they want to hire an employee, fire an employee, or quit the program.
a. If the user inputs "hire", prompt them for an employee name, and add it to a list 'employees'
b. If the user inputs "fire", prompt them for an employee name, and remove it from the list 'employees'
c. If the user inputs "quit", end the program.
Every time the program asks if the user wants to hire an employee, fire an employee, or quit the program, it must also
display all the employee names. The output should match the example on the next page.
You do not need to check if the input is valid.

- Current Employees -
None
What would you like to do: fire, hire, or quit?
hire
Type the name of the employee you want to hire:
Westin Montano

- Current Employees -
1. Westin Montano
What would you like to do: fire, hire, or quit?
hire
Type the name of the employee you want to hire:
Harini Venkatesan

- Current Employees -
1. Westin Montano
2. Harini Venkatesan
What would you like to do: fire, hire, or quit?
fire
Type the name of the employee you want to fire:
Westin Montano

- Current Employees -
1. Harini Venkatesan
What would you like to do: fire, hire, or quit?
quit'''

# Correct Answer
def employeeSystem():
    employees = []
    status = ""

    while status.lower() != "quit":
        print("\n- Current Employees -")
        num = 1
        
        if not employees:  # if empty
            print("None")
        else:  # Employees currently in list
            for i in employees:
                print(f"{num}. {i}")
                num += 1

        status = input("What would you like to do: hire, fire, or quit? ")

        if status.lower() == "hire":
            name = input("Type the name of the employee you want to hire: ")
            employees.append(name)
        
        elif status.lower() == "fire":
            name = input("Type the name of the employee you want to fire: ")
            employees.remove(name)
        
        elif status.lower() != "quit":
            print("Invalid input.")

    return employees

# Original Answer
'''def employeeSystem():
    employees = []
    status = ""

    while status.lower() != "quit":
        print("\n- Current Employees -")
        num = 1
        
        if not employees: # if empty
            print("None")

        else: # Employees currently in list
            for i in employees:
                print(f"{num}. {employees[i]}")
                num += 1

        status = input("What would you like to do: fire, hire, or qujit?")

        if status.lower() == "hire":
            name = input("Type the name of the employee you want to hire: ")
            employees.append(name)
        
        elif status.lower() == "fire":
            ask = input("Type the name of the employee you want to fire: ")
            employees.remove(ask)
        
        else:
            print("Invalid input.")
    
    return employees'''