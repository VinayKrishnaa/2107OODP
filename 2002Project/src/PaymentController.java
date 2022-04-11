import java.time.*;
import java.util.*;
 
public class PaymentController {
	//instance variables
	private Bill[] pastBills; //for this array, prolly need to make it large because it will grow with time. then can continuously compare numofPastBills with the fixed size array and if is going to be full alr then can use the array's .copyOf() method to shift all data to a bigger array
	private int numOfPastBills;
	private Bill[] currentBills; //for currentBills, array size can be fixed and exact since we have fixed number of rooms
	private int numOfCurrentBills; //actly is this needed? cant remember why i put this
	
	//constructor
	public PaymentController() {
		int i;
		
		//initializing num of cur and past bills to be 0 since this paymentcontroller will only be constructed once at the beginning of a hotel without any past bills
		numOfPastBills = 0;
		numOfCurrentBills = 0;
		
		//initializing the size of the Bill arrays
		pastBills = new Bill[200]; //just initializing the pastBills array to be 200 entries big for example purpose
		currentBills = new Bill[48]; //for 48 rooms
				
		//for the 48 rooms, create the bills for each room here and initialize the ROOMID
		for(i=0; i<48; i++) {
			if(i<= 15) { //0-15
				currentBills[i] = new Bill();
				currentBills[i].setRoomID(i+100); //roomid from 100 - 115
			}
			else if (i> 15 && i<= 29) { //16-29
				currentBills[i] = new Bill();
				currentBills[i].setRoomID(i - 16 + 200); //roomid from 200 - 213
			}
			else if(i>29 && i<= 37) { //30-37
				currentBills[i] = new Bill();
				currentBills[i].setRoomID(i - 30 + 300); //roomid from 300 - 307
			}
			else if(i>37 && i<= 43) { //38-43
				currentBills[i] = new Bill();
				currentBills[i].setRoomID(i - 38 + 400); //roomid from 400 - 405
			}
			else { //44-47
				currentBills[i] = new Bill();
				currentBills[i].setRoomID(i - 44 + 500); //roomid from 500 - 503
			}
		}
	}
	
	//methods
	public void setStayDuration(int roomid) {//NOT COMPLETE this function called when checking out, before printing bill
		int i;
		Date oldCheckIn;
		Date oldCheckOut;
		LocalDate newCheckIn;
		LocalDate newCheckOut;
		int numOfWeekdays;
		int numOfWeekends;
		
		//get the the check in and out dates from our res controller
		oldCheckIn = reservationController.getCurrentCheckIn(roomid);
		oldCheckOut = reservationController.getCurrentCheckOut(roomid);
				
		//changing checkin and checkout from Date to LocalDate 
		newCheckIn = Instant.ofEpochMilli(oldCheckIn.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
		newCheckOut = Instant.ofEpochMilli(oldCheckOut.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
		
		//getting num of weekdays and weekends from the checkin and out dates NOT COMPLETE STILL NEED TO tweak abit
		LocalDate startDate = newCheckIn;
		LocalDate endDate = newCheckOut;
		Set<DayOfWeek> weekend = EnumSet.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);
		Set<DayOfWeek> weekday = EnumSet.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY);
		long weekDaysBetween = startDate.datesUntil(endDate).filter(d -> !weekend.contains(d.getDayOfWeek())).count();
		long weekEndsBetween = startDate.datesUntil(endDate).filter(d -> !weekday.contains(d.getDayOfWeek())).count();
		numOfWeekdays = (int) weekDaysBetween;
		numOfWeekends = (int) weekEndsBetween;
		
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
		for(i=0; i<numOfCurrentBills; i++) {
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
	
	public void printBill(int roomid) {
		int i;
		int j;
		int numOfOrders;
		Orders[] roomServices;
		double totalWeekday = currentBills[i].getNumOfWeekdays() * roomController.getCWeekdayRate(roomid);
		double totalWeekend = currentBills[i].getNumOfWeekends() * roomController.getCWeekendRate(roomid);
		double totalRoomService = 0;
		double discount;
		double tax;
		double totalAmount;
		
		for(i=0; i<numOfCurrentBills; i++) {
			if(roomid == currentBills[i].getRoomID()) {
				numOfOrders = currentBills[i].getNumOfOrders();
				roomServices = currentBills[i].getOrders();
				System.out.println("W Hotel");
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
				//the project assumes payment is always successful... so once pay() function is called, i can assume it is successful and start the after-payment processes
				//archiving the customer's bill
				pastBills[numOfPastBills] = currentBills[i];
				numOfPastBills++;
				
				//reseting the bill attributes
				currentBills[i].setNumOfWeekdays(0);
				currentBills[i].setNumOfWeekends(0);
				currentBills[i].setTax(0);
				currentBills[i].setNumOfOrders(0);
				currentBills[i].setDiscount(0);
				currentBills[i].setPaymentType(false);
				
				//calling function from other controller that will free up the room 
				roomController.updateRoomStatus(roomid, 0);
				
				//print message to say payment succesful
				System.out.println("Payment success!");
				return;
			}
		}
		System.out.println("Please enter a valid Room ID!");
	}
}
