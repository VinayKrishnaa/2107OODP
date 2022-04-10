package Controller;

import Class.Guest;
import DB.GuestDB;
import java.util.*;

/*
a. Create/Update/Search guests detail (Search by name using keyword/s)
createGuest
updateGuest
retrieveGuestDetails
retrieveGuestList
searchGuest
printGuest

create guest for check in
update guest details after check in
 */

public class GuestController {
    ArrayList<Guest> guestList;
    Scanner sc = new Scanner(System.in);
    public static GuestController instance = null;

    public GuestController(){
        guestList = new ArrayList<Guest>();
    }

    // read from file
    private GuestDB guestDB = new GuestDB();
    private String filename = "guest.txt";

    public static GuestController createInstance() {
        if (instance == null)
            instance = new GuestController();
        return instance;
    }

    // old code
    public void createGuest(){
        String name = "";
        String country = "";
        String gender = "";
        Boolean identity = false; // false == license | true == passport
        String identityInfo = "";
        Integer contactNumber = 0;
        String address = "";
        Integer rcode = 0; // get from menu UI roomid (passed in as variable) tbd get the RCODE instead.
        //Date checkInDate; // no check in
        //Boolean mainGuest = false;
        String creditCardNumber = "";
        String email = "";
        Integer age = 0;

        Integer genderSelection = 0;
        Integer identitySelection = 0;
        //Integer mainGuestSelection = 0;
        String lic = "";
        String pp = "";
        //Integer year = 0;
        //Integer month = 0;
        //Integer day = 0;
        // Date in;

        // validation
        String alpha = "[a-zA-Z.*\\s+.]+";

        Guest guest = new Guest();

        System.out.println("\n---Guest Registration---");

        try{
            System.out.println("\nPlease input a valid name: ");
            name = sc.nextLine();

            if (name.equals("") || !name.matches(alpha)) {
                throw new RuntimeException("\nInvalid name");
            }

            System.out.println("\nPlease input a country: ");
            country = sc.nextLine();

            if (country.equals("") || !country.matches(alpha)) {
                throw new RuntimeException("\nInvalid country");
            }

            System.out.println("\nGender: ");
            System.out.print("(1) Male (2) Female ");
            genderSelection = sc.nextInt();
            sc.nextLine();

            if (genderSelection != 1 && genderSelection != 2) {
                throw new RuntimeException("\nInvalid choice");
            }

            if (genderSelection == 1){
                gender = "Male";
            }
            else if (genderSelection == 2){
                gender = "Female";
            }

            System.out.println("\nPlease input a identity type: ");
            System.out.print("Identity Type - (1) Driving License (2) Passport: ");
            identitySelection = sc.nextInt();
            sc.nextLine();

            if (identitySelection != 1 && identitySelection != 2) {
                throw new RuntimeException("\nInvalid choice");
            }

            if (identitySelection == 1){
                System.out.print("\nDriving License: ");
                lic = sc.nextLine();
                identity = false;
                identityInfo = lic;

                if (lic.equals("")){
                    throw new RuntimeException("\nInvalid license");
                }

            }
            else if (identitySelection == 2) {
                System.out.print("\nPassport Number: ");
                pp = sc.nextLine();
                identity = true;
                identityInfo = pp;

                if (pp.equals("")){
                    throw new RuntimeException("\nInvalid passport");
                }
            }

            System.out.println("\nPlease input contact number: ");
            contactNumber = sc.nextInt();
            sc.nextLine();

            System.out.println("\nPlease input address: ");
            address = sc.nextLine();

            System.out.println("\nPlease input rcode: ");
            rcode = sc.nextInt();
            sc.nextLine();

            /*
            System.out.println("\nIs the customer the main guest? ");
            System.out.print("(1) Yes (2) No: ");
            mainGuestSelection= sc.nextInt();
            sc.nextLine();

            if (mainGuestSelection != 1 && mainGuestSelection != 2) {
                throw new RuntimeException("\nInvalid choice");
            }

            if (mainGuestSelection == 1){
                mainGuest = true;
            }
            else if (mainGuestSelection == 2){
                mainGuest = false;
            }
            */

            //System.out.println("\nPlease input check in date: ");
            //System.out.println("\nEnter the Check in Year: ");
            //year = sc.nextInt();
            //System.out.println("\nEnter the Check in Month (Numeric): ");
            //month = sc.nextInt();
            //System.out.println("\nEnter the Check in day: ");
            //day = sc.nextInt();
            //Calendar inc = new GregorianCalendar(year, month, day);
            //checkInDate = inc.getTime();

            System.out.println("\nPlease input credit card number: ");
            creditCardNumber = sc.nextLine();

            System.out.println("\nPlease input email address: ");
            email = sc.nextLine();

            System.out.println("\nPlease input age: ");
            age = sc.nextInt();
            sc.nextLine();

            guest.setName(name);
            guest.setCountry(country);
            guest.setGender(gender);
            guest.setIdentity(identity);
            guest.setIdentityInfo(identityInfo);
            guest.setContactNumber(contactNumber);
            guest.setAddress(address);
            guest.setRcode(rcode);
            guest.setCreditCardNumber(creditCardNumber);
            guest.setEmail(email);
            guest.setAge(age);

            // write to file?
            //GuestDB.saveGuest(filename, alr);
            GuestDB.saveData(filename,guestList);
            guestList.add(guest);
            System.out.println("New guest details has been successfully saved!");

        } catch(Exception e){
            System.out.println("\nDetails entered incorrectly");
        }
    }

