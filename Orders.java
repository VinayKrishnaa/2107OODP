
public class Orders {
	//instance variables
	private double amount;
	private Time time; //need to find out the exact Time object name
	
	//constructor
	public Orders(double amount, Time time) {
		this.amount = amount;
		this.time = time;
	}
	
	//methods
	public double getAmount() {
		return amount;
	}
	
	public Time getTime() {
		return time;
	}
}
