import java.time.*;

public class PaymentController {
	//instance varaibles
	private Bill[] pastBills; //for this array, prolly need to make it large because it will grow with time. then can continuously compare numofPastBills with the fixed size array and if is going to be full alr then can use the array's .copyOf() method to shift all data to a bigger array
	private int numOfPastBills;
	private Bill[] currentBills; //for currentBills, array size can be fixed and exact since we have fixed number of rooms
	private int numOfCurrentBills; //actly is this needed? cant remember why i put this
	private ReservationController reservationController; //to get checkin checkout dates when i input roomid into the 2 methods (for bill calculation)
	private RoomController roomController; //to get weekend and weekday rates when I input roomid into the 2 methods (for bill calculation)
	
	
	//constructor
	public PaymentController(ReservationController rescon, RoomController roomcon) {//NOT COMPLETE
		int i;
		//need to get the actual controller objects that the rest of the program uses and not create a new object
		//initializing the other controllers into payment controller:
		reservationController = rescon;
		roomController = roomcon;
		
		//initializing num of cur and past bills to be 0 since this paymentcontroller will only be constructed once at the beginning of a hotel without any past bills
		numOfPastBills = 0;
		numOfCurrentBills = 0;
		
		//initializing the size of the Bill arrays
		pastBills = new Bill[200]; //just initializing the pastBills array to be 200 entries big for example purpose
		currentBills = new Bill[48]; //for 48 rooms
				
		//for the 48 rooms, create the bills for each room here and initialize the ROOMID
		for(i=0; i<16; i++) {
			currentBills[i] = new Bill();
			currentBills[i].setRoomID(i+100);
		}
		for(i=0; i<14; i++) {
			currentBills[i] = new Bill
		}
	}
	
	//methods
	public void setStayDuration(int roomid) {//NOT COMPLETE this function called when checking out, before printing bill
		//figure out how to get num of weekends and weekdays from check in and check out date
		//get checkin and checkout dates from reservation controller?? right now dont have those methods there..
		int i;
		Date checkIn; //confirm is Date the object rodmond's function is returning?
		Date checkOut; //same thing as above
		int numOfWeekdays;
		int numOfWeekends;
		
		//get the the check in and out dates from our res controller
		checkIn = reservationController.getCheckIn(roomid);
		checkOut = reservationController.getCheckOut(roomid);
		
		//getting num of weekdays and weekends from the checkin and out dates
		use the stack overflow funtion here to get the num of weekend and weekdays and store them in numOfWeekdays and numOfWeekends
		
		for(i=0; i<numOfCurrentBills; i++) {//for all this searching functions, can just change numOfCurrentBills to the fixed number of rooms we have in the hotel.. then search through all of them for the roomid we want
			if(roomid == currentBills[i].getRoomID()) {
				currentBills[i].setNumOfWeekdays(numOfWeekdays);
				currentBills[i].setNumOfWeekends(numOfWeekends);
				return;
			}
		}
		System.out.println("Please enter a valid Room ID!");
	}
	
	public void setTaxRate(int roomid, double tax) {
		int i;
		for(i=0; i<numOfCurrentBills; i++) { //may need to change the way we search. if roomid to bill is 1-to-1, then just check that that bill is an active bill
			if(roomid == currentBills[i].getRoomID()) {
				currentBills[i].setTax(tax);
				return;
			}
		}
		System.out.println("Please enter a valid Room ID!");
	}
	
	public void addOrder(int roomid, Orders order) {
		int i;
		for(i=0; i<numOfCurrentBills; i++) {
			if(roomid == currentBills[i].getRoomID()) {
				currentBills[i].addOrder(order);
				return;
			}
		}
		System.out.println("Please enter a valid Room ID!");
	}
	
	public void setDiscount(int roomid, double discount) {
		int i;
		for(i=0; i<numOfCurrentBills; i++) {
			if(roomid == currentBills[i].getRoomID()) {
				currentBills[i].setDiscount(discount);
				return;
			}
		}
		System.out.println("Please enter a valid Room ID!");
	}
	
	public void setPaymentType(int roomid, boolean type) {
		int i;
		for(i=0; i<numOfCurrentBills; i++) {
			if(roomid == currentBills[i].getRoomID()) {
				currentBills[i].setPaymentType(type);
				return;
			}
		}
		System.out.println("Please enter a valid Room ID!");
	}
	
	public void printBill(int roomid) {//NOT COMPLETE. need access to room weekday and weekend rates from ROOM class??
		//get weekday and weekend rates from room class
		int i;
		int j;
		int numOfOrders;
		Orders[] roomServices;
		double totalWeekday = currentBills[i].getNumOfWeekdays() * roomController.getWeekdayRate(roomid);
		double totalWeekend = currentBills[i].getNumOfWeekends() * roomController.getWeekendRate(roomid);
		double totalRoomService = 0;
		double discount;
		double tax;
		double totalAmount;
		
		for(i=0; i<numOfCurrentBills; i++) {
			if(roomid == currentBills[i].getRoomID()) {
				numOfOrders = currentBills[i].getNumOfOrders();
				roomServices = currentBills[i].getOrders();
				System.out.println("Hotel XXX");
				System.out.println("---------");
				System.out.println();
				System.out.println("Guest Name: " + currentBills[i].getGuestName());
				System.out.println();
				System.out.println("Room Charges:");
				System.out.println("	Weekdays: ");
				System.out.println("		Quantity: " + currentBills[i].getNumOfWeekdays());
				System.out.println("		Amount: " + totalWeekday);
				System.out.println("	Weekends: ");
				System.out.println("		Quantity: " + currentBills[i].getNumOfWeekends());
				System.out.println("		Amount: " + totalWeekend);
				System.out.println();
				System.out.println("Room Services:");
				for(j=0; j<numOfOrders; j++) {
					System.out.println("	Timestamp: " + roomServices[j].getTime());
					System.out.println("	Amount: " + roomServices[j].getAmount());
					totalRoomService += roomServices[j].getAmount();
				}
				System.out.println("Total Room Service Amount: " + totalRoomService);
				System.out.println();
				totalAmount = totalRoomService + totalWeekday + totalWeekend;
				discount = currentBills[i].getDiscount();
				System.out.println("Discount: "+ discount + "%");
				totalAmount = totalAmount * (100 - discount); //applying discount on total amount
				System.out.println("Total Amount (after discount): " + totalAmount);
				System.out.println();
				tax = currentBills[i].getTax();
				System.out.println("Tax: " + tax + "%");
				totalAmount = totalAmount * tax + totalAmount; //applying tax on total amount after discount
				System.out.println("Total Amount (after tax): " + totalAmount);
				System.out.println();
				System.out.println("Total Billable Amount: " + totalAmount);
				return;
			}
		}
		System.out.println("Please enter a valid Room ID!");
	}
	
	public void pay(int roomid) {//NOT COMPLETE
		int i;
		for(i=0; i<numOfCurrentBills; i++) {
			if(roomid == currentBills[i].getRoomID()) {
				//need to store bill into pastbills (increment counter), free up the bill that is tied to a room using some status and also free up the room itself
				
				return;
			}
		}
		System.out.println("Please enter a valid Room ID!");
	}
}
