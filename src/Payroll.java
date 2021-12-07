// This class is a template for create a new Payroll object.
// A Payroll object represents the payroll of the employees working for the factory.
// There are other classes like Item, Storage, Employee, Factory for create a factory system with using object-classes.

//Name - Surname: Yasin Alper Bingül
//Number: 170517033

public class Payroll {
	//Data fields
	private int workHour;
	private int itemCount;
	
	//Constructor
	public Payroll(int workHour, int itemCount) {
		this.workHour = workHour;
		this.itemCount = itemCount;
	}
	
	
	//Method: Calculating salary for each employee
	public int calculateSalary() {
		//Each work hour: 3 Liras, Each produced item: 2 Liras.
		return (workHour*3 + itemCount*2);
	}
	
	//Method: Returns a String message that includes informations about
	//        work hours, speed, produced item count of each employee.
	public String toString() {
		String message = "The work hour is " + workHour + " and the produced item count is " + itemCount + ".";
		return message;
	}
	
	
	
	//Getter and setter methods for private data fields
	public int getWorkHour() {
		return workHour;
	}
	
	public int getItemCount() {
		return itemCount;
	}
	
	public void setWorkHour(int workHour) {
		this.workHour = workHour;
	}
	
	public void setItemCounts(int itemCount) {
		this.itemCount = itemCount;
	}
	
}
