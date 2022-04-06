import java.util.*;
import java.text.SimpleDateFormat;

public class ReservationController{
    ArrayList<Reservation> curReservations;
    ArrayList<Reservation> pastReservations;
    private int totalR;

    public ReservationController(){
        int i;
        curReservations = new ArrayList<Reservation>();
        pastReservations = new ArrayList<Reservation>();
        totalR = 0;
    }
    public void createReservation(boolean now){
        Scanner sc = new Scanner(System.in);
        int i, a, c, r, y1, m1, d1, y2, m2, d2;
        Date in, out;
        boolean cre;
        String rem, g;
        Reservation.statusType stat;
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
            System.out.println("Enter the Room type you want");
            System.out.println("(1) Spectacular");
            System.out.println("(2) Marvelous");
            System.out.println("(3) Wonderful");
            System.out.println("(4) Away");
            System.out.println("(5) Suites");
            int j, k;
            r = 0;
            switch(sc.nextInt()) {
                case 1:
                    for (j = 11; j <= 15; j++) {
                        k = 0;
                        for (Reservation R : curReservations) {
                            if (R.getRoomID() == j) {
                                if(R.getCheckInDate().compareTo(out)>=0 && in.compareTo(R.getCheckOutDate()) >= 0){
                                    k = 1;
                                    break;
                                }
                            }
                        }
                        if(k == 0){
                            r = j;
                            break;
                        }
                    }
                    if(j == 16) throw new Exception("Not enough rooms available");
                    break;
                case 2:
                    for (j = 21; j <= 25; j++) {
                        k = 0;
                        for (Reservation R : curReservations) {
                            if (R.getRoomID() == j) {
                                if(R.getCheckInDate().compareTo(out)>=0 && in.compareTo(R.getCheckOutDate()) >= 0){
                                    k = 1;
                                    break;
                                }
                            }
                        }
                        if(k == 0){
                            r = j;
                            break;
                        }
                    }
                    if(j == 26) throw new Exception("Not enough rooms available");
                    break;
                case 3:
                    for (j = 31; j <= 35; j++) {
                        k = 0;
                        for (Reservation R : curReservations) {
                            if (R.getRoomID() == j) {
                                if(R.getCheckInDate().compareTo(out)>=0 && in.compareTo(R.getCheckOutDate()) >= 0){
                                    k = 1;
                                    break;
                                }
                            }
                        }
                        if(k == 0){
                            r = j;
                            break;
                        }
                    }
                    if(j == 36) throw new Exception("Not enough rooms available");
                    break;
                case 4:
                    for (j = 41; j <= 45; j++) {
                        k = 0;
                        for (Reservation R : curReservations) {
                            if (R.getRoomID() == j) {
                                if(R.getCheckInDate().compareTo(out)>=0 && in.compareTo(R.getCheckOutDate()) >= 0){
                                    k = 1;
                                    break;
                                }
                            }
                        }
                        if(k == 0){
                            r = j;
                            break;
                        }
                    }
                    if(j == 46) throw new Exception("Not enough rooms available");
                    break;
                case 5:
                    for (j = 51; j <= 55; j++) {
                        k = 0;
                        for (Reservation R : curReservations) {
                            if (R.getRoomID() == j) {
                                if(R.getCheckInDate().compareTo(out)>=0 && in.compareTo(R.getCheckOutDate()) >= 0){
                                    k = 1;
                                    break;
                                }
                            }
                        }
                        if(k == 0){
                            r = j;
                            break;
                        }
                    }
                    if(j == 56) throw new Exception("Not enough rooms available");
                    break;

            }

            // Guest name
            System.out.print("Enter the Guest Full Name: ");
            sc.nextLine();
            g = sc.nextLine();

            System.out.println("Pay by credit? 1 for Yes, 0 for No");
            i = sc.nextInt();
            if(i == 1) cre = true;
            else cre = false;

            if(now) stat = Reservation.statusType.checkedIn;
            else stat = Reservation.statusType.confirmed;

            System.out.print("Set remarks: ");
            sc.nextLine();
            rem = sc.nextLine();

            curReservations.add(new Reservation(totalR++, r, g, cre, a, c, in, out, stat, rem));
            System.out.println("Success");
            printReservation(curReservations.get(curReservations.size()-1).getReservationCode());

        } catch(Exception e){
            System.out.println("Details entered incorrectly");
        }
        return;
    }

    public void printReservation(int code) {
        int i;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        for(Reservation R : curReservations) {
            if (R.getReservationCode() == code) {
                System.out.println("Reservation Code:" + R.getReservationCode());
                i = R.getRoomID();
                switch(i/10){
                    case 1:
                        System.out.println("Spectacular "+ i);
                        break;
                    case 2:
                        System.out.println("Marvelous " + i);
                        break;
                    case 3:
                        System.out.println("Wonderful " + i);
                        break;
                    case 4:
                        System.out.println("Away " + i);
                        break;
                    case 5:
                        System.out.println("Suites " + i);
                        break;
                }
                System.out.println("Guest:" + R.getGuest());
                System.out.println("Adults:" + R.getAdult());
                System.out.println("Children:" + R.getChildren());
                System.out.println("Check In Date:" + simpleDateFormat.format(R.getCheckInDate()));
                System.out.println("Check Out Date:" + simpleDateFormat.format(R.getCheckOutDate()));
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

    public int reservationCheckIn(int code){
        for(Reservation R : curReservations) {
            if (R.getReservationCode() == code) {
                R.updateStatus(Reservation.statusType.checkedIn);
                System.out.println("Guest check in");
                return R.getRoomID();
            }
        }
        System.out.println("Reservation not in system");
        return 0;
    }

    public int reservationCheckOut(int code){
        for(Reservation R : curReservations) {
            if (R.getReservationCode() == code) {
                R.updateStatus(Reservation.statusType.checkedOut);
                pastReservations.add(R);
                int rID = R.getRoomID();
                curReservations.remove(R);
                System.out.println("Guest checked out");
                return rID;
                }
            }
        System.out.println("Reservation not in system");
        return 0;
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
