import java.util.*;
import java.text.SimpleDateFormat;

public class ReservationController {
    ArrayList<Reservation> curReservations;
    ArrayList<Reservation> pastReservations;
    public static ReservationController instance = null;

    public ReservationController() {
        curReservations = new ArrayList<Reservation>();
        pastReservations = new ArrayList<Reservation>();
    }

    public static ReservationController createInstance() {
        if (instance == null)
            instance = new ReservationController();
        return instance;
    }

    public void createReservation(int a, int c, Date in, Date out, int roomType, boolean cre, boolean now, String rem) {
        int r;
        Reservation.statusType stat;
        try {
            int j, k;
            r = 0;
            switch (roomType) {
                case 1:
                    for (j = 100; j <= 115; j++) {
                        k = 0;
                        for (Reservation R : curReservations) {
                            if (R.getRoomID() == j) {
                                if (R.getCheckInDate().compareTo(out) <= 0 && in.compareTo(R.getCheckOutDate()) <= 0) {
                                    k = 1;
                                    break;
                                }
                            }
                        }
                        if (k == 0) {
                            r = j;
                            break;
                        }
                    }
                    if (j == 116) throw new Exception("Not enough rooms available");
                    break;
                case 2:
                    for (j = 200; j <= 213; j++) {
                        k = 0;
                        for (Reservation R : curReservations) {
                            if (R.getRoomID() == j) {
                                if (R.getCheckInDate().compareTo(out) <= 0 && in.compareTo(R.getCheckOutDate()) <= 0) {
                                    k = 1;
                                    break;
                                }
                            }
                        }
                        if (k == 0) {
                            r = j;
                            break;
                        }
                    }
                    if (j == 214) throw new Exception("Not enough rooms available");
                    break;
                case 3:
                    for (j = 300; j <= 307; j++) {
                        k = 0;
                        for (Reservation R : curReservations) {
                            if (R.getRoomID() == j) {
                                if (R.getCheckInDate().compareTo(out) <= 0 && in.compareTo(R.getCheckOutDate()) <= 0) {
                                    k = 1;
                                    break;
                                }
                            }
                        }
                        if (k == 0) {
                            r = j;
                            break;
                        }
                    }
                    if (j == 308) throw new Exception("Not enough rooms available");
                    break;
                case 4:
                    for (j = 400; j <= 405; j++) {
                        k = 0;
                        for (Reservation R : curReservations) {
                            if (R.getRoomID() == j) {
                                if (R.getCheckInDate().compareTo(out) <= 0 && in.compareTo(R.getCheckOutDate()) <= 0) {
                                    k = 1;
                                    break;
                                }
                            }
                        }
                        if (k == 0) {
                            r = j;
                            break;
                        }
                    }
                    if (j == 406) throw new Exception("Not enough rooms available");
                    break;
                case 5:
                    for (j = 500; j <= 503; j++) {
                        k = 0;
                        for (Reservation R : curReservations) {
                            if (R.getRoomID() == j) {
                                if (R.getCheckInDate().compareTo(out) <= 0 && in.compareTo(R.getCheckOutDate()) <= 0) {
                                    k = 1;
                                    break;
                                }
                            }
                        }
                        if (k == 0) {
                            r = j;
                            break;
                        }
                    }
                    if (j == 504) throw new Exception("Not enough rooms available");
                    break;

            }
            if (now) stat = Reservation.statusType.checkedIn;
            else stat = Reservation.statusType.confirmed;

            int max = 0;
            for (Reservation R : curReservations){
                if(max < R.getReservationCode()) max = R.getReservationCode();
            }


            curReservations.add(new Reservation(max+1, r, cre, a, c, in, out, stat, rem));
            System.out.println("Success");
            printReservation(curReservations.get(curReservations.size() - 1).getReservationCode());

        } catch (Exception e) {
        }
        return;
    }


