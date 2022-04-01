import java.util.*;

public class Reservation {
    public enum statusType {confirmed, inWaitlist, rejected, checkedIn, expired, checkedOut}
    private double reservationCode;
    //private Room roomID;
    //private Guest guestID;
    private boolean creditPayment;
    private int numAdults;
    private int numChildren;
    private Date checkInDate;
    private Date checkOutDate;
    private statusType status;
    private String remarks;

    public Reservation(double code){
        reservationCode = code;
    };

    public void setReservationCode(double code){
        reservationCode = code;
    }

    public double getReservationCode() {
        return reservationCode;
    }

    /*public Guest getAssGuest(){ return associatedGuest }
    public void setAssGuest(Guest g){ associatedGuest = g}
    public Room getRoomType(){ return roomType}
    public void setRoomType(Room type){ roomType = type;}
     */
    public statusType getStatus() {
        return status;
    }

    public void updateStatus(statusType stat) {
        status = stat;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String rem) {
        remarks = rem;
    }

    public boolean getCreditPayment() {
        return creditPayment;
    }

    public void setCreditPayment(Boolean credit) {
        creditPayment = credit;
    }

    public int getAdult() {
        return numAdults;
    }

    public void setAdult(int a) {
        numAdults = a;
    }

    public int getChildren() {
        return numChildren;
    }

    public void setChildren(int a) {
        numChildren = a;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date in) {
        checkInDate = in;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date out) {
        checkOutDate = out;
    }
}
