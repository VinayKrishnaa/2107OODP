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
            Boolean multipleCount  = false;
            int index = 0;
            int searchIndex = -1;
            int duplicate = -1;
            String newName = "";

            // validation
            String alpha = "[a-zA-Z.*\\s+.]+";
            String digit = "\\d+";
            String cc = "\\d{4}\\-\\d{4}\\-\\d{4}\\-\\d{4}";

            System.out.println("Please select your option");
            System.out.println("(1) Add a guest");
            System.out.println("(2) Update a reserved guest");
            System.out.println("(3) Update guest details");
            System.out.println("(4) Print entire guest list");
            System.out.println("(5) Search and print a guest detail");
            System.out.println("(6) Search guest by keyword");
            System.out.println("(7) Exit");
            System.out.println("Your input:");
            switch (sc.nextInt()) {
                case 1: // add a guest
                    sc.nextLine();
                    System.out.println("\n---Guest Registration---");

                    do {
                        System.out.print("\nPlease input a valid name: ");
                        name = sc.nextLine();

                        if (name.equals("") || !name.matches(alpha)) {
                            System.out.println("Invalid name");
                        }
                    } while (name.equals("") || !name.matches(alpha));

                    do {
                        System.out.print("\nPlease input a country: ");
                        country = sc.nextLine();

                        if (country.equals("") || !country.matches(alpha)) {
                            System.out.println("Invalid country");
                        }
                    } while (country.equals("") || !country.matches(alpha));

                    do {
                        System.out.print("Please key in '1' or '2' for Gender: ");
                        System.out.println("(1) Male (2) Female ");
                        if (sc.hasNextInt()){
                            genderSelection = sc.nextInt();
                            sc.nextLine();
                        } else {
                            System.out.println("Invalid input detected");
                        }
                        if (genderSelection != 1 && genderSelection != 2) {
                            System.out.println("Invalid choice");
                            sc.nextLine();
                        }
                    } while (genderSelection != 1 && genderSelection != 2 || genderSelection == 0);

                    if (genderSelection == 1){
                        gender = "Male";
                    }
                    else if (genderSelection == 2){
                        gender = "Female";
                    }

                    do {
                        System.out.println("Please key in '1' or '2' for: ");
                        System.out.print("Identity Type - (1) Driving License (2) Passport: ");
                        if (sc.hasNextInt()){
                            identitySelection = sc.nextInt();
                            sc.nextLine();
                        } else {
                            System.out.println("Invalid input detected");
                        }
                        if (identitySelection != 1 && identitySelection != 2) {
                            System.out.println("Invalid choice");
                            sc.nextLine();
                        }
                    } while (identitySelection != 1 && identitySelection != 2);

                    if (identitySelection == 1) {
                        do {
                            System.out.print("Driving License: ");
                            lic = sc.nextLine();
                            identity = false;
                            identityInfo = lic;

                            if (lic.equals("")) {
                                System.out.println("Invalid license");
                            }
                        } while (lic.equals(""));

                    } else if (identitySelection == 2) {
                        do {
                            System.out.print("Passport Number: ");
                            pp = sc.nextLine();
                            identity = true;
                            identityInfo = pp;

                            if (pp.equals("")) {
                                System.out.println("Invalid passport");
                            }
                        } while (pp.equals(""));
                    }

                    do {
                        System.out.println("Please input contact number: ");
                        if (sc.hasNextInt()){
                            contactNumber = sc.nextInt();
                            sc.nextLine();
                        } else {
                            System.out.println("Invalid input detected");
                        }
                        if (contactNumber == 0) {
                            System.out.println("Invalid number");
                            sc.nextLine();
                        }
                    } while (contactNumber == 0);

                    do {
                        System.out.println("Please input address: ");
                        address = sc.nextLine();
                        if (address.equals("")) {
                            System.out.println("Invalid address");
                        }
                    } while (address.equals(""));

                    do {
                        System.out.println("Please input Reservation code: ");
                        if (sc.hasNextInt()){
                            rcode = sc.nextInt();
                            sc.nextLine();
                        } else {
                            System.out.println("Invalid input detected");
                            sc.nextLine();
                        }
                        if (rcode == 0){
                            System.out.println("Invalid Reservation code");
                        }
                    } while (rcode == 0);

                    do {
                        System.out.println("Please input credit card number(Format: XXXX-XXXX-XXXX-XXXX): ");
                        creditCardNumber = sc.nextLine();
                        if (creditCardNumber.equals("") || !creditCardNumber.matches(cc)) {
                            System.out.println("Invalid credit card number");
                        }
                    } while (creditCardNumber.equals("") || !creditCardNumber.matches(cc));

                    do {
                        System.out.println("Please input email address: ");
                        email = sc.nextLine();
                        if (email.equals("")) {
                            System.out.println("Invalid email address");
                        }
                    } while (email.equals(""));

                    do {
                        System.out.println("Please input age: ");
                        if (sc.hasNextInt()) {
                            age = sc.nextInt();
                            sc.nextLine();
                        } else {
                            System.out.println("Invalid input detected");
                        }
                        if (age == 0){
                            System.out.println("Invalid age");
                            sc.nextLine();
                        }
                    } while (age == 0);

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

                    do {
                        System.out.print("\nPlease input a country: ");
                        country = sc.nextLine();

                        if (country.equals("") || !country.matches(alpha)) {
                            System.out.println("Invalid country");
                        }
                    } while (country.equals("") || !country.matches(alpha));

                    do {
                        System.out.print("Please key in '1' or '2' for Gender: ");
                        System.out.println("(1) Male (2) Female ");
                        if (sc.hasNextInt()){
                            genderSelection = sc.nextInt();
                            sc.nextLine();
                        } else {
                            System.out.println("Invalid input detected");
                        }
                        if (genderSelection != 1 && genderSelection != 2) {
                            System.out.println("Invalid choice");
                            sc.nextLine();
                        }
                    } while (genderSelection != 1 && genderSelection != 2 || genderSelection == 0);

                    if (genderSelection == 1){
                        gender = "Male";
                    }
                    else if (genderSelection == 2){
                        gender = "Female";
                    }

                    do {
                        System.out.println("Please key in '1' or '2' for: ");
                        System.out.print("Identity Type - (1) Driving License (2) Passport: ");
                        if (sc.hasNextInt()){
                            identitySelection = sc.nextInt();
                            sc.nextLine();
                        } else {
                            System.out.println("Invalid input detected");
                        }
                        if (identitySelection != 1 && identitySelection != 2) {
                            System.out.println("Invalid choice");
                            sc.nextLine();
                        }
                    } while (identitySelection != 1 && identitySelection != 2);

                    if (identitySelection == 1) {
                        do {
                            System.out.print("Driving License: ");
                            lic = sc.nextLine();
                            identity = false;
                            identityInfo = lic;

                            if (lic.equals("")) {
                                System.out.println("Invalid license");
                            }
                        } while (lic.equals(""));

                    } else if (identitySelection == 2) {
                        do {
                            System.out.print("Passport Number: ");
                            pp = sc.nextLine();
                            identity = true;
                            identityInfo = pp;

                            if (pp.equals("")) {
                                System.out.println("Invalid passport");
                            }
                        } while (pp.equals(""));
                    }

                    do {
                        System.out.println("Please input address: ");
                        address = sc.nextLine();
                        if (address.equals("")) {
                            System.out.println("Invalid address");
                        }
                    } while (address.equals(""));

                    do {
                        System.out.println("Please input credit card number(Format: XXXX-XXXX-XXXX-XXXX): ");
                        creditCardNumber = sc.nextLine();
                        if (creditCardNumber.equals("") || !creditCardNumber.matches(cc)) {
                            System.out.println("Invalid credit card number");
                        }
                    } while (creditCardNumber.equals("") || !creditCardNumber.matches(cc));

                    do {
                        System.out.println("Please input age: ");
                        if (sc.hasNextInt()) {
                            age = sc.nextInt();
                            sc.nextLine();
                        } else {
                            System.out.println("Invalid input detected");
                        }
                        if (age == 0){
                            System.out.println("Invalid age");
                            sc.nextLine();
                        }
                    } while (age == 0);

                    g.updateReserveGuest(name, country, gender, identity, identityInfo,
                            address, creditCardNumber, age);
                    break;
                case 3: // update specific guest details
                    sc.nextLine();
                    System.out.println("\n---Updating Guest detail---");
                    do {
                        duplicate = -1;
                        System.out.print("Please enter name of guest to update: ");
                        name = sc.nextLine();
                        duplicate = g.searchGuest(name);
                        searchIndex = duplicate;

                        if (duplicate == -1){
                            System.out.println("\nNo names found, please check input.");
                        }
                    } while (duplicate == -1);

                    if (duplicate == -2){
                        do {
                            System.out.print("\nIndex Number: ");
                            if (sc.hasNextInt()) {
                                searchIndex = sc.nextInt();
                                sc.nextLine();
                            } else {
                                System.out.println("Invalid input detected");
                            }
                        } while (searchIndex < 0);
                    }

                    do {
                        System.out.print("Please select guest details to update - \n(1) Name (2) Gender (3) Credit Card (4) Address (5) Country (6) Contact No. : ");
                        if (sc.hasNextInt()) {
                            updateType = sc.nextInt();
                            sc.nextLine();
                        }
                        else {
                            System.out.println("Invalid input detected");
                        }
                        if (updateType == 0){
                            System.out.println("Invalid input detected");
                            sc.nextLine();
                        }
                    } while (updateType == 0);

                    switch (updateType) {
                        case 1:
                            do {
                                System.out.print("\nNew Guest Name: ");
                                newName = sc.nextLine();

                                if (newName.equals("") || !newName.matches(alpha)) {
                                    System.out.println("\nInvalid name");
                                }
                            } while (newName.equals("") || !newName.matches(alpha));

                            g.updateGuest(1, searchIndex, newName);
                            break;
                        case 2:
                            do {
                                System.out.print("Please key in '1' or '2' for Gender: ");
                                System.out.println("(1) Male (2) Female ");
                                if (sc.hasNextInt()){
                                    genderSelection = sc.nextInt();
                                    sc.nextLine();
                                } else {
                                    System.out.println("Invalid input detected");
                                }
                                if (genderSelection != 1 && genderSelection != 2) {
                                    System.out.println("Invalid choice");
                                    sc.nextLine();
                                }
                            } while (genderSelection != 1 && genderSelection != 2 || genderSelection == 0);

                            if (genderSelection != 1 && genderSelection != 2) {
                                System.out.println("\nInvalid choice");
                            }

                            if (genderSelection == 1) {
                                gender = "Male";
                            } else if (genderSelection == 2) {
                                gender = "Female";
                            }

                            g.updateGuest(2, searchIndex, gender);
                            break;
                        case 3:
                            do {
                                System.out.println("Please input credit card number(Format: XXXX-XXXX-XXXX-XXXX): ");
                                creditCardNumber = sc.nextLine();
                                if (creditCardNumber.equals("") || !creditCardNumber.matches(cc)) {
                                    System.out.println("Invalid credit card number");
                                }
                            } while (creditCardNumber.equals("") || !creditCardNumber.matches(cc));

                            g.updateGuest(3, searchIndex, creditCardNumber);
                            break;
                        case 4:
                            do {
                                System.out.println("Please input address: ");
                                address = sc.nextLine();
                                if (address.equals("")) {
                                    System.out.println("Invalid address");
                                }
                            } while (address.equals(""));

                            g.updateGuest(4, searchIndex, address);
                            break;
                        case 5:
                            do {
                                System.out.print("\nPlease input a country: ");
                                country = sc.nextLine();

                                if (country.equals("") || !country.matches(alpha)) {
                                    System.out.println("Invalid country");
                                }
                            } while (country.equals("") || !country.matches(alpha));

                            g.updateGuest(5, searchIndex, country);
                            break;
                        case 6:
                            do {
                                System.out.println("Please input contact number: ");
                                if (sc.hasNextInt()){
                                    contactNumber = sc.nextInt();
                                    sc.nextLine();
                                } else {
                                    System.out.println("Invalid input detected");
                                }
                                if (contactNumber == 0) {
                                    System.out.println("Invalid number");
                                    sc.nextLine();
                                }
                            } while (contactNumber == 0);

                            g.updateGuest(6, searchIndex, String.valueOf(contactNumber));
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
                        duplicate = -1;
                        System.out.print("Please enter name of guest to search: ");
                        name = sc.nextLine();
                        duplicate = g.searchGuest(name);
                        searchIndex = duplicate;

                        if (duplicate == -1){
                            System.out.println("\nNo names found, please check input.");
                        }
                    } while (duplicate == -1);

                    if (duplicate == -2){
                        do {
                            System.out.print("\nIndex Number: ");
                            if (sc.hasNextInt()) {
                                searchIndex = sc.nextInt();
                                sc.nextLine();
                            } else {
                                System.out.println("Invalid input detected");
                            }
                        } while (searchIndex < 0);
                    }
                    g.printGuest(g.getGuestByIndex(searchIndex));
                    break;
                case 6: // search guest by keywords
                    sc.nextLine();
                    System.out.println("\n---Searching by name keyword---");
                    do {
                        System.out.print("Please enter name of guest to search: ");
                        name = sc.nextLine();
                        multipleCount = g.searchGuestKeyword(name);
                        if (multipleCount == null){
                            System.out.println("Please enter a valid name!");
                        }
                    } while (multipleCount == null);
                    if (multipleCount == true) {
                        do {
                            System.out.print("\nIndex Number: ");
                            if (sc.hasNextInt()) {
                                index = sc.nextInt();
                                sc.nextLine();
                            } else {
                                System.out.println("Invalid input detected");
                                sc.nextLine();
                            }
                        } while (index < 0);
                        g.searchGuestByIndex(index);
                    }
                    break;
                case 7:
                    sc.nextLine();
                    System.exit(0);
                    break;

                    /* for minimal info guest registration (needed for reservation?)
                case 8:
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
