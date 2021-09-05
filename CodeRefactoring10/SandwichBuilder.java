abstract class SandwichBuilder {
	
	Sandwich sandwich;
	
	public Sandwich getSandwich(){ return sandwich; }
	
	public void makeSandwich(){ sandwich = new Sandwich(); }
	
	public abstract void buildBread();
	public abstract void buildVegetables();
	public abstract void buildMeat();
	public abstract void buildCheese();
	public abstract void buildCondiments();
	

}

class BLTBuilder extends SandwichBuilder {

	// Methods that make this different from other Sandwich Objects
	
	public void buildBread() {
		
		sandwich.setBread("White Bread");
		
	}

	public void buildVegetables() {
		
		sandwich.setVegetables("Lettuce Tomato");
		
	}

	public void buildMeat() {
		
		sandwich.setMeat("Bacon");
		
	}

	public void buildCheese() {
		
		sandwich.setCheese("White Bread");
		
	}

	public void buildCondiments() {
		
		sandwich.setCondiments("Mayonnaise");
		
	}
	
}

class SandwichArtist {
	
	private SandwichBuilder sandwichBuilder;
	
	public void setSandwichBuilder(SandwichBuilder sandwichBuilder){
		
		this.sandwichBuilder = sandwichBuilder;
		
	}
	
	public Sandwich getSandwich(){ return sandwichBuilder.getSandwich(); }
	
	// Initializes the Sandwich object
	
	public void takeSandwichOrder(){
		
		sandwichBuilder.makeSandwich();
		sandwichBuilder.buildBread();
		sandwichBuilder.buildVegetables();
		sandwichBuilder.buildMeat();
		sandwichBuilder.buildCheese();
		sandwichBuilder.buildCondiments();
		
	}
	
}

class TestBuilder{
	
	public static void main(String[] args){

		
		SandwichArtist paul = new SandwichArtist();
		
		// Designate the specific Sandwich object we want to build
		
		SandwichBuilder bltBuilder = new BLTBuilder();
		
		// Assign the specific Sandwich to build
		
		paul.setSandwichBuilder(bltBuilder);
		
		// Initialize everything in the new object
		
		paul.takeSandwichOrder();
		
		// Provide the specific Sandwich object
		
		Sandwich bltSandwich = paul.getSandwich();
		
		// Print out info on the Sandwich Object
		
		System.out.println(bltSandwich);
		
	}

}
