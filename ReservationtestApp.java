import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class ReservationtestApp {

    public static void main(String[] args){
        ReservationController Rod = new ReservationController();

        Rod.createReservation();
        Rod.printAllReservations();
        Rod.getNumberReservations();
    }
}
