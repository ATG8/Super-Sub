package MyFirstReadFromFile;

/**
 * Date: 6/26/16
 * Class: CMIS 242 7380
 * Author: ATG8
 * Purpose: This is the superclass Employee.
 */

//Employee superclass
public class Employee {
    
    //Declare superclass variables
    private String name; //employee name
    int monthlySalary; //employee Monthly Salary
    
        //Contructor for Employee class
        public Employee(String name, int monthlySalary){
            this.name = name;
            this.monthlySalary = monthlySalary;
        }
        
        //Method to calculate annual salary as monthly salary times 12 months
        //in a year.
        public int annualSalary(int annualSalary){
            annualSalary = monthlySalary * 12;
            return annualSalary;
        }
        
        //Method to create string of "firstName lastName earns $monthlySalary
        //per month."
        public String toString(){
            return name + " earns $" + monthlySalary
                    + " per month.";
        }
}
