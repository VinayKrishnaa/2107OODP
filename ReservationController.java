import java.util.*;

public class ReservationController{
    private Reservation[] curReservations;
    private Reservation[] pastReservations;
    private double totalRthusfar;

    public ReservationController(){
        int i;
        curReservations = new Reservation[100];
        pastReservations = new Reservation[100];
        for(i=0; i<100; i++){
            curReservations[i] = new Reservation(-1);
            pastReservations[i] = new Reservation(-1);
        }
        totalRthusfar = 0;
    }

    public void createReservation(){
        Scanner sc = new Scanner(System.in);
        int i, a, c, d, y1, m1, d1, y2, m2, d2;

        for(i=0; i<100; i++) {
            if (curReservations[i].getReservationCode() == -1) {
                try{
                    //No of Guest
                    System.out.println("Enter the number of Adults");
                    a = sc.nextInt();
                    System.out.println("Enter the number of Children");
                    c = sc.nextInt();
                    if(a<0||c<0) throw new Exception("Bad Guests");
                    curReservations[i].setAdult(a);
                    curReservations[i].setChildren(c);

                    //Check in/out dates
                    System.out.println("Enter the Check in Year");
                    y1 = sc.nextInt();
                    System.out.println("Enter the Check in Month (Numeric)");
                    m1 = sc.nextInt();
                    System.out.println("Enter the Check in day");
                    d1 = sc.nextInt();
                    Calendar inc = new GregorianCalendar(y1, m1, d1);
                    Date in = inc.getTime();
                    System.out.println("Enter the Check out Year");
                    y2 = sc.nextInt();
                    System.out.println("Enter the Check out Month (Numeric)");
                    m2 = sc.nextInt();
                    System.out.println("Enter the Check out day");
                    d2 = sc.nextInt();
                    Calendar outc = new GregorianCalendar(y2, m2, d2);
                    Date out = outc.getTime();
                    if(out.compareTo(in)<=0){
                        System.out.println("Invalid Dates entered");
                        throw new Exception("Bad dates");
                    }
                    curReservations[i].setCheckInDate(in);
                    curReservations[i].setCheckOutDate(out);

                    //Room Type
                    /*System.out.println("Enter the Room type you want");
                    System.out.println("(1) Spectacular");
                    System.out.println("(2) Marvelous");
                    System.out.println("(3) Wonderful");
                    System.out.println("(4) Away");
                    System.out.println("(5) Suites");
                    switch(sc.nextInt()){
                        case 1:
                                pass in the enum value
                                check for room availability
                                set room status to reserve
                                return roomID
                    }

                    // Guest Details, call method to get guest details
                        call the getGuestdetails method;
                        to create the Guest object
                        return guestID



                     */

                    System.out.println("Set remarks");
                    curReservations[i].setRemarks(sc.nextLine());
                    /*
                    Need to check the rooms to see the vacancy
                    then followed by setting status based on vacancy
                     */

                    curReservations[i].setReservationCode(totalRthusfar);
                    totalRthusfar++;

                    System.out.println("Success");
                    printReservation(curReservations[i].getReservationCode());

                } catch(Exception e){
                    System.out.println("Details entered incorrectly");
                }
                return;
            }
        }
        System.out.println("Maximum number of Reservations reached, unable to add reservations");
    }

    public void copyReservation(Reservation r1, Reservation r2){
        r1.setReservationCode(r2.getReservationCode());
        /*
        r1.setRoomType(r2.getRoomType());
        r1.setAssociatedGuest(r2.getAssGuest());
         */
        r1.setCreditPayment(r2.getCreditPayment());
        r1.setAdult(r2.getAdult());
        r1.setChildren(r2.getChildren());
        r1.setCheckInDate(r2.getCheckInDate());
        r1.setCheckOutDate(r2.getCheckOutDate());
        r1.setRemarks(r2.getRemarks());
        r1.updateStatus(r2.getStatus());
    }

    public void printReservation(double code) {
        int i;
        for(i=0; i<100; i++) {
            if (curReservations[i].getReservationCode() == code) {
                System.out.println("Reservation Code:" + curReservations[i].getReservationCode());
                // Print Room type details (get from room controller)
                // Print Guest details (get from Guest controller)
                System.out.println("Adults:" + curReservations[i].getAdult());
                System.out.println("Children:" + curReservations[i].getChildren());
                System.out.println("Check In Date:" + curReservations[i].getCheckInDate());
                System.out.println("Check Out Date:" + curReservations[i].getCheckOutDate());
                System.out.println("Status:" + curReservations[i].getStatus());
                System.out.println("Remarks:" + curReservations[i].getRemarks());
                return;
            }
        }
        System.out.println("Reservation not in system");

    }

    public void removeReservation(double code){
        int i;
        for(i=0; i<100; i++) {
            if (curReservations[i].getReservationCode() == code) {
                curReservations[i].setReservationCode(-1);
                System.out.println("Reservation deleted");
                return;
            }
        }
        System.out.println("Reservation not in system");
    }

    public void checkIn(double code){
        int i, j;
        for(i=0; i<100; i++) {
            if (curReservations[i].getReservationCode() == code) {
                curReservations[i].updateStatus(Reservation.statusType.checkedIn);
                //call room controller to check in the room
                System.out.println("Guest check in");
                return;
            }
        }
        System.out.println("Reservation not in system");
    }

    public void reservationCheckOut(double code){
        int i, j;
        for(i=0; i<100; i++) {
            if (curReservations[i].getReservationCode() == code) {
                curReservations[i].updateStatus(Reservation.statusType.checkedOut);
                for(j=0; j<100; j++) {
                    if(pastReservations[j].getReservationCode() == -1){
                        copyReservation(pastReservations[j], curReservations[i]);
                        break;
                        // call removeGuest() method;
                    }
                }
                if(j==100) System.out.println("Database Full, need to clear past reservations");
                curReservations[i].setReservationCode(-1);
                System.out.println("Guest checked out");
                return;
            }
        }
        System.out.println("Reservation not in system");
    }

    public int getNumberReservations(){
        int i;
        int count = 0;
        for(i=0; i<100; i++) {
            if (curReservations[i].getReservationCode() != -1) count++;
        }
        return count;
    }

    public void expireReservations(Date d){
        int i, j;
        for(i=0; i<100; i++) {
            if (d.compareTo(curReservations[i].getCheckInDate())>=0) {
                if(curReservations[i].getStatus() != Reservation.statusType.checkedIn)
                curReservations[i].updateStatus(Reservation.statusType.expired);
            }
        }
    }

    public void printDelExpired(){
        int i, j;
        for(i=0; i<100; i++) {
            if(curReservations[i].getStatus() == Reservation.statusType.expired);
            printReservation(curReservations[i].getReservationCode());
            removeReservation(curReservations[i].getReservationCode());
            }
        }
    public void printAllReservations(){
        int i, j;
        for(i=0; i<100; i++) {
            if(curReservations[i].getReservationCode() != -1){
                printReservation(curReservations[i].getReservationCode());
            }
        }
    }
}
