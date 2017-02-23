package race;

import java.util.Arrays;
import java.util.Scanner;

/* FILE:        Race.java                                      
* CREATED:      06/13/2016                                                  
* REVISION:     A                                                         
* AUTHOR:       Jerol D. Boyce
* ORGANIZATION: The University of Phoenix, Online Campus                    
* CONTACT INFO: jokerdelta@email.phoenix.edu                                    
*               208-283-4156

* DESCRIPTION:  The purpose of this program is to demonstrate use of the Singleton design pattern.  The application will allow a user of the program 
* to assign only on runner to each of the 8 lanes of a running track on the field. 
*
* REVISION HISTORY: 
*  - (6/13/16) : Initial Release
*
*/

public class Race { //begin class Race

	public static void main(String[] args){ // begin main method
		
		Singleton newInstance = Singleton.getInstance(); // create new instance of Singleton class
		
		Scanner keyboard = new Scanner (System.in); // Set up Scanner method for user input
		
		int runnerNumber = 1; //set while loop counter to one
		
		while (runnerNumber < 9){ // while-loop to cycle 8 times
			
		System.out.println(); // print blank line
		System.out.println("What racing lane do you want to assign runner # " + runnerNumber); // prompt user to input runner lane assignment
		String numLane = keyboard.nextLine(); // read user keyboard input into string "numLane"
		
		int convertNumLane = 0; // initialize variable to zero
				
		convertNumLane = Integer.parseInt(numLane); //convert user input from string to integer
		
		System.out.println("Runner # " + runnerNumber +" has been assigned to lane # " + convertNumLane); // display runner lane assignment
		 
		newInstance.addValues(convertNumLane); // call singleton method to add runner lane assignment to HashSet
		
		System.out.print("The racing lanes selected so far are: "); // display list of lanes previously selected
		
		newInstance.getSelectedLanesList(); // call method "getAvailLanesList" to display values in availableLanes HashSet
		
		newInstance.assignLane(convertNumLane);
		
		runnerNumber ++; //increment runnerNumber
		
		}// end of while-loop
		
		keyboard.close(); //close Scanner method to prevent resource leak
		}
	}
	
	
	

/********************************************************************************
REFERENCES:
* Banas, Derek (2012). Singleton Design Pattern Tutorial. Retrieved from https://www.youtube.com/watch?v=NZaXM67fxbs
* Boyarsky, J., & Selikoff, S. (2015).  OCA: Oracle Certified Associate Java SE 8 Programmer 1 . Indianapolis, Indiana: John Wiley & Sons, Inc.
* Sierra, K., & Bates, B. (2015).  OCA/OCP Java SE 7 Programmer I & II Study Guide . Unites States of America: McGraw-Hill Education.
* 
* 
* 
*
*********************************************************************************/