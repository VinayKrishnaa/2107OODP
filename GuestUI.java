import Controller.GuestController;
import DB.GuestDB;
import Class.Guest;

import java.io.IOException;
import java.util.Scanner;

public class GuestUI {
    public static GuestUI instance = null;

    public GuestUI() {
    }

    // create instance of menuUI
    public static GuestUI getinstance() {
        if (instance == null)
            instance = new GuestUI();
        return instance;
    }

    GuestController g = new GuestController();

    // display all available options of menuUI
    public void displayOptions() {
        GuestController.createInstance();
        DB.GuestDB.getInstance().readData(g.getGuestList());
        Scanner sc = new Scanner(System.in);

        do {
            String name = "";
            String country = "";
            String gender = "";
            Boolean identity = false; // false == license | true == passport
            String identityInfo = "";
            Integer contactNumber = 0;
            String address = "";
            Integer rcode = 0;
            String creditCardNumber = "";
            String email = "";
            Integer age = 0;
            Integer genderSelection = 0;
            Integer identitySelection = 0;
            String lic = "";
            String pp = "";
            int updateType = 0;

            // validation
            String alpha = "[a-zA-Z.*\\s+.]+";

            System.out.println("Please select your option");
            System.out.println("(1) Add a guest");
            System.out.println("(2) Update a reserved guest");
            System.out.println("(3) Update guest details");
            System.out.println("(4) Print guest list");
            System.out.println("(5) Print a guest detail");
            System.out.println("(6) Exit");
            System.out.println("Your input:");
            switch (sc.nextInt()) {
                case 1: // add a guest
                    sc.nextLine();
                    System.out.println("\n---Guest Registration---");
                    System.out.println("Please input a valid name: ");
                    name = sc.nextLine();

                    if (name.equals("") || !name.matches(alpha)) {
                        System.out.println("Invalid name");
                    }

                    System.out.println("Please input a country: ");
                    country = sc.nextLine();

                    if (country.equals("") || !country.matches(alpha)) {
                        System.out.println("Invalid country");
                    }

                    System.out.println("Gender: ");
                    System.out.print("(1) Male (2) Female ");
                    genderSelection = sc.nextInt();
                    sc.nextLine();

                    if (genderSelection != 1 && genderSelection != 2) {
                        System.out.println("Invalid choice");
                    }

                    if (genderSelection == 1){
                        gender = "Male";
                    }
                    else if (genderSelection == 2){
                        gender = "Female";
                    }

                    System.out.println("Please input a identity type: ");
                    System.out.print("Identity Type - (1) Driving License (2) Passport: ");
                    identitySelection = sc.nextInt();
                    sc.nextLine();

                    if (identitySelection != 1 && identitySelection != 2) {
                        System.out.println("Invalid choice");
                    }

                    if (identitySelection == 1) {
                        System.out.print("Driving License: ");
                        lic = sc.nextLine();
                        identity = false;
                        identityInfo = lic;

                        if (lic.equals("")) {
                            System.out.println("Invalid license");
                        }

                    } else if (identitySelection == 2) {
                        System.out.print("Passport Number: ");
                        pp = sc.nextLine();
                        identity = true;
                        identityInfo = pp;

                        if (pp.equals("")) {
                            System.out.println("Invalid passport");
                        }
                    }

                    System.out.println("Please input contact number: ");
                    contactNumber = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Please input address: ");
                    address = sc.nextLine();

                    System.out.println("Please input rcode: ");
                    rcode = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Please input credit card number: ");
                    creditCardNumber = sc.nextLine();

                    System.out.println("Please input email address: ");
                    email = sc.nextLine();

                    System.out.println("Please input age: ");
                    age = sc.nextInt();
                    sc.nextLine();

                    g.createGuest(name, country, gender, identity, identityInfo,
                            contactNumber, address, rcode, creditCardNumber, email, age);
                    break;
                case 2: // update details of reserved guest
                    sc.nextLine();
                    System.out.println("\n---Updating Guest Registration---");

                    do {
                        System.out.print("Please enter name of guest to search: ");
                        name = sc.nextLine();
                    } while (g.retrieveGuestDetails(name) == null);

                    System.out.println("Please input a country: ");
                    country = sc.nextLine();

                    if (country.equals("") || !country.matches(alpha)) {
                        System.out.println("Invalid country");
                    }

                    System.out.println("Gender: ");
                    System.out.print("(1) Male (2) Female ");
                    genderSelection = sc.nextInt();
                    sc.nextLine();

                    if (genderSelection != 1 && genderSelection != 2) {
                        System.out.println("Invalid choice");
                    }

                    if (genderSelection == 1){
                        gender = "Male";
                    }
                    else if (genderSelection == 2){
                        gender = "Female";
                    }

                    System.out.println("Please input a identity type: ");
                    System.out.print("Identity Type - (1) Driving License (2) Passport: ");
                    identitySelection = sc.nextInt();
                    sc.nextLine();

                    if (identitySelection != 1 && identitySelection != 2) {
                        System.out.println("Invalid choice");
                    }

                    if (identitySelection == 1) {
                        System.out.print("Driving License: ");
                        lic = sc.nextLine();
                        identity = false;
                        identityInfo = lic;

                        if (lic.equals("")) {
                            System.out.println("Invalid license");
                        }
                    } else if (identitySelection == 2) {
                        System.out.print("Passport Number: ");
                        pp = sc.nextLine();
                        identity = true;
                        identityInfo = pp;

                        if (pp.equals("")) {
                            System.out.println("Invalid passport");
                        }
                    }

                    System.out.println("Please input address: ");
                    address = sc.nextLine();

                    System.out.println("Please input credit card number: ");
                    creditCardNumber = sc.nextLine();

                    System.out.println("Please input age: ");
                    age = sc.nextInt();
                    sc.nextLine();

                    g.updateReserveGuest(name, country, gender, identity, identityInfo,
                            address, creditCardNumber, age);
                    break;
                case 3: // update specific guest details
                    sc.nextLine();
                    System.out.println("\n---Updating Guest detail---");
                    do {
                        System.out.print("Please enter name of guest to update: ");
                        name = sc.nextLine();
                    } while (g.retrieveGuestDetails(name) == null);

                    System.out.print("Please select guest details to update - \n(1) Name (2) Gender (3) Credit Card (4) Address (5) Country (6) Contact No. : ");
                    updateType = sc.nextInt();
                    sc.nextLine();

                    switch (updateType) {
                        case 1:
                            System.out.print("\nNew Guest Name: ");
                            String newName = sc.nextLine();

                            if (newName.equals("") || !newName.matches(alpha)) {
                                System.out.println("\nInvalid name");
                            }
                            g.updateGuest(1, name, newName);
                            break;
                        case 2:
                            System.out.println("\nNew Gender: ");
                            System.out.print("(1) Male (2) Female ");
                            genderSelection = sc.nextInt();
                            sc.nextLine();

                            if (genderSelection != 1 && genderSelection != 2) {
                                System.out.println("\nInvalid choice");
                            }

                            if (genderSelection == 1) {
                                gender = "Male";
                            } else if (genderSelection == 2) {
                                gender = "Female";
                            }
                            g.updateGuest(2, name, gender);
                            break;
                        case 3:
                            System.out.println("\nPlease input new credit card number: ");
                            creditCardNumber = sc.nextLine();
                            g.updateGuest(3, name, creditCardNumber);
                            break;
                        case 4:
                            System.out.println("\nPlease input new address: ");
                            address = sc.nextLine();
                            g.updateGuest(4, name, address);
                            break;
                        case 5:
                            System.out.println("\nPlease input a new country: ");
                            country = sc.nextLine();

                            if (country.equals("") || !country.matches(alpha)) {
                                System.out.println("\nInvalid country");
                            }
                            g.updateGuest(5, name, country);
                            break;

                        case 6:
                            System.out.println("\nPlease input contact number: ");
                            contactNumber = sc.nextInt();
                            sc.nextLine();
                            g.updateGuest(6, name, String.valueOf(contactNumber));
                            break;
                        default:
                            System.out.println("Please enter a valid number!");
                            break;
                    }
                    break;
                case 4: // print entire guest list
                    sc.nextLine();
                    System.out.println("\n---Guest List---");
                    g.retrieveGuestList();
                    break;
                case 5: // print specific guest details
                    sc.nextLine();
                    System.out.println("\n---Guest's details---");
                    do {
                        System.out.print("Please enter name of guest to search: ");
                        name = sc.nextLine();
                    } while (g.retrieveGuestDetails(name) == null);
                    g.printGuest(g.retrieveGuestDetails(name));
                    break;
                case 6:
                    sc.nextLine();
                    System.exit(0);
                    break;
                    /* for minimal info guest registration (needed for reservation?)
                case 7:
                    sc.nextLine();
                    Integer Rcode = 0;
                    String Rname = "";
                    Integer RcontactNumber = 0;
                    String Remail = "";
                    String Ralpha = "[a-zA-Z.*\\s+.]+";
                    System.out.println("Please input a valid name: ");
                    name = sc.nextLine();

                    if (Rname.equals("") || !Rname.matches(Ralpha)) {
                        System.out.println("Invalid name");
                    }

                    System.out.println("Please input contact number: ");
                    RcontactNumber = sc.nextInt();

                    System.out.println("Please input email address: ");
                    sc.nextLine();
                    Remail = sc.nextLine();
                    g.reserveGuest(Rcode,Rname,RcontactNumber,Remail);
                    */
                default:
                    sc.nextLine();
                    System.out.println("Please enter a valid number!");
                    break;
            }
        } while (true);
    }
}
