import java.text.SimpleDateFormat;
import java.util.*;

public class Reservation {
    public enum statusType {confirmed, waitList, checkedIn, expired, checkedOut}
    private int reservationCode;
    private int roomID;
    private boolean creditPayment;
    private int numAdults;
    private int numChildren;
    private Date checkInDate;
    private Date checkOutDate;
    private statusType status;
    private String remarks;

    public Reservation(int code, int room, boolean cre,
                       int adult, int child, Date chkin, Date chkout, statusType stat, String rem){
        reservationCode = code;
        roomID = room;
        creditPayment = cre;
        numAdults = adult;
        numChildren = child;
        checkInDate = chkin;
        checkOutDate = chkout;
        status = stat;
        remarks = rem;
    };

    public void setReservationCode(int code){
        reservationCode = code;
    }

    public int getReservationCode() {
        return reservationCode;
    }

    public int getRoomID(){ return roomID; }

    public void setRoomID(int r ){ roomID = r;}

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

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        return " " + reservationCode + " " + roomID + " " + creditPayment + " " + numAdults + " " + numChildren + " " + simpleDateFormat.format(checkInDate) + " " + simpleDateFormat.format(checkOutDate) + " " + status + " " + remarks;
    }
}

