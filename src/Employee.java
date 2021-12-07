// This class is a template for create a new Employee object.
// An Employee object represents an employee working for the factory.
// There are other classes like Item, Payroll, Storage, Factory for create a factory system with using object-classes.

//Name - Surname: Yasin Alper Bingül
//Number: 170517033

public class Employee {
	//Data fields
	private int id;
	private String name;
	private String surname;
	private int workHour;
	private int speed;
	private Item[] items;
	private Payroll payroll;
	
	//Constructor
	public Employee(int id, String name, String surname, int workHour, int speed) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.workHour = workHour;
		this.speed = speed;
	}
	
	
	//Method: 
	public Item[] startShift() {
		//Finds how many items this employee should produce according to speed and workHour values.
		int itemNumber = workHour*speed;
		items = new Item[itemNumber];
		
		//Creates items with randomly generated ids between 1-100 and put them into items array.
		for(int i=0; i<itemNumber;i++) {
			items[i] = new Item((int)Math.random() * 100);
		}
		
		return items;	
	}
	
	//Create a new payroll which work hour and item count of constructed Employee.
	public Payroll endShift() {
		Payroll payroll = new Payroll(workHour,workHour*speed);
		return payroll;
	}
	
	//Method: Returns a String message that includes informations about
	//        id, speed, work hour and produced item count of each employee.
	public String toString() {
		String message = "This is the employee with id " + id + " speed " + speed + ". The work hour is " + workHour + " and the produced item count is " + workHour*speed +".";
		return message;
	}
	
	

	//Getter and setter methods
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public int getWorkHour() {
		return workHour;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public Item[] getItems() {
		return items;
	}
	
	public Payroll getPayroll() {
		return payroll;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setWorkHours(int workHour) {
		this.workHour = workHour;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void SetItems(Item[] items) {
		this.items = items;
	}
	
	public void setPayroll(Payroll payroll) {
		this.payroll = payroll;
	}
}