    // updated code
    public void createGuest(String name, String country, String gender, Boolean identity, String identityInfo,
                            Integer contactNumber, String address, Integer rcode, String creditCardNumber,
                            String email, Integer age){
        Guest guest = new Guest();

        guest.setName(name);
        guest.setCountry(country);
        guest.setGender(gender);
        guest.setIdentity(identity);
        guest.setIdentityInfo(identityInfo);
        guest.setContactNumber(contactNumber);
        guest.setAddress(address);
        guest.setRcode(rcode);
        guest.setCreditCardNumber(creditCardNumber);
        guest.setEmail(email);
        guest.setAge(age);

        GuestDB.saveData(filename,guestList);
        guestList.add(guest);
        System.out.println("New guest details has been successfully saved!");
    }

    // old code
    public void reserveGuest(int rcode){
        String name = "";
        Integer contactNumber = 0;
        //Integer rcode = 0;
        String email = "";

        // validation
        String alpha = "[a-zA-Z.*\\s+.]+";

        Guest guest = new Guest();
        System.out.println("\n---Reservation Guest Registration---");

        try {
            System.out.println("\nPlease input a valid name: ");
            name = sc.nextLine();

            if (name.equals("") || !name.matches(alpha)) {
                throw new RuntimeException("\nInvalid name");
            }

            System.out.println("\nPlease input contact number: ");
            contactNumber = sc.nextInt();

            System.out.println("\nPlease input email address: ");
            sc.nextLine();
            email = sc.nextLine();


            guest.setName(name);
            guest.setContactNumber(contactNumber);
            guest.setEmail(email);
            guest.setRcode(rcode);

            guestList.add(guest);

            System.out.println("\nGuest Reservation details added");

        } catch(Exception e){
            System.out.println("\nDetails entered incorrectly");
        }
    }

    // new code
    public void reserveGuest(int rcode, String name, Integer contactNumber, String email){
        Guest guest = new Guest();
        guest.setName(name);
        guest.setContactNumber(contactNumber);
        guest.setEmail(email);
        guest.setRcode(rcode);
        guestList.add(guest);
        System.out.println("\nGuest Reservation details added");
    }

    // old code
    public void updateReserveGuest(){
        String country = "";
        String gender = "";
        Boolean identity = false; // false == license | true == passport
        String identityInfo = "";
        String address = "";
        String creditCardNumber = "";
        Integer age = 0;

        Integer genderSelection = 0;
        Integer identitySelection = 0;
        String lic = "";
        String pp = "";

        // validation
        String alpha = "[a-zA-Z.*\\s+.]+";

        Guest updateGuest = new Guest();
        updateGuest = retrieveGuestDetails();

        System.out.println("\n---Guest Registration---");
        System.out.println("\n---Updating "+updateGuest.getName() +"---");
        System.out.println(updateGuest.getEmail() + updateGuest.getContactNumber());

        try{

            System.out.println("\nPlease input a country: ");
            country = sc.nextLine();

            if (country.equals("") || !country.matches(alpha)) {
                throw new RuntimeException("\nInvalid country");
            }

            System.out.println("\nGender: ");
            System.out.print("(1) Male (2) Female ");
            genderSelection = sc.nextInt();
            sc.nextLine();

            if (genderSelection != 1 && genderSelection != 2) {
                throw new RuntimeException("\nInvalid choice");
            }

            if (genderSelection == 1){
                gender = "Male";
            }
            else if (genderSelection == 2){
                gender = "Female";
            }

            System.out.println("\nPlease input a identity type: ");
            System.out.print("Identity Type - (1) Driving License (2) Passport: ");
            identitySelection = sc.nextInt();
            sc.nextLine();

            if (identitySelection != 1 && identitySelection != 2) {
                throw new RuntimeException("\nInvalid choice");
            }

            if (identitySelection == 1){
                System.out.print("\nDriving License: ");
                lic = sc.nextLine();
                identity = false;
                identityInfo = lic;

                if (lic.equals("")){
                    throw new RuntimeException("\nInvalid license");
                }

            }
            else if (identitySelection == 2) {
                System.out.print("\nPassport Number: ");
                pp = sc.nextLine();
                identity = true;
                identityInfo = pp;

                if (pp.equals("")){
                    throw new RuntimeException("\nInvalid passport");
                }
            }

            System.out.println("\nPlease input address: ");
            address = sc.nextLine();

            /*
            System.out.println("\nIs the customer the main guest? ");
            System.out.print("(1) Yes (2) No: ");
            mainGuestSelection= sc.nextInt();
            sc.nextLine();

            if (mainGuestSelection != 1 && mainGuestSelection != 2) {
                throw new RuntimeException("\nInvalid choice");
            }

            if (mainGuestSelection == 1){
                mainGuest = true;
            }
            else if (mainGuestSelection == 2){
                mainGuest = false;
            }
             */

            System.out.println("\nPlease input credit card number: ");
            creditCardNumber = sc.nextLine();


            System.out.println("\nPlease input age: ");
            age = sc.nextInt();
            sc.nextLine();

            updateGuest.setCountry(country);
            updateGuest.setGender(gender);
            updateGuest.setIdentity(identity);
            updateGuest.setIdentityInfo(identityInfo);
            updateGuest.setAddress(address);
            //updateGuest.setMainGuest(mainGuest);
            updateGuest.setCreditCardNumber(creditCardNumber);
            updateGuest.setAge(age);

            // write to file?
            GuestDB.saveData(filename, guestList);
            //guestList.add(updateGuest);
            System.out.println("New guest details has been successfully saved!");

        } catch(Exception e){
            System.out.println("\nDetails entered incorrectly");
        }
    }

