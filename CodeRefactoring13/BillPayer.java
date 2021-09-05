import java.util.ArrayList;

public interface BillPayer {
	
	public void calculateBill(double amountDue);

}

interface Command {
	
	public void executeCalculateBill(double amountDue);
	
}

class WomanOver60 implements BillPayer{

	public void calculateBill(double amountDue) {
		
		System.out.println("Bill Amount for Woman Over 60: $" + (amountDue - (amountDue * .10)));
		
	}
	
}

class ManOver60 implements BillPayer{

	public void calculateBill(double amountDue) {
		
		System.out.println("Bill Amount for Man Over 60: $" + (amountDue - (amountDue * .05)));
		
	}
	
}

class ManUnder60 implements BillPayer{

	public void calculateBill(double amountDue) {
		
		System.out.println("Bill Amount for Man Under 60: $" + amountDue);
		
	}
	
}

// Command: Calls the right executeCalculateBill method
// based on the BillPayer type

class Waiter implements Command{
	
	BillPayer thePayer;
	
	Waiter(BillPayer thePayer){
		
		this.thePayer = thePayer;
		
	}

	public void executeCalculateBill(double amountDue) {
		
		thePayer.calculateBill(amountDue);
		
	}

}

class CashRegister{
	
	Command theCommand;
	
	CashRegister(Command newCommand){
		
		theCommand = newCommand;
		
	}
	
	public void returnFinalBill(double amountDue){
		
		theCommand.executeCalculateBill(amountDue);
		
	}
	
}


class CustomerTypePicker{
	
	public static BillPayer getWomanOver60(){
		
		return new WomanOver60();
		
	}
	
	public static BillPayer getManOver60(){
		
		return new ManOver60();
		
	}
	
	public static BillPayer getManUnder60(){
		
		return new ManUnder60();
		
	}
	
}

// Group BillPayers into an ArrayList
// Now you can use these BillPayers as simple commands

class CustomerGroup{

	ArrayList<BillPayer> customers;
	
	CustomerGroup(){
		
		customers = new ArrayList<BillPayer>();
		
	}
	
	public void add(BillPayer newPayer){
		
		customers.add(newPayer);
		
	}
	
	public BillPayer get(int customerIndex){
		
		return customers.get(customerIndex);
		
	}

}

class UseCashRegister{
	
	public static void main(String[] args){
		
		// Get the customer to use for bill calculation
		
		BillPayer sallyMay = CustomerTypePicker.getWomanOver60();
		
		Waiter theWaiter = new Waiter(sallyMay);
		
		CashRegister calculateBill = new CashRegister(theWaiter);
		
		calculateBill.returnFinalBill(12.00);
	
		BillPayer paulThumb = CustomerTypePicker.getManOver60();
		theWaiter = new Waiter(paulThumb);
		calculateBill = new CashRegister(theWaiter);
		calculateBill.returnFinalBill(12.00);
		
		// Call commands from the BillPayer ArrayList
		
		CustomerGroup custGroup = new CustomerGroup();
		custGroup.add(CustomerTypePicker.getWomanOver60());
		custGroup.get(0).calculateBill(12.00);
		
		
	}
	
}

class Customer{
	
	private int age;
	private boolean man;
	private double bill;
	
	public int getAge() { return age;}
	public void setAge(int age) { this.age = age;}
	public boolean isMan() {return man;}
	public void setMan(boolean man) {this.man = man;}
	
	public Customer(int age, boolean man, double bill) {
		this.age = age;
		this.man = man;
		this.bill = bill;
	}
	
	public void returnFinalBill(){
		
		double percentageOff = 0.0;
		
		if(age > 60){ percentageOff += .05; }
		if(!man){ percentageOff += .05; }
		
		System.out.println("Bill Amount: $" + (bill - (bill * percentageOff)));
		
	}
	
	public static void main(String[] args){
		
		Customer billSmith = new Customer(62, true, 12);
		
		billSmith.returnFinalBill();
		
	}
	
}
