package MyFirstReadFromFile;

/**
 * Date: 6/26/16
 * Class: CMIS 242 7380
 * Author: ATG8
 * Purpose: This is the main method that will test the super (Employee) and
 * subclasses (Salesman, Executive).
 */

import java.io.*;
import java.util.*;

public class MyFirstReadFromFile {
        
    //Main
    public static void main(String[] args) throws IOException {
        
        //Find and set file from argument
        File file = new File("employeeinformation.txt");
        
        //Create two separate arrays for years 2014 & 2015
        List<String[]> list2014 = new ArrayList<>();
        List<String[]> list2015 = new ArrayList<>();
        
        // try reading file
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = br.readLine()) != null){
                if(line.startsWith("2014")){
                    list2014.add(line.split(" "));
                }else if(line.startsWith("2015")){
                    list2015.add(line.split(" "));
                } // end if lines start with
            } //end while lines can be read
        }catch(IOException exception){
            System.err.println("Exception: " + exception.getMessage());
            exception.printStackTrace();
        } //end catch errors
        
        String[][] array2014 = list2014.toArray(new String[][] {});
        int totalSal14 = 0; //total annual salaries for 2014
        int totalSal15 = 0; //total annual salaries for 2015
        int count14 = 0; //count of 2014 employee objects
        int count15 = 0; //count of 2015 employee objects
        
        //print heading for 2014
        System.out.println("For the year 2014:");
        System.out.println("Type\t\tName and monthly salary\t\t\tAdditions\t\t\tAnnualSalary");
        
        //cycle through array2014 and print results
        for (int i = 0; i < array2014.length; i++){
            String type = array2014[i][1]; //create string for emp/sales/exec type
            String name = array2014[i][2]; //create string of name
            int monthlySalary = Integer.parseInt(array2014[i][3]); //monthly salary
        
            if(type.equalsIgnoreCase("Employee")){
                Employee emp = new Employee(name, monthlySalary);
                totalSal14 += emp.annualSalary(monthlySalary);
                count14++;
                System.out.println("Employee\t" + emp.toString() +
                        "\t\t\t\t\tAnnual Salary: $" + emp.annualSalary(monthlySalary));
            }else if(type.equalsIgnoreCase("Salesman")){
                int annualSales = Integer.parseInt(array2014[i][4]);
                Salesman sales = new Salesman(name, monthlySalary, annualSales);
                totalSal14 += sales.annualSalary(annualSales);
                count14++;
                System.out.println("Salesman\t" + sales.toString() +
                        "\tAnnual Salary: $" + sales.annualSalary(annualSales));
            }else if(type.equalsIgnoreCase("Executive")){
                int currentStockPrice = Integer.parseInt(array2014[i][4]);
                Executive exec = new Executive(name, monthlySalary, currentStockPrice);
                totalSal14 += exec.annualSalary(currentStockPrice);
                count14++;
                System.out.println("Executive\t" + exec.toString() + 
                        "\tAnnual Salary: $" + exec.annualSalary(currentStockPrice));
            }else{
                System.out.println("Employee type cannot be found for array2014["
                        + i + "]");
            }
        }
        
        System.out.println("\nAverage salaries for 2014: $" + totalSal14/count14);
        
        String[][] array2015 = list2015.toArray(new String[][] {});
        
        //print heading for 2015
        System.out.println("\n\nFor the year 2015:");
        System.out.println("Type\t\tName and monthly salary\t\t\tAdditions\t\t\tAnnualSalary");
        
        //cycle through array2015 and print results
        for (int i = 0; i < array2015.length; i++){
            String type = array2015[i][1]; //create string for emp/sales/exec type
            String name = array2015[i][2]; //create string of name
            int monthlySalary = Integer.parseInt(array2015[i][3]); //monthly salary
        
            if(type.equalsIgnoreCase("Employee")){
                Employee emp = new Employee(name, monthlySalary);
                totalSal15 += emp.annualSalary(monthlySalary);
                count15++;
                System.out.println("Employee\t" + emp.toString() +
                        "\t\t\t\t\tAnnual Salary: $" + emp.annualSalary(monthlySalary));
            }else if(type.equalsIgnoreCase("Salesman")){
                int annualSales = Integer.parseInt(array2015[i][4]);
                Salesman sales = new Salesman(name, monthlySalary, annualSales);
                totalSal15 += sales.annualSalary(annualSales);
                count15++;
                System.out.println("Salesman\t" + sales.toString() +
                        "\tAnnual Salary: $" + sales.annualSalary(annualSales));
            }else if(type.equalsIgnoreCase("Executive")){
                int currentStockPrice = Integer.parseInt(array2015[i][4]);
                Executive exec = new Executive(name, monthlySalary, currentStockPrice);
                totalSal15 += exec.annualSalary(currentStockPrice);
                count15++;
                System.out.println("Executive\t" + exec.toString() + 
                        "\tAnnual Salary: $" + exec.annualSalary(currentStockPrice));
            }else{
                System.out.println("Employee type cannot be found for array2015["
                        + i + "]");
            }
        }
        System.out.println("\nAverage salaries for 2015: $" + totalSal15/count15);
    } //end main
} //end program