    // updated code
    public void updateReserveGuest(String name, String country, String gender, Boolean identity, String identityInfo,
                                   String address, String creditCardNumber, Integer age) {
        Guest updateGuest = new Guest();
        updateGuest = retrieveGuestDetails(name);
        updateGuest.setCountry(country);
        updateGuest.setGender(gender);
        updateGuest.setIdentity(identity);
        updateGuest.setIdentityInfo(identityInfo);
        updateGuest.setAddress(address);
        updateGuest.setCreditCardNumber(creditCardNumber);
        updateGuest.setAge(age);
        GuestDB.saveData(filename, guestList);
        System.out.println("New guest details has been successfully saved!");
    }

    // old code
    public void updateGuest(){
        String name = "";
        String country = "";
        String gender = "";
        Boolean identity = false; // false == license | true == passport
        String identityInfo = "";
        Integer contactNumber = 0;
        String address = "";
        Integer rcode = 0;
        Boolean mainGuest = false;
        String creditCardNumber = "";
        String email = "";
        Integer age = 0;

        Integer genderSelection = 0;
        Integer identitySelection = 0;
        String lic = "";
        String pp = "";
        Integer year = 0;
        Integer month = 0;
        Integer day = 0;
        // Date in;

        int updateType = 0;

        // validation
        String alpha = "[a-zA-Z.*\\s+.]+";

        Guest updateGuest = new Guest();
        updateGuest = retrieveGuestDetails();

        System.out.println("\n---Update Guest "+updateGuest.getName() +"---");

        System.out.print("\nPlease select guest details to update - \n(1) Name (2) Gender (3) Credit Card (4) Address (5) Country (6) Contact No. : ");
        updateType = sc.nextInt();
        sc.nextLine();

        switch (updateType){
            case 1:
                System.out.print("\nCurrent guest name: " +updateGuest.getName());
                System.out.print("\nNew Guest Name: ");
                name = sc.nextLine();

                // validation if needed (test)
                if (name.equals("") || !name.matches(alpha)) {
                    System.out.println("\nInvalid name");
                }
                else if ((name.equals(updateGuest.getName()))){
                    System.out.println("Error - Current name and new name is the same");
                }
                else {
                    updateGuest.setName(name);
                }
                break;

            case 2:
                System.out.println("\nNew Gender: ");
                System.out.print("(1) Male (2) Female ");
                genderSelection = sc.nextInt();
                sc.nextLine();

                if (genderSelection != 1 && genderSelection != 2) {
                    System.out.println("\nInvalid choice");
                }

                if (genderSelection == 1){
                    gender = "Male";
                }
                else if (genderSelection == 2){
                    gender = "Female";
                }
                updateGuest.setGender(gender);
                break;

            case 3:
                System.out.println("\nPlease input new credit card number: ");
                creditCardNumber = sc.nextLine();
                updateGuest.setCreditCardNumber(creditCardNumber);
                break;

            case 4:
                System.out.println("\nPlease input new address: ");
                address = sc.nextLine();
                updateGuest.setAddress(address);
                break;

            case 5:
                System.out.println("\nPlease input a new country: ");
                country = sc.nextLine();

                if (country.equals("") || !country.matches(alpha)) {
                    System.out.println("\nInvalid country");
                }
                updateGuest.setCountry(country);
                break;

            case 6:
                System.out.println("\nPlease input contact number: ");
                contactNumber = sc.nextInt();
                sc.nextLine();
                updateGuest.setContactNumber(contactNumber);
                break;
        }
        System.out.println("\n---Guest details successfully updated---");
        GuestDB.saveData(filename, guestList);

    }

