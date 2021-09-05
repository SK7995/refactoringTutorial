public class CalculateSalary {
	
	public static void main(String[] args){
		
		// This seems to work as long as there are no changes
		// I could make subclasses to eliminate the need for the boolean
		
		Employees salesman = new Employees(15000.00, true);
		
		System.out.println(salesman.getSalary());
		
		Employees secretary = new Employees(20000.00, false);
		
		System.out.println(secretary.getSalary());
		
		// What happens if I need to change the bonus amount?
		// What happens if we want to create a new pay structure?
		
	}

}

class Employees{
	
	private boolean bonus = false;
	private double salary = 0.0;
	
	// If the bonus amount changes I have to add a new field
	// and a new constructor and change getSalary
	
	private double bonusAmount = .15;
	
	public Employees(double salary, boolean bonus, double bonusAmount) {
		super();
		this.salary = salary;
		this.bonus = bonus;
		this.bonusAmount = bonusAmount;
	}
	
	public Employees(double salary, boolean bonus) {
		super();
		this.salary = salary;
		this.bonus = bonus;
	}

	public Employees() {}

	public double getSalary() {
		
		if(bonus){
			
			// CHANGED return salary + (salary*.15);
			
			return salary + (salary*bonusAmount);
			
		}
		
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
