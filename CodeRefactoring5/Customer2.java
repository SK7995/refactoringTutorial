// Replace constructors with factories

public abstract class Customer2 {
	
	private String custRating;
	static final int PREMIER = 2;
	static final int VALUED = 1;
	static final int DEADBEAT = 0;
	
	public String getCustRating(){ return custRating; }
	
	public void setCustRating(String custRating) { this.custRating = custRating; }
	
	public static void main(String[] args){
		
		CustomerFactory customerFactory  = new CustomerFactory();
		
		Customer2 goodCustomer = customerFactory.getCustomer("Premier");
		
		System.out.println("This Customers Rating: " + goodCustomer.getCustRating());
	
		Customer2 badCustomer = customerFactory.getCustomer("Deadbeat");
				
		System.out.println("This Customers Rating: " + badCustomer.getCustRating());
		
	}

}

class Premier extends Customer2{
	
	Premier(){
		
		setCustRating("Premier Customer");
		
	}
	
}

class Deadbeat extends Customer2{
	
	Deadbeat(){
		
		setCustRating("Deadbeat Customer");
		
	}
	
}

class CustomerFactory{
	
  public Customer2 getCustomer(String custName){
		
		try {
			
			// forName returns a class object with the String that is
			// passed to it. newInstance() creates an instance of the class
			
			return (Customer2) Class.forName(custName).newInstance();
			
		}
		
		catch(Exception e){
			
			throw new IllegalArgumentException("Invalid Customer Type");
		
		}
		
	}
	
}