    public void printReservation(int code) {
        int i;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        for (Reservation R : curReservations) {
            if (R.getReservationCode() == code) {
                System.out.println("Reservation Code:" + R.getReservationCode());
                i = R.getRoomID();
                switch (i / 100) {
                    case 1:
                        System.out.println("Wonderful " + i);
                        break;
                    case 2:
                        System.out.println("Spectacular " + i);
                        break;
                    case 3:
                        System.out.println("Fabulous " + i);
                        break;
                    case 4:
                        System.out.println("Away " + i);
                        break;
                    case 5:
                        System.out.println("Suites " + i);
                        break;
                }
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

    public void removeReservation(int code) {
        if (curReservations.removeIf(r -> (r.getReservationCode() == code))) {
            System.out.println("Reservation deleted");
        } else System.out.println("Reservation not in system");
        return;
    }


    public int reservationCheckIn(int code) {
        for (Reservation R : curReservations) {
            if (R.getReservationCode() == code) {
                R.updateStatus(Reservation.statusType.checkedIn);
                System.out.println("Guest check in");
                return R.getRoomID();
            }
        }
        System.out.println("Reservation not in system");
        return 0;
    }

    public int reservationCheckOut(int code) {
        for (Reservation R : curReservations) {
            if (R.getReservationCode() == code && R.getStatus() == Reservation.statusType.checkedIn) {
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


    public int getNumberReservations() {
        return curReservations.size();
    }

    public Date getCurrentCheckIn(int rID) {
        for (Reservation R : curReservations) {
            if (R.getRoomID() == rID) {
                if (R.getStatus() == Reservation.statusType.checkedIn) return R.getCheckInDate();
            }
        }
        Date now = new Date();
        System.out.println("No Current Stayers in this room");
        return now;
    }

    public Date getCurrentCheckOut(int rID) {
        for (Reservation R : curReservations) {
            if (R.getRoomID() == rID) {
                if (R.getStatus() == Reservation.statusType.checkedIn) return R.getCheckOutDate();
            }
        }
        Date now = new Date();
        System.out.println("No Current Stayers in this room");
        return now;
    }

    public void expireReservations(Date d) {
        for (Reservation R : curReservations) {
            if (d.compareTo(R.getCheckInDate()) >= 0) {
                if (R.getStatus() != Reservation.statusType.checkedIn) {
                    R.updateStatus(Reservation.statusType.expired);
                    pastReservations.add(R);
                    curReservations.remove(R);
                }
            }
        }
    }

    public void printAllReservations() {
        for (Reservation R : curReservations) {
            printReservation(R.getReservationCode());
            System.out.println();
        }
    }

    public void updateReservationMinor(int code, int a, int c, boolean cre, String rem) {
        for (Reservation R2 : curReservations) {
            if (R2.getReservationCode() == code) {
                R2.setAdult(a);
                R2.setChildren(c);
                R2.setCreditPayment(cre);
                R2.setRemarks(rem);
                System.out.println("Success");
                return;
            }
        }
        System.out.println("Reservation not found");
    }

    public void updateReservationMajor(int code, Date in, Date out, int roomType, boolean now) {
        int r;
        Reservation.statusType stat;

        for (Reservation R2 : curReservations) {
            if (R2.getReservationCode() == code && R2.getStatus() == Reservation.statusType.confirmed) {
                int j, k;
                r = 0;
                switch (roomType) {
                    case 1:
                        for (j = 100; j <= 115; j++) {
                            k = 0;
                            for (Reservation R : curReservations) {
                                if (R.getRoomID() == j && R2.getReservationCode() != R.getReservationCode()) {
                                    if (R.getCheckInDate().compareTo(out) <= 0 && in.compareTo(R.getCheckOutDate()) <= 0) {
                                        k = 1;
                                        break;
                                    }
                                }
                            }
                            if (k == 0) {
                                r = j;
                                break;
                            }
                        }
                        break;
                    case 2:
                        for (j = 200; j <= 213; j++) {
                            k = 0;
                            for (Reservation R : curReservations) {
                                if (R.getRoomID() == j && R2.getReservationCode() != R.getReservationCode()) {
                                    if (R.getCheckInDate().compareTo(out) <= 0 && in.compareTo(R.getCheckOutDate()) <= 0) {
                                        k = 1;
                                        break;
                                    }
                                }
                            }
                            if (k == 0) {
                                r = j;
                                break;
                            }
                        }
                        break;
                    case 3:
                        for (j = 300; j <= 307; j++) {
                            k = 0;
                            for (Reservation R : curReservations) {
                                if (R.getRoomID() == j && R2.getReservationCode() != R.getReservationCode()) {
                                    if (R.getCheckInDate().compareTo(out) <= 0 && in.compareTo(R.getCheckOutDate()) <= 0) {
                                        k = 1;
                                        break;
                                    }
                                }
                            }
                            if (k == 0) {
                                r = j;
                                break;
                            }
                        }
                        break;
                    case 4:
                        for (j = 400; j <= 405; j++) {
                            k = 0;
                            for (Reservation R : curReservations) {
                                if (R.getRoomID() == j && R2.getReservationCode() != R.getReservationCode()) {
                                    if (R.getCheckInDate().compareTo(out) <= 0 && in.compareTo(R.getCheckOutDate()) <= 0) {
                                        k = 1;
                                        break;
                                    }
                                }
                            }
                            if (k == 0) {
                                r = j;
                                break;
                            }
                        }
                        break;
                    case 5:
                        for (j = 500; j <= 503; j++) {
                            k = 0;
                            for (Reservation R : curReservations) {
                                if (R.getRoomID() == j && R2.getReservationCode() != R.getReservationCode()) {
                                    if (R.getCheckInDate().compareTo(out) <= 0 && in.compareTo(R.getCheckOutDate()) <= 0) {
                                        k = 1;
                                        break;
                                    }
                                }
                            }
                            if (k == 0) {
                                r = j;
                                break;
                            }
                        }
                        break;
                }
                if (r != 0) {
                    R2.setCheckInDate(in);
                    R2.setCheckOutDate(out);
                    R2.setRoomID(r);
                } else {
                    System.out.println("No rooms of this type available in this period time");
                    return;
                }
                System.out.println("Success");
                if (now) stat = Reservation.statusType.checkedIn;
                else stat = Reservation.statusType.confirmed;
                R2.updateStatus(stat);
                return;
            }
        }
    }

    public int returnRoomID(int code) {
        for (Reservation R : curReservations) {
            if (R.getReservationCode() == code) return R.getRoomID();
        }
        System.out.println("Reservation not found");
        return 0;
    }
}


