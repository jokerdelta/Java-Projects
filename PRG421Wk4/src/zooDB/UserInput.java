
package zooDB;

//import java.util.Scanner; // Used in Scanner method for user input.

//import zooDB.DBType;
//import zooDB.DBUtil;

import zooDB.tables.CharacteristicsManager;
import zooDB.beans.Characteristics;
import zooDB.util.InputHelper;


/* FILE:        UserInput.java                                      
 * CREATED:      06/26/2016                                                  
 * REVISION:     B                                                         
 * AUTHOR:       Jerol D. Boyce
 * ORGANIZATION: The University of Phoenix, Online Campus                    
 * CONTACT INFO: jokerdelta@email.phoenix.edu                                    
 *               208-283-4156

 * DESCRIPTION:  The purpose of this program is to demonstrate the use of the ArrayList to add, edit, and delete different types
 * of animals, as well as display their attributes.
 *
 * REVISION HISTORY: 
 *  A (6/18/16) : Initial Release
 *  B (6/26/16) : changed architecture of program to create ArrayList of "Animals" objects, corrected class "Animals", added
 *  getter and setter methods to "Animals" class, added "Menu" class, added "SaverFile" class, added "ReaderFile" class.
 *  C (7/4/16)  : changed architecture of program to read and write to MySQL database Zoo, Table "characteristics"
 *  D (7/5/16)  : updated class "CharacteristicsManager to include an "update" method to allow user to update row # selected
 */


public class UserInput { // Beginning of controlling class.

	public static void main(String[] args)throws Exception { // beginning of main method, IOEXception added to ensure it is dealt with

		CharacteristicsManager.displayTable(); // call method to display database table

		Characteristics bean = new Characteristics(); // instantiate new Characteristics object

		bean.setAnimalName(InputHelper.getInput("Animal name: ")); // user input, set animalName
		bean.setAnimalColor(InputHelper.getInput("Animal Color: ")); // user input, set animalColor
		bean.setHeight(InputHelper.getIntegerInput("Animal Height: "));// user input, set height
		bean.setWeight(InputHelper.getIntegerInput("Animal Weight: "));// user input, set weight
		bean.setLength(InputHelper.getIntegerInput("Animal Length: "));// user input, set length

		boolean result = CharacteristicsManager.insert(bean);

		if (result) { // if statement to check if insert was successful

			System.out.println("New row with primary key " + bean.getAnimalNumber() + " was inserted!");	

			CharacteristicsManager.displayTable(); // display new database table after new data inserted
			
			int animalNumber = InputHelper.getIntegerInput("Which row would you like to update? ");
			
			Characteristics bean1 = CharacteristicsManager.getRow(animalNumber);
			
			if (bean1 == null) {
				System.err.println("Row not found");
				return;
			}

			String animalName = InputHelper.getInput("Enter a new animal name: ");
			bean.setAnimalName(animalName);
			String animalColor = InputHelper.getInput("Enter a new animal color: ");
			bean.setAnimalColor(animalColor);
			int height = InputHelper.getIntegerInput("Enter a new animal height: ");
			bean.setHeight(height);
			int weight = InputHelper.getIntegerInput("Enter a new animal weight: ");
			bean.setWeight(weight);
			int length = InputHelper.getIntegerInput("Enter a new animal length: ");
			bean.setLength(length);
			
			if(CharacteristicsManager.update(bean)) { // if-else statement to update data and check if successful
				
				System.out.println("The row was successfully updated.");
				
				} else {
					
				System.err.println("There was an error updating the row!");
				
				}
						
		} // end of if-statement
	
	} // end of main method

} // end of controlling class

	
/********************************************************************************
REFERENCES:
*
* Boyarsky, J., & Selikoff, S. (2015).  OCA: Oracle Certified Associate Java SE 8 Programmer 1 . Indianapolis, Indiana: John Wiley & Sons, Inc.
* Lynda. (2016). Java Database Integration with JDBC. Retrieved from http://www.lynda.com/Java-tutorials/Welcome/110284/117294-4.html
* Sierra, K., & Bates, B. (2015).  OCA/OCP Java SE 7 Programmer I & II Study Guide . Unites States of America: McGraw-Hill Education.
* 
* 
* 
*
*********************************************************************************/
