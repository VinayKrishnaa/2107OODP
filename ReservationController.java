import java.util.*;

public class ReservationController2{
    ArrayList<Reservation> curReservations;
    ArrayList<Reservation> pastReservations;
    private int totalR;

    public ReservationController2(){
        int i;
        curReservations = new ArrayList<Reservation>();
        pastReservations = new ArrayList<Reservation>();
        totalR = 0;
    }
    public void createReservation(boolean now){
        Scanner sc = new Scanner(System.in);
        int i, a, c, r, g, y1, m1, d1, y2, m2, d2;
        Date in, out;
        boolean cre;
        String rem;
        try{
            //No of Guest
            System.out.println("Enter the number of Adults");
            a = sc.nextInt();
            System.out.println("Enter the number of Children");
            c = sc.nextInt();
            if(a<0||c<0) throw new Exception("Bad Guests");
            //Check in/out dates
            if(!now){
                System.out.println("Enter the Check in Year");
                y1 = sc.nextInt();
                System.out.println("Enter the Check in Month (Numeric)");
                m1 = sc.nextInt();
                System.out.println("Enter the Check in day");
                d1 = sc.nextInt();
                Calendar inc = new GregorianCalendar(y1, m1, d1);
                in = inc.getTime();
            }
            else {
                in = new Date();
            }
            System.out.println("Enter the Check out Year");
            y2 = sc.nextInt();
            System.out.println("Enter the Check out Month (Numeric)");
            m2 = sc.nextInt();
            System.out.println("Enter the Check out day");
            d2 = sc.nextInt();
            Calendar outc = new GregorianCalendar(y2, m2, d2);
            out = outc.getTime();
            if(out.compareTo(in)<=0){
                System.out.println("Invalid Dates entered");
                throw new Exception("Bad dates");
            }

            //Room Type
            /*System.out.println("Enter the Room type you want");
            System.out.println("(1) Spectacular");
            System.out.println("(2) Marvelous");
            System.out.println("(3) Wonderful");
            System.out.println("(4) Away");
            System.out.println("(5) Suites");
            switch(sc.nextInt()){
                case 1:
                        callCheckRoomAvail()
                        pass in the enum value
                        check for room availability
                        set room status to reserve
                        return roomID as r
            }

            // Guest Details, call method to get guest details
                call the getGuestdetails method;
                to create the Guest object
                return guestID as g



             */
            r = 0;
            g = 0;
            System.out.println("Pay by credit? 1 for Yes, 0 for No");
            i = sc.nextInt();
            if(i == 1){
                cre = true;
            }
            else{
                cre = false;
            }
            System.out.println("Set remarks");
            rem = sc.nextLine();
            /*
            Need to check the rooms to see the vacancy
            then followed by setting status based on vacancy
             */
            curReservations.add(new Reservation(totalR++, r, g, cre, a, c, in, out, Reservation.statusType.confirmed, rem));
            System.out.println("Success");
            printReservation(curReservations.get(curReservations.size()-1).getReservationCode());

        } catch(Exception e){
            System.out.println("Details entered incorrectly");
        }
        return;
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

    public void printReservation(int code) {
        int i;
        for(Reservation R : curReservations) {
            if (R.getReservationCode() == code) {
                System.out.println("Reservation Code:" + R.getReservationCode());
                // Print Room type details (get from room controller)
                // Print Guest details (get from Guest controller)
                System.out.println("Adults:" + R.getAdult());
                System.out.println("Children:" + R.getChildren());
                System.out.println("Check In Date:" + R.getCheckInDate());
                System.out.println("Check Out Date:" + R.getCheckOutDate());
                System.out.println("Status:" + R.getStatus());
                System.out.println("Remarks:" + R.getRemarks());
                return;
            }
        }
        System.out.println("Reservation not in system");

    }

    public void removeReservation(int code){
        if(curReservations.removeIf(r -> (r.getReservationCode() == code))){
            System.out.println("Reservation deleted");
            }
        else System.out.println("Reservation not in system");
        return;
    }

    public void checkIn(double code){
        for(Reservation R : curReservations) {
            if (R.getReservationCode() == code) {
                R.updateStatus(Reservation.statusType.checkedIn);
                //call room controller to check in the room
                System.out.println("Guest check in");
                return;
            }
        }
        System.out.println("Reservation not in system");
    }

    public void reservationCheckOut(double code){
        for(Reservation R : curReservations) {
            if (R.getReservationCode() == code) {
                R.updateStatus(Reservation.statusType.checkedOut);
                pastReservations.add(R);
                curReservations.remove(R);
                }
                System.out.println("Guest checked out");
                return;
            }
        System.out.println("Reservation not in system");
    }


    public int getNumberReservations(){
        return curReservations.size();
    }

    public void expireReservations(Date d){
        for(Reservation R : curReservations) {
            if (d.compareTo(R.getCheckInDate())>=0) {
                if(R.getStatus() != Reservation.statusType.checkedIn){
                    R.updateStatus(Reservation.statusType.expired);
                    pastReservations.add(R);
                    curReservations.remove(R);
                }
            }
        }
    }

    public void printAllReservations(){
        for(Reservation R : curReservations) {
                printReservation(R.getReservationCode());
        }
    }


}
