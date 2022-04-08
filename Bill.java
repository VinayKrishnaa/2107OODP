
public class Bill {
	//instance variables
	private int roomID;
	private String guestName;
	private int numOfWeekdays;
	private int numOfWeekends;
	private double tax;
	private int numOfOrders;
	private Orders[] roomServices;
	private double discount;
	private boolean paymentType;
	
	//constructor
	public Bill() {
		//fill this up later. actly i think dont need initialize anything first.. will initialize in paymenctrl
		//i think just need to initialize the space for the array.. to simplify program just going to initialize a large array like 100 orders
		roomServices = new Orders[100];
		numOfOrders = 0;
	}
	
	//methods
	public void setRoomID(int roomid) {
		roomID = roomid;
	}
	
	public int getRoomID() {
		return roomID;
	}
	
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	
	public String getGuestName() {
		return guestName;
	}
	
	public void setNumOfWeekdays(int num) {
		numOfWeekdays = num;
	}
	
	public int getNumOfWeekdays() {
		return numOfWeekdays;
	}
	
	public void setNumOfWeekends(int num) {
		numOfWeekends = num;
	}
	
	public int getNumOfWeekends() {
		return numOfWeekends;
	}
	
	public void setTax(double tax) {
		this.tax = tax;
	}
	
	public double getTax() {
		return tax;
	}
	
	public void setNumOfOrders(int num) {
		numOfOrders = num;
	}
	
	public int getNumOfOrders() {
		return numOfOrders;
	}
	
	public void addOrder(Orders order) {
		roomServices[numOfOrders] = order;
		numOfOrders++;
	}
	
	public Orders[] getOrders(){
		return roomServices;
	}
	
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public void setPaymentType(boolean type) {
		paymentType = type;
	}
	
	public boolean getPaymentType() {
		return paymentType;
	}
}
