package zooDB;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	Scanner keyboard = new Scanner (System.in);
	 
	int menuEntry = 0; // initialize menuEntry variable
	
	public int startMenu(){ // beginning of startMenu method
	
		while (menuEntry > -1){ // beginning of wile-loop for menu entry
			
			menuEntry = menu();
			
			if(menuEntry == 0) // if-else statement to confirm menu entry
				continue;
			else
				System.out.println("You Entered :" + menuEntry);
			
			switch(menuEntry){ // beginning of switch-case statement to process menu items
				case 1:
					System.out.println("Input Animals");
					
					break;
					
				case 2:
					System.out.println("Display Zoo Database");
					break;
					
				case 3:
					System.out.println("Exit");
					
			} // end of switch-case statement for menu items
			
		} // end of while-loop for menu entry
		return menuEntry;
		
	}
		
	public int menu(){ // beginning of basic menu structure
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("\t Menu\n");
		sb.append("\t 1) Input Animals\n");
		sb.append("\t 2) Display Zoo Database\n");
		sb.append("\t 3) Exit\n");
		sb.append("Enter in menu item :");
		System.out.println(sb.toString());
	
		int selection = keyboard.nextInt();
		
		if(selection < 1 || selection > 3) // if-statement to check for valid menu number entry
		{
			System.out.println("Error, please input a valid menu number");	
			selection = 0;
			} // end of if-statement
		if(selection == 1) {
			selection = -1;
			
		if (selection == 3) {
			selection = -1;
		}
		} // end of if-statement
		
		return selection;
		
		} // end of menu method
	
		}// end of startMenu method
	

	

