// This class is a template for create a new Factory object.
// A Factory object represents a factory with employees, storage, payrolls.
// There are other classes like Item, Payroll, Employee, Storage for create a factory system with using object-classes.

//Name - Surname: Yasin Alper Bingül
//Number: 170517033

public class Factory {
	//Data fields
	private String name;
	private Employee[] employees;
	private Storage storage;
	private Payroll[] payrolls;
	private double itemPrice;
	
	//New datafields for resize operation
	//(I asked permission for this data field definition.)
	private static int employeeNumber;
	private static int payrollNumber;
	
	//Constructor
	public Factory(String name, int capacity, double itemPrice) {
		this.name = name;
		storage = new Storage(capacity);
		this.itemPrice = itemPrice;	
	}
	
	//The method that getting revenue with using item count and per item price.
	public double getRevenue() {
		return storage.getItems().length*itemPrice;
	}
	
	public double getPaidSalaries() {
		double paidSalaries = 0;
		//Calculate paid salaries with calculateSalary() method of payrolls object.
		for(int i=0; i<payrollNumber;i++) {
			paidSalaries += payrolls[i].calculateSalary();
		}
		
		return paidSalaries;
		
	}
	
	//Add employee
	public void addEmployee(Employee employee) {
		//Employee number increased by one if this method invoked.
		employeeNumber++;
		//Creating new employee object with new size.
		Employee[] newEmployees = new Employee[employeeNumber];
		
		//Copy the whole content of previous employee object to new created object.
		for(int i=0;i<employeeNumber-1;i++) {
			newEmployees[i] = employees[i];
		}
	
		//New invoked employee object is assigned to last index of new created object.
		newEmployees[employeeNumber-1] = employee;
		
		//Set the new created and resized object to employees data field.
		setEmployees(newEmployees);
		
		//Create new items for new invoked employee object with considering employee's work hour and speed.
		Item[] newItems = employee.startShift();
		
		//New created items store in storage of factory.
		for(int i=0;i<newItems.length;i++) {
			storage.addItem(newItems[i]);
		}
		
	}
	
	public Employee removeEmployee(int id) {
		//If there are no employees, it prints an appropriate error message.
		if(employeeNumber == 0) {
			System.out.println("There are no employees!");
			return null;
		}
		else {
			//If the employee with a given id is not found, it prints an appropriate error message.
			if(!existed(id)) {
				System.out.println("Employee does not exist!");
				return null;
			}
			else {
				//If the employee is found, it removes employee from the employees array.
				//Firstly, find the id index in employees object.
				int removedIndex = 0;
				for(int i=0;i<employees.length;i++) {
					if(employees[i].getId() == id) {
						removedIndex = i;
					}
				}
				
				//Create a new object for removed employee
				Employee removedEmp = employees[removedIndex];
				//Employee number decreased by one for resize operation
				employeeNumber--;
				//Create new object which has new size
				Employee[] newEmployees = new Employee[employeeNumber];
				
				boolean sign = false;
				//Assign the previous employee datas to new created  object without id in index of removedIndex.
				for(int i=0;i<employeeNumber;i++) {
					if(i==removedIndex) {
						newEmployees[i] = employees[i+1];
						sign = true;
					}
					else {
						newEmployees[i] =(sign)?employees[i+1]:employees[i];
					}
				}
				

				//Set the new created and resized object to employees data field.
				setEmployees(newEmployees);
				//Add payroll 
				addPayroll(removedEmp.endShift());
			
				return removedEmp;
			}
		}
		
	}
	
	public void addPayroll(Payroll payroll) {
		payrollNumber++;
		//Create new object which has new size
		Payroll[] newPayroll = new Payroll[payrollNumber];
		
		//Copy the content of previous payrolls to new created payrolls object.
		for(int i=0;i<payrollNumber-1;i++) {
			newPayroll[i] = payrolls[i];
		}
		
		//New invoked payroll object is assigned to last index of new created object
		newPayroll[payrollNumber-1] = payroll;
		//Setting
		setPayroll(newPayroll);
		
	}
	
	//The method that finds invoked id in the employee data field.
	public boolean existed(int id) {
		boolean condition = false;
		
		//Linear searching
		for(int i=0;i<employees.length;i++) {
			if(employees[i].getId() == id) {
				//If id is found, then return true
				condition = true;
				break;
			}
			else {
				condition =  false;
			}
		}
		
		return condition;
	}

	
	//Getter and setter Methods
	public String getName() {
		return name;
	}
	
	public Employee[] getEmployees() {
		return employees;
	}
	
	public Storage getStorage() {
		return storage;
	}
	
	public Payroll[] getPayroll() {
		return payrolls;
	}
	
	public double getItemPrice() {
		return itemPrice;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}
	
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	
	public void setPayroll(Payroll[] payrolls) {
		this.payrolls = payrolls;
	}
	
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
}
