// This class is a template for create a new Storage object.
// A Storage object represents a storage area for the factory.
// There are other classes like Item, Payroll, Employee, Factory for create a factory system with using object-classes.

//Name - Surname: Yasin Alper Bingül
//Number: 170517033

public class Storage {
	//Data fields
	private int capacity;
	private Item[] items;
	
	//New datafields for resize operation
	//(I asked permission for this data field definition.)
	public static int numberOfItems;
	
	//Constructor
	public Storage(int capacity) {
		this.capacity = capacity;
	}
	
	//The method that adds new item
	public void addItem(Item item) {
		//Creating new object
		Item[] newItems;
		//Number of items increased by one in the storage
		numberOfItems++;
		
		//Checking the storage capacity
		if(numberOfItems <= capacity) {
			//If capacity not full, then create new array with new size.
			newItems = new Item[numberOfItems];
			
			//Copy the whole content of previous items object to new created object.
			for(int i=0;i<newItems.length-1;i++) {
				newItems[i] = items[i];
			}
			
			//New invoked item object is assigned to last index of new created object.
			newItems[numberOfItems-1] = item;
			
			//Set the new created and resized object to items data field.
			setItems(newItems);
		}
		
	}
	
	
	//Getter and setter methods.
	public int getCapacity() {
		return capacity;
	}
	
	public Item[] getItems() {
		return items;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public void setItems(Item[] items) {
		this.items = items;
	}
	
	
}
