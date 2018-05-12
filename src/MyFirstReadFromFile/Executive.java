package MyFirstReadFromFile;

/**
 * Date: 6/26/16
 * Class:
 * Author: ATG8
 * Purpose: This is the subclass Salesman which uses superclass Employee.  It
 *          will use firstName, lastName, and monthlySalary from superclass
 *          Employee while adding a variable named currentStockPrice, override
 *          the annualSalary method to calculate new annual salary based on a
 *          $30,000 bonus if currentStockPrice is greater than 50, and override
 *          the toString method to add annualSales.
 */

//Executive subclass
public class Executive extends Employee {
    
    //Set additional instance variables
    int currentStockPrice;
    
    //Executive constructor
    public Executive(String name, int monthlySalary,
            int currentStockPrice){
        
        //Pull info from superclass Employee constructor to set variables
        super(name, monthlySalary);
        this.currentStockPrice = currentStockPrice;
    }
    
    //Override annualSalary method from superclass Employee
    @Override
    public int annualSalary(int annualSalary){

        //Set additional instance variable bonus as $30,000 if currentStockPrice
        //is greater than $50
        int bonus;

        //Set bonus value based on currentStockPrice
        if (currentStockPrice > 50){
            bonus = 30000;
        }
        else{
            bonus = 0;
        }

        //Set Salesman annual salary
        annualSalary = (monthlySalary * 12) + bonus;

        return annualSalary;
    }
    
    //Override toString method from superclass Employee
    @Override
    public String toString(){
        return super.toString() + "\tCurrent stock price is $"
                + currentStockPrice;
    }
}
