package zooDB.beans; // javabeans class

public class Characteristics {
	
	private int animalNumber; // all private variables named after columns in "characteristics" database table
	private String animalName;
	private String animalColor;
	private int height;
	private int weight;
	private int length;
	
	
	public int getAnimalNumber() { // "getters and setters"
		return animalNumber;
	}
	public void setAnimalNumber(int animalNumber) {
		this.animalNumber = animalNumber;
	}

	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public String getAnimalColor() {
		return animalColor;
	}
	public void setAnimalColor(String animalColor) {
		this.animalColor = animalColor;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}

}
