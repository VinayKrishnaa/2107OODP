//package sce.cz2002.project;

/* Overall app for the hotel management system.*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.util.*;

public class HotelView{

    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to W Hotel!");
        System.out.println("Please enter your option: ");

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("|1. View hotel administrative information.");
            System.out.println("|2. Guest stay functions.");
            System.out.println("|3. Hotel administration procedures.");
            System.out.println("|4. Save and exit menu");
            switch(sc.nextInt()) {
                case 1:
                    System.out.println("|1. View current reservation list.");
                    System.out.println("|2. View current guest list.");
                    System.out.println("|3. View past billing information.");
                    System.out.println("|4. View room status");
                    System.out.println("|5. View room availability");
                    switch(sc.nextInt()) {
                        case 1:
                            RC.printAllReservations();
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                case 2:
                    int code, roomID;
                    System.out.println("|1. Check in");
                    System.out.println("|2. Check out");
                    System.out.println("|3. Walk-in guest");
                    System.out.println("|4. Create reservation");
                    switch(sc.nextInt()) {
                        case 1:
                            System.out.println("Enter Reservation Code");
                            code = sc.nextInt();
                            roomID = RC.reservationCheckIn(code);
                            // if(roomID != 0) Check in Room @Vinay

                            break;
                        case 2:
                            System.out.println("Enter Reservation Code");
                            code = sc.nextInt();
                            roomID = RC.reservationCheckOut(code);
                            // if(roomID != 0) Check in Room @Vinay
                            break;
                        case 3:
                            RC.createReservation(true);
                            // Save RC in txt
                            break;
                        case 4:
                            RC.createReservation(false);
                            // Save RC in txt
                            break;
                    }
                    break;
                case 3:
                    System.out.println("|1. Update room status.");
                    System.out.println("|2. Order room service");
                    System.out.println("|3. Update room service menu items");
                    switch(sc.nextInt()) {
                        case 1:
                            break;
                        case 2:
                            //MenuUI.getinstance().displayOptions();
                            break;
                        case 3:
                            break;
                    }
                    break;
                case 4:
                    Date today = new Date();
                    RC.expireReservations(today);
                    // Save data into text file
                    System.exit(0);
                default:
                    System.out.println("Please enter a valid option!");
            }
        } while (true);
    }

}

