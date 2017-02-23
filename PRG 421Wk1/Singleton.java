
package race;

import java.util.HashSet;




public class Singleton {

	private static Singleton onlyInstance = null; // access point for any object in class
	
	HashSet<Integer> selectedLanes = new HashSet<Integer>();
	
	public void addValues (int convertNumLane){ // method to add lane #'s 1-8 to HashSet selectedLanes
	selectedLanes.add(convertNumLane); 
	
	if (selectedLanes.add(convertNumLane)== true){
		
		System.out.println ("That lane has already been assigned, please input another number");
	}
	else {
		
		System.out.println("Lane # "+ convertNumLane +" has been successfully assigned to the runner.");
		
	}
	
	} // end of "addValues" method
	
	
	//constructor set to private to prevent other instances of class from being created later
	private Singleton (){} 
	
	/* method to check whether onlyInstance is already created. If onlyInstance isn't already created,
	*getInstance creates a new instance of Singleton. This is known as "lazy instantiation" because an
	*instance isn't created until it is needed. */
	
		public static Singleton getInstance(){ 
			
		if(onlyInstance == null) { // check to see if Singleton already exists.
			
			onlyInstance = new Singleton(); // generates new Singleton if one doesn't already exist.
			
		}
		return onlyInstance; // ensures Singleton is returned if an instance already exists.
	
	}
	
	public void getSelectedLanesList(){
		
		for (Integer anInt : onlyInstance.selectedLanes){ // For-Each loop to iterate though HashSet
			System.out.print ((anInt)+ ",");
		} // end of for-each loop	
	}// end of getAvalLanesList method

		
	public boolean assignLane (int convertNumLane){
	return selectedLanes.add(convertNumLane);	
	
	}

	}
	
	
	
	