// Base class - The "Parent"
class Employee {
    double salary;

    // Method to show the salary
    void displaySalary() {
        System.out.println("Salary: " + salary);
    }
}

// Derived class for Full Time
class FullTimeEmployee extends Employee {
    
    void calculateSalary() {
        System.out.println("--- Full Time Employee ---");
        System.out.print("Before hike: ");
        displaySalary(); 
        
        // 50% hike calculation
        salary = salary + (salary * 0.50);
        
        System.out.print("After 50% hike: ");
        displaySalary();
        System.out.println();
    }
}

// Derived class for Interns
class InternEmployee extends Employee {
    
    void calculateSalary() {
        System.out.println("--- Intern Employee ---");
        System.out.print("Before hike: ");
        displaySalary();
        
        // 25% hike calculation
        salary = salary + (salary * 0.25);
        
        System.out.print("After 25% hike: ");
        displaySalary();
        System.out.println();
    }
}

// The main class name has been changed here
public class EmployeeType {
    public static void main(String[] args) {
        
        // Testing Full Time Employee
        FullTimeEmployee ft = new FullTimeEmployee();
        ft.salary = 5000; 
        ft.calculateSalary();

        // Testing Intern Employee
        InternEmployee it = new InternEmployee();
        it.salary = 2000; 
        it.calculateSalary();
    }
}