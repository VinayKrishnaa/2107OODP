package Controller;

import Class.Guest;
import DB.GuestDB;
import java.util.*;

/*
a. Create/Update/Search guests detail (Search by name using keyword/s)
createGuest
reserveGuest
updateReserveGuest
updateGuest
retrieveGuestDetails
searchGuest
retrieveGuestList
printGuest
getGuestList
searchGuestByKeyword
searchGuest
searchGuestByIndex
getGuestByIndex
 */

public class GuestController {
    ArrayList<Guest> guestList;
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

    // new code
    public void reserveGuest(int rcode, String name, Integer contactNumber, String email){
        try {
            Guest guest = new Guest();
            guest.setName(name);
            guest.setContactNumber(contactNumber);
            guest.setEmail(email);
            guest.setRcode(rcode);

            // set as default values
            String country = "na";
            String gender = "na";
            Boolean identity = false; // false == license | true == passport
            String identityInfo = "na";
            String address = "na";
            String creditCardNumber = "na";
            Integer age = 0;

            guest.setCountry(country);
            guest.setGender(gender);
            guest.setIdentity(identity);
            guest.setIdentityInfo(identityInfo);
            guest.setAddress(address);
            guest.setCreditCardNumber(creditCardNumber);
            guest.setAge(age);

            GuestDB.saveData(filename, guestList);
            guestList.add(guest);
            System.out.println("\nGuest Reservation details added");
        } catch (Exception e){
            System.out.println("\nGuest Reservation error");
        }
    }

    // updated code
    public void updateReserveGuest(String name, String country, String gender, Boolean identity, String identityInfo,
                                   String address, String creditCardNumber, Integer age) {
        try {
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
        } catch (Exception e){
            System.out.println("\nError when updating reserve guest, please check input.");
        }
    }

    // new code
    public void updateGuest(int updateType, int index, String info){
        try {
            Guest updateGuest = new Guest();
            updateGuest = getGuestByIndex(index);
            System.out.println("\n---Update Guest " + updateGuest.getName() + "---");
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
        } catch (Exception e) {
            System.out.println("\nError occurred while updating guest, please check your input");
        }
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
        try {
            System.out.println("\nName: " + guest.getName());
            System.out.println("Country: " + guest.getCountry());
            System.out.println("Gender: " + guest.getGender());
            if (guest.getIdentity() == false) {
                System.out.println("Identity Type: Driving License");
            } else {
                System.out.println("Identity Type: Passport");
            }
            System.out.println("Identity Info: " + guest.getIdentityInfo());
            System.out.println("Contact No: " + guest.getContactNumber());
            System.out.println("Address: " + guest.getAddress());
            System.out.println("Reservation Code: " + guest.getRcode());
            System.out.println("Credit Card Number: " + guest.getCreditCardNumber());
            System.out.println("Email: " + guest.getEmail());
            System.out.println("Age: " + guest.getAge());
        } catch (Exception e){
            System.out.println("\nError while printing guest info.");
        }
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
            alr = GuestDB.readData(guestList);

        } catch (Exception e) {
            System.out.println("Exception > " + e.getMessage());
        }
        return alr;
    }

    public Boolean searchGuestKeyword(String name){
        try {
            int count = 0;
            int index = 0;
            Guest guest = new Guest();
            guest.setName(name);

            for (int i = 0; i < guestList.size(); i++) {
                Guest searchGuest = (Guest) guestList.get(i);

                if (searchGuest.getName().contains(name)) {
                    System.out.print("\nIndex "+ i + ") "+searchGuest.getName());
                    if (searchGuest.getIdentity() == false){
                        System.out.print(" - Driving License: " +searchGuest.getIdentityInfo());
                    }
                    else{
                        System.out.print(" - Passport: " +searchGuest.getIdentityInfo());
                    }
                    count++;
                    index = i;
                }
            }
            // If there's only one name matching
            if (count == 1){
                guest = (Guest) guestList.get(index);
                printGuest(guest);
                return false;
            }
            // If there's multiple name matching, request user to call a different method
            else if (count > 1){
                System.out.println("\n" + count + " Names found");
                System.out.println("Please enter index number to continue");
                return true;
            } else{
                System.out.println("\n" + count + " Names found");
                return false;
            }
        } catch (Exception e) {
            System.out.println("\nError during searching guest by keyword");
        }
        return null;
    }

    public int searchGuest(String name){
        try {
            int count = 0;
            int index = 0;
            Guest guest = new Guest();
            guest.setName(name);

            for (int i = 0; i < guestList.size(); i++) {
                Guest searchGuest = (Guest) guestList.get(i);

                if (searchGuest.getName().equals(name)) {
                    System.out.print("\nIndex "+ i + ") "+searchGuest.getName());
                    if (searchGuest.getIdentity() == false){
                        System.out.print(" - Driving License: " +searchGuest.getIdentityInfo());
                    }
                    else{
                        System.out.println(" - Passport: " +searchGuest.getIdentityInfo());
                    }
                    count++;
                    index = i;
                }
            }
            // If there's only one name matching
            if (count == 1){
                return index;
            }
            // If there's multiple name matching, request user to call a different method
            else if (count > 1){
                System.out.println("\n" + count + " Names found");
                System.out.println("Please enter index number to continue");
                return -2;
            } else {
                System.out.println("\n" + count + " Names found");
                return -1;
            }
        } catch (Exception e) {
            System.out.println("\nError during searching guest");
        }
        return 0;
    }

    public void searchGuestByIndex(int index){
        try {
            Guest guest = new Guest();
            guest = (Guest) guestList.get(index);
            printGuest(guest);
        } catch (Exception e) {
            System.out.println("\nError! Please enter a valid value!");
        }
    }

    // return guest object by index
    public Guest getGuestByIndex(int index){
        try {
            Guest guest = new Guest();
            guest = (Guest) guestList.get(index);
            return guest;
        } catch (Exception e) {
            System.out.println("\nError! Please enter a valid value!");
        }
        return null;
    }
}
