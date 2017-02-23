package salescalculator3;

public class Formula {

/*Begin formula to calculate a salesperson's earnings for the year.
The constants for the salesperson's salary and commission percent are given 
variables so that, later in time, if something needs to be changed, only the
constants in the variables need to be changed. The programmer will not need
to comb through the entire code to change the salary or the commission rate.    
*/
    double earnings( double annualSales) {
        double fixedSalary = 30_000.00;
        double percentAnnualSales = 0.0;
        
        /*Begin if else statements to calculate graded percentage.
        Info retrieved from http://www.homeandlearn.co.uk/java/java.html.
        */
        if (annualSales < 0) { //This Exception obtained from Sonmez, J. (2011).
            throw new IllegalArgumentException("Please enter a positive number"
                    + " as it is not possible to sell a negative amount.");
            }
        else if (annualSales < 320_000.0) {
            percentAnnualSales = 0.0;
        }
        else if (annualSales >= 320_000.0 && annualSales < 400_000.0) {
            percentAnnualSales = 0.08;
        }
        else {
            percentAnnualSales = 0.1;
        } //End if else statements.
        
        double commission = (annualSales * percentAnnualSales);
        double annualCompensation = (fixedSalary + commission); 
        return annualCompensation; 

    } //end earnings method

} //end class Formula
