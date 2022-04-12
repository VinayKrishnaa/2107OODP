import java.util.Calendar;
import java.util.Date;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ReservationUI {

    public static ReservationUI instance = null;

    public ReservationUI() {
    }

    // create instance of menuUI
    public static ReservationUI getinstance() {
        if (instance == null)
            instance = new ReservationUI();
        return instance;
    }

    ReservationController r = new ReservationController();

    // display all available options of ReservationUI
    public void displayOptions() throws IOException {
        ReservationController.createInstance();
        ReservationDB.getInstance().readData(r.curReservations);
        PastReservationDB.getInstance().readData(r.pastReservations);
        Scanner sc = new Scanner(System.in);
        try {
            int i, rCode, a, c, room, y1, m1, d1, y2, m2, d2;
            Date in, out;
            boolean cre;
            String rem;
            do {
                System.out.println("Please select your option");
                System.out.println("(1) Create Reservation");
                System.out.println("(2) Walk in Reservation");
                System.out.println("(3) Update Reservation minor details (credit payment, number of guest, remarks)");
                System.out.println("(4) Update Reservation Major details (dates, room type)");
                System.out.println("(5) Remove Reservation");
                System.out.println("(6) Print All reservation");
                System.out.println("(7) Check In");
                System.out.println("(8) Check Out");
                System.out.println("(9) Expire Reservation");
                System.out.println("(10) Exit");
                switch(sc.nextInt()) {
                    case 1:									// add new Reservation
                        try {
                            System.out.println("Enter the number of Adults");
                            a = sc.nextInt();
                            System.out.println("Enter the number of Children");
                            c = sc.nextInt();
                            if (a < 0 || c < 0) throw new Exception("Bad Guests");

                            //Check in/out dates
                            System.out.println("Enter the Check in Year");
                            y1 = sc.nextInt();
                            System.out.println("Enter the Check in Month (Numeric)");
                            m1 = sc.nextInt();
                            System.out.println("Enter the Check in day");
                            d1 = sc.nextInt();
                            Calendar inc = new GregorianCalendar(y1, m1-1, d1);
                            in = inc.getTime();
                            System.out.println("Enter the Check out Year");
                            y2 = sc.nextInt();
                            System.out.println("Enter the Check out Month (Numeric)");
                            m2 = sc.nextInt();
                            System.out.println("Enter the Check out day");
                            d2 = sc.nextInt();
                            Calendar outc = new GregorianCalendar(y2, m2-1, d2);
                            out = outc.getTime();
                            if (out.compareTo(in) <= 0) {
                                System.out.println("Invalid Dates entered");
                                throw new Exception("Bad dates");
                            }
                            System.out.println("Enter the Room type you want");
                            System.out.println("(1) Wonderful");
                            System.out.println("(2) Spectacular");
                            System.out.println("(3) Fabulous");
                            System.out.println("(4) Away");
                            System.out.println("(5) Suites");
                            room = sc.nextInt();
                            if(room<1 || room > 5) throw new Exception("Invalid Room Type");

                            System.out.println("Pay by credit? 1 for Yes, 0 for No");
                            if (sc.nextInt() == 1) cre = true;
                            else cre = false;

                            System.out.print("Set remarks: ");
                            sc.nextLine();
                            rem = "-" + sc.nextLine();
                            r.createReservation(a, c, in, out, room, cre, false, rem);
                        } catch (Exception e) {
                            System.out.println("Details entered incorrectly");
                        }
                        ReservationDB.getInstance().saveData(r.curReservations);
                        break;

                    case 2:									// create reservation for walk in
                        try {
                            System.out.println("Enter the number of Adults");
                            a = sc.nextInt();
                            System.out.println("Enter the number of Children");
                            c = sc.nextInt();
                            if (a < 0 || c < 0) throw new Exception("Bad Guests");

                            //Check in/out dates
                            in = new Date();
                            System.out.println("Enter the Check out Year");
                            y2 = sc.nextInt();
                            System.out.println("Enter the Check out Month (Numeric)");
                            m2 = sc.nextInt();
                            System.out.println("Enter the Check out day");
                            d2 = sc.nextInt();
                            Calendar outc = new GregorianCalendar(y2, m2-1, d2);
                            out = outc.getTime();
                            if (out.compareTo(in) <= 0) {
                                System.out.println("Invalid Dates entered");
                                throw new Exception("Bad dates");
                            }
                            System.out.println("Enter the Room type you want");
                            System.out.println("(1) Wonderful");
                            System.out.println("(2) Spectacular");
                            System.out.println("(3) Fabulous");
                            System.out.println("(4) Away");
                            System.out.println("(5) Suites");
                            room = sc.nextInt();
                            if(room<1 || room > 5) throw new Exception("Invalid Room Type");

                            System.out.println("Pay by credit? 1 for Yes, 0 for No");
                            if (sc.nextInt() == 1) cre = true;
                            else cre = false;

                            System.out.print("Set remarks: ");
                            sc.nextLine();
                            rem = "-" + sc.nextLine();
                            r.createReservation(a, c, in, out, room, cre, true, rem);
                        } catch (Exception e) {
                            System.out.println("Details entered incorrectly");
                        }
                        ReservationDB.getInstance().saveData(r.curReservations);
                        break;
                    case 3:									// update minor
                        try {
                            System.out.println("Enter reservation code to update");
                            rCode = sc.nextInt();
                            System.out.println("Enter the number of Adults");
                            a = sc.nextInt();
                            System.out.println("Enter the number of Children");
                            c = sc.nextInt();
                            if (a < 0 || c < 0) throw new Exception("Bad Guests");

                            System.out.println("Pay by credit? 1 for Yes, 0 for No");
                            if (sc.nextInt() == 1) cre = true;
                            else cre = false;

                            System.out.print("Set remarks: ");
                            sc.nextLine();
                            rem = "-" + sc.nextLine();
                            r.updateReservationMinor(rCode, a, c, cre, rem);
                        } catch (Exception e) {
                            System.out.println("Details entered incorrectly");
                        }
                        ReservationDB.getInstance().saveData(r.curReservations);
                        break;
                    case 4:									// update major
                        try {
                            System.out.println("Enter reservation code to update");
                            rCode = sc.nextInt();
                            boolean now;
                            System.out.println("Change date to check in now? (1) for Yes and (0) for No");
                            if(sc.nextInt()==1){
                                in = new Date();
                                now = true;
                            }
                            else{
                                System.out.println("Enter the Check in Year");
                                y1 = sc.nextInt();
                                System.out.println("Enter the Check in Month (Numeric)");
                                m1 = sc.nextInt();
                                System.out.println("Enter the Check in day");
                                d1 = sc.nextInt();
                                Calendar inc = new GregorianCalendar(y1, m1-1, d1);
                                in = inc.getTime();
                                now = false;
                            }
                            System.out.println("Enter the Check out Year");
                            y2 = sc.nextInt();
                            System.out.println("Enter the Check out Month (Numeric)");
                            m2 = sc.nextInt();
                            System.out.println("Enter the Check out day");
                            d2 = sc.nextInt();
                            Calendar outc = new GregorianCalendar(y2, m2-1, d2);
                            out = outc.getTime();
                            if (out.compareTo(in) <= 0) {
                                System.out.println("Invalid Dates entered");
                                throw new Exception("Bad dates");
                            }

                            System.out.println("Enter the Room type you want");
                            System.out.println("(1) Wonderful");
                            System.out.println("(2) Spectacular");
                            System.out.println("(3) Fabulous");
                            System.out.println("(4) Away");
                            System.out.println("(5) Suites");
                            room = sc.nextInt();
                            if(room<1 || room > 5) throw new Exception("Invalid Room Type");
                            r.updateReservationMajor(rCode, in, out, room, now);
                            System.out.println("Successfully changed");
                        } catch (Exception e) {
                            System.out.println("Details entered incorrectly");
                        }
                        ReservationDB.getInstance().saveData(r.curReservations);
                        break;
                    case 5:									// remove reservation
                        try{
                            System.out.println("Enter reservation code to remove");
                            rCode = sc.nextInt();
                            r.removeReservation(rCode);
                        } catch (Exception e) {
                            System.out.println("Incorrect code entered");
                        }
                        ReservationDB.getInstance().saveData(r.curReservations);
                        break;
                    case 6:									// print all reservation
                        r.printAllReservations();
                        break;
                    case 7:									// check in
                        try{
                            System.out.println("Enter reservation code to check in");
                            rCode = sc.nextInt();
                            r.reservationCheckIn(rCode);
                        } catch (Exception e) {
                            System.out.println("Incorrect code entered");
                        }
                        break;
                    case 8:                                 // check out
                        try{
                            System.out.println("Enter reservation code to check out");
                            rCode = sc.nextInt();
                            r.reservationCheckOut(rCode);
                        } catch (Exception e) {
                            System.out.println("Incorrect code entered");
                        }
                        break;
                    case 9:                                 // expire reservations
                        Date currentDate = new Date();
                        r.expireReservations(currentDate);
                        break;
                    case 10:                                // exit interface
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please enter a valid number!");
                        break;
                }
            } while (true);
        }
        finally {
            sc.close();
        }
    }
    public static void main(String[] args) throws IOException {
        ReservationUI.getinstance().displayOptions();
    }
}
