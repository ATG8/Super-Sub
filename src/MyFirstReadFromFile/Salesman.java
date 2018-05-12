package MyFirstReadFromFile;

/**
 * Date: 6/26/16
 * Class:
 * Author: ATG8
 * Purpose: This is the subclass Salesman which uses superclass Employee.
 *          It will use firstName, lastName, and monthlySalary from superclass
 *          Employee while adding a variable named annualSales, override the
 *          annualSalary method to calculate new annual salary based on 2%
 *          commission with a max of $20,000, and override the toString method
 *          to add annualSales.
 */

//Salesman subclass
public class Salesman extends Employee {
    
    //Set additional instance variables
    private int annualSales;
    
    //Salesman constructor
    public Salesman(String name, int monthlySalary, int annualSales){
        
        //Pull info from superclass Employee constructor to set variables
        super(name, monthlySalary);
        this.annualSales = annualSales;
    }
        
    //Override annualSalary method from superclass Employee
    @Override
    public int annualSalary(int annualSalary){

        //Set additional instance variable commission as 2% annual sales
        int commission = (int)Math.round(annualSales * 0.02);
        int actualCommission;

        //Error check max commission and set actual
        if (commission > 20000){
            actualCommission = 20000;
        }
        else{
            actualCommission = commission;
        }

        //Set Salesman annual salary
        annualSalary = (monthlySalary * 12) + actualCommission;

        return annualSalary;
    }
    
    //Override toString method from superclass Employee
    @Override
    public String toString(){
        return super.toString() + "\tAnnual sales totaled $" + annualSales;
    }
}
