
/* FILE:        SalesCalculator3.java                                      
* CREATED:      06/4/2016                                                  
* REVISION:     A                                                       
* AUTHOR:       J. Jackson and Jerry Boyce
* ORGANIZATION: The University of Phoenix, Online Campus                    
* CONTACT INFO: 520-686-1161, 208-283-4156                                   
*              
*
* DESCRIPTION:  The purpose of this program is to calculate the total
* annual compensation for a salesperson based on the current commission rate and 
* compare annual sales among salespeople to determine the highest annual sales 
* among a group of salespeople. The program will prompt the user to enter the 
* salesperson's first name, last name, annual sales, and calculate the total annual
* compensation. It will do this by multiplying the annual sales by the commission 
* rate and adding the two together. It will then display a table of names, annual 
* sales, and total compensation for all salespeople entered by the user.
*
* REVISION HISTORY: 
*  A (6/4/16) : Initial Release
*  B (6/4/16) : Added Try-Catch Block to throw NumberFormatException if anything 
* other than positive number is entered for annual sales
*  C (6/5/16) : Added another catch to the Try-Catch block so that the script in
* in the Formula class would run. Adjusted the locationof the try statement to 
* include the question requesting the amount of poeple to be added to the ArrayList.
*/

package salescalculator3;

import java.text.NumberFormat; //Used to convert string values to currency
import java.util.Scanner; // Used in Scanner method for user input

public class SalesCalculator3 { // Beginning of Controlling Class

    public static double convertSales;

    public static void main(String[] args) {

        /* Instantiating new object "myFormula" from Formula class 
        *** Formula class combined from J. Jackson's application ***
        */
        Formula myFormula = new Formula(); 
		
        // Setting up Scanner method for user input
        Scanner keyboard = new Scanner (System.in); 
			
	System.out.println("This application will compare the total annual "
                + "compensation of salespeople.");
			
        // **This try-catch block was combined from J. Jackson's Application **
        try { 

            System.out.print(
                "How many salespeople would you like to calculate and compare? ");

            // user input string for # of salespeople
            String numSalesPerson = keyboard.nextLine(); 
            // initialize variable convertNumPerson
            int convertNumPerson = 0; 
            // convert string numSalesPerson to integer
            convertNumPerson = Integer.parseInt(numSalesPerson); 	

            //declare 2D string array and set to two elements for firstName & lastName
            String [][] names = new String[2][convertNumPerson]; 
            // declare 2D int array and set to two elements for annualSales & totalCompensation
            double [][] rectangle = new double [2][convertNumPerson]; 

            int count = 0; // set while loop counter to zero
			
            //While-loop to cycle # of times based on user input
            while(count < convertNumPerson ){ 
                //add 1 to counter to prevent display of "salesperson # 0"
                int personNumber = (count + 1);
                //prompt user to enter salesperson's first name
                System.out.print("Please enter the first name of salesperson #" 
                        + personNumber +" :"); 
                // read keyboard input into string "firstName"
                String firstName = keyboard.nextLine(); 

                // prompt user to enter salesperson's last name
                System.out.print("Please enter the last name of salesperson #" 
                        + personNumber +" :" ); 
                // read keyboard input into string "lastname"
                String lastName = keyboard.nextLine(); 

                // prompt for user to enter annual sales of salesperson
                System.out.print("What are the annual sales for ");
                System.out.print(firstName + " " + lastName +"?"); 

                // read keyboard input into string annualSales 
                String annualSales = keyboard.nextLine(); 

                convertSales = 0.0; //initialize converSales variable

                //convert string annualSales to double
                convertSales = Double.parseDouble(annualSales); 

                /* set variable currency to currency format
                ** NumberFormat code combined from J. Jackson's application **
                */
                NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(); 
				
                //set variable currency1 to currency format
                System.out.println("You entered :  "
                        + moneyFormatter.format(convertSales)); 

                /*// calls calcAnnualSales method in Computation class and passes 
                *converted user input into it 
                ** This was changed to point to J. Jackson's class "Formula" **
                */
                double anSales = myFormula.earnings(convertSales); 

                //set array "names" location for firstName
                names[0][count] = firstName; 
                //set array "names" location for lastName
                names[1][count] = lastName; 
                // set array "rectangle" location for annual sales
                rectangle[0][count] = convertSales; 
                // set array "rectangle" location for total annual compensation
                rectangle[1][count] = anSales; 

                count ++ ;//increment variable "count" for while loop

            } // end of while-loop
			
            keyboard.close();// Close Scanner method to prevent resource leak
			
            /*Determine the highest annual sales from the array "rectangle" 
            *elements, assuming that the first element is the maximum
            */
            double max = rectangle[0][0];

            // declare for loop
            for (int count2 = 0; count2 < convertNumPerson; count2 ++) { 
                if (rectangle[0][count2] > max) {
                    max = rectangle[0][count2];
                }
            }

            /* declare variable for while-loop to display table of names, 
            annual sales, and total compensation. */
            int count3 = 0; 
            System.out.println("Name\t\t"+"Annual Sales\t"+"Total Compensation"+
                    "\tAdditional Sales Amount Needed to Reach Highest Sales");
            while (count3 < convertNumPerson) { // begin while loop

                //** NumberFormat code combined from J. Jackson's Application **
                NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
                
                //display array values for firsName  
                System.out.print(names[0][count3] + " "); 
                //display array values for lastName
                System.out.print(names[1][count3]+ "\t"); 
				
                // display array values for annualSales
                double annualSales2 = rectangle[0][count3]; 
                //** NumberFormat code combined from J. Jackson's application **
                System.out.print(moneyFormatter.format(annualSales2)+"\t");
                
                // display array values for totalCompensation
                double totalCompensation2 = rectangle[1][count3]; 
                System.out.print(moneyFormatter.format(totalCompensation2)+"\t\t");
               
                // display sales amount needed to reach highest sales
                double nextSales = (max - rectangle[0][count3]); 
                System.out.print(moneyFormatter.format(nextSales));

                System.out.print("\n"); //insert carriage return

                count3++; //increment counter

            } //end of while loop
			
            NumberFormat currency1 = NumberFormat.getCurrencyInstance();
            // print blank line before printing highest annual sales
            System.out.println(""); 
            System.out.println("The highest annual sales is: " + (currency1.format(max)));
        } // end of try statement 

        // *** Try-catch block combined from J. Jackson's Application ***
        catch (NumberFormatException booBoo)  {
            System.out.println("Please enter a positive number only.");
            
        } // end of catch statement

        //This catch statement obtained from Sonmez, J. (2011).
        catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        } //end of catch statement

    } // end of main method

} // end of controlling class SalesCalculator3

/********************************************************************************
REFERENCES:
* Burd, B. (2014).  Beginning Programming with Java for Dummies (4th ed.). 
*   Hoboken, New Jersey: John Wiley & Sons, Inc.
* Boyarsky, J., & Selikoff, S. (2015).  OCA: Oracle Certified Associate Java SE 8 
*   Programmer 1 . Indianapolis, Indiana: John Wiley & Sons, Inc.
* Purcell, J.(2015). Java and C++ Programming Tutorials. Retrieved from 
*   https://www.caveofprogramming.com/java.java-string-working-with-strings-in-java.html
* Singhal, N.(2012). Just another JAVA Blog. Retrieved from 
*   https://javaila.wordpress.com/category/java/java-object-oriented/
* Wulf, Tom (2014). Java Array Algorithms: sum, average, min, and max. Retrieved 
*   from https://www.youtube.com/watch?v=TJKsVaiccNM
*
*********************************************************************************/