    // new code
    public void updateGuest(int updateType, String name, String info){
        Guest updateGuest = new Guest();
        updateGuest = retrieveGuestDetails(name);
        System.out.println("\n---Update Guest "+updateGuest.getName() +"---");
        switch (updateType) {
            case 1:
                updateGuest.setName(info);
                break;
            case 2:
                updateGuest.setGender(info);
                break;
            case 3:
                updateGuest.setCreditCardNumber(info);
                break;
            case 4:
                updateGuest.setAddress(info);
                break;
            case 5:
                updateGuest.setCountry(info);
                break;
            case 6:
                updateGuest.setContactNumber(Integer.parseInt(info));
                break;
        }
        System.out.println("\n---Guest details successfully updated---");
        GuestDB.saveData(filename, guestList);
    }

    /**
     * Prompt retrieval of guest's details by name (old)
     *
     * @return guest details.
     */
    public Guest retrieveGuestDetails(){
        String name = "null";

        Guest guest = new Guest();
        Guest checkGuest = new Guest();

        do {

            System.out.print("\nPlease enter name of guest to search: ");
            name = sc.nextLine();
            guest.setName(name);

            checkGuest = searchGuest(guest);

            if (checkGuest == null) {
                System.out.println("\nError - Please enter a valid name");
            }
        } while(checkGuest == null);

        // debug
        System.out.println("\nSearch successful for check guest:" +checkGuest.getName());

        return checkGuest;
    }

    /**
     * Prompt retrieval of guest's details by name (new)
     * @param name
     *
     * @return guest details.
     */
    public Guest retrieveGuestDetails(String name){
        Guest guest = new Guest();
        Guest checkGuest = new Guest();
        guest.setName(name);
        checkGuest = searchGuest(guest);

        if (checkGuest == null) {
            System.out.println("\nError - Please enter a valid name");
        }

        return checkGuest;
    }

    /**
     * Retrieval of specific guest by name.
     *
     * @param guest
     *            Parameter to search for guest details.
     * @return guest if found else return null.
     */
    public Guest searchGuest(Guest guest){
        try {
            for (int i = 0; i < guestList.size(); i++) {
                Guest searchGuest = (Guest) guestList.get(i);
                // debug
                //System.out.println("\nsearchGuest "+searchGuest.getName());

                if (guest.getName().equals(searchGuest.getName())) {
                    guest = searchGuest;
                    return guest;
                }
            }
        } catch (Exception e) {
            System.out.println("\nError during searchGuest");
        }
        return null;
    }

    /**
     * Prints the list of guests
     *
     */
    public void retrieveGuestList(){
        //System.out.println(guestList.size());
        int index = 0;
        for (index = 0; index < guestList.size(); index++) {
            System.out.println("No " + index + ": " + guestList.get(index).getName());
        }
    }

    /**
     * Display of guest details.
     *
     * @param guest
     *            Details of guest to display.
     */
    public void printGuest(Guest guest){
        System.out.println("Name: " + guest.getName());
        System.out.println("Country: " + guest.getCountry());
        System.out.println("Gender: " + guest.getGender());
        if (guest.getIdentity() == false){
            System.out.println("Identity Type: Driving License");
        }
        else{
            System.out.println("Identity Type: Passport");
        }
        System.out.println("Identity Info: " + guest.getIdentityInfo());
        System.out.println("Contact No: " + guest.getContactNumber());
        System.out.println("Address: " + guest.getAddress());
        System.out.println("Reservation Code: " + guest.getRcode());
        System.out.println("Credit Card Number: " + guest.getCreditCardNumber());
        System.out.println("Email: " + guest.getEmail());
        System.out.println("Age: " + guest.getAge());
    }

    /**
     * Retrieval of guest details.
     *
     * @return arraylist of all guests.
     */
    public ArrayList getGuestList() {
        ArrayList alr = null;
        try {
            // read file containing Guest records
            //alr = GuestDB.readData(filename);
            alr = GuestDB.readData(guestList);

        } catch (Exception e) {
            System.out.println("Exception > " + e.getMessage());
        }
        return alr;
    }
}
