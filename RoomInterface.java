import java.util.Scanner;
import java.util.*;


public class RoomInterface {
    public static void main(String[] args) throws Exception {
        RoomController RoomController = new RoomController();

        int user_choice;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("--------------------------------------");
            System.out.println("Welcome to the Room Management Interface");
            System.out.println("(1) Creating Hotel");
            System.out.println("(2) Updating Room Attributes");
            System.out.println("(3) QuickCheck: Room Status");
            System.out.println("(4) Find Room by Room Number");
            System.out.println("(5) Check Room Vacancies by Room Types");
            System.out.println("(6) Occupancy Rate Report");
            System.out.println("(7) Room Status Report");
            System.out.println("(8) Exit");
            System.out.println("--------------------------------------");

            System.out.println("Enter the number of your choice: ");

            user_choice = sc.nextInt();

            switch(user_choice){
                case 1:
                    System.out.println("Creating Wonderful Rooms.....");
                    RoomController.createWonderfulRoom(100,40,0,0,
                                                        false, false, "Hotel", false,
                                                        false, 0, 0, 2);
                    RoomController.createWonderfulRoom(101,40,0,0,
                            false, false, "Hotel", false,
                            false, 0, 0, 2);
                    RoomController.createWonderfulRoom(102,40,0,0,
                            false, true, "Hotel", false,
                            false, 0, 0, 2);
                    RoomController.createWonderfulRoom(103,40,0,0,
                            false, true, "Hotel", false,
                            false, 0, 0, 2);
                    RoomController.createWonderfulRoom(104,40,0,1,
                            true, true, "Hotel", false,
                            false, 0, 0, 3);
                    RoomController.createWonderfulRoom(105,40,0,1,
                            true, false, "Garden", true,
                            true, 0, 0, 3);
                    RoomController.createWonderfulRoom(106,40,0,1,
                            true, false, "Garden", true,
                            true, 0, 0, 3);
                    RoomController.createWonderfulRoom(107,40,0,1,
                            true, false, "Garden", true,
                            true, 0, 0, 3);
                    System.out.println("Wonderful Rooms Created.");

                    System.out.println("Creating Spectacular Rooms.....");
                    RoomController.createSpectacularRoom(200,50,0,1,
                            true, true, "Garden", true,
                            false, 0, 0, 3);
                    RoomController.createSpectacularRoom(201,50,0,1,
                            true, true, "Garden", true,
                            false, 0, 0, 3);
                    RoomController.createSpectacularRoom(202,50,0,1,
                            true, false, "Garden", true,
                            false, 0, 0, 3);
                    RoomController.createSpectacularRoom(203,50,0,2,
                            true, false, "Hotel", false,
                            false, 0, 0, 4);
                    RoomController.createSpectacularRoom(204,50,0,2,
                            true, false, "Hotel", false,
                            true, 0, 0, 4);
                    RoomController.createSpectacularRoom(205,50,0,2,
                            true, false, "Hotel", false,
                            true, 0, 0, 4);
                    RoomController.createSpectacularRoom(206,50,0,2,
                            true, false, "Marina", true,
                            true, 0, 0, 4);
                    System.out.println("Spectacular Rooms Created.");

                    System.out.println("Creating Fabulous Rooms.....");
                    RoomController.createFabulousRoom(300,62,0,2,
                            true, true, "Sea", true,
                            true, 0, 0, 4);
                    RoomController.createFabulousRoom(301,62,0,2,
                            true, false, "Marina", true,
                            true, 0, 0, 3);
                    RoomController.createFabulousRoom(302,62,0,3,
                            true, false, "Sea", true,
                            true, 0, 0, 5);
                    RoomController.createFabulousRoom(303,62,0,3,
                            true, false, "Marina", true,
                            true, 0, 0, 5);
                    System.out.println("Fabulous Rooms Created.");

                    System.out.println("Creating Away Rooms.....");
                    RoomController.createAwayRoom(400,75,0,3,
                            true, true, "Sea", true,
                            true, 0, 0, 6, 1, false);
                    RoomController.createAwayRoom(401,75,0,3,
                            true, false, "Sea", true,
                            true, 0, 0, 6, 1,true);
                    RoomController.createAwayRoom(402,75,0,3,
                            true, false, "Marina", true,
                            true, 0, 0, 6,2,true);
                    System.out.println("Away Rooms Created.");

                    System.out.println("Creating Suite Rooms.....");
                    RoomController.createSuiteRoom(500,85,0,3,
                            true, true, "Marina", true,
                            true, 0, 0, 8, 3,true);
                    RoomController.createSuiteRoom(501,85,0,3,
                            true, false, "Marina", true,
                            true, 0, 0, 8,3,true);
                    System.out.println("Suite Rooms Created.");
                    break;



                case 2:
                    int confirmation;
                    int roomID;
                    boolean flag = true;
                    do {
                        System.out.println("Enter the room number to update: ");
                        roomID = sc.nextInt();
                        if (roomID<100 ||  roomID > 503) throw new Exception("Room does not exist.");
                        System.out.println();
                        System.out.println("--------------------------------------");
                        System.out.println("============= UPDATE MENU ============");
                        System.out.println("Room Number recorded. Choose one of the following attributes to update:");
                        System.out.println("(1) Update Room Number");
                        System.out.println("(2) Update Room Size");
                        System.out.println("(3) Update Room Status");
                        System.out.println("(4) Update Bedding Type");
                        System.out.println("(5) Update WIFI Availability");
                        System.out.println("(6) Update Smoking Availability");
                        System.out.println("(7) Update Room View");
                        System.out.println("(8) Update Balcony Availability");
                        System.out.println("(9) Update Minibar Availability");
                        System.out.println("(10) Update Weekday Daily Rate");
                        System.out.println("(11) Update Weekend Daily Rate");
                        System.out.println("(12) Update Room Maximum Occupancy");
                        System.out.println("(0) Exit Update Menu");
                        System.out.println("--------------------------------------");

                        int attribute_choice = sc.nextInt();
                        switch(attribute_choice){
                            case 1: //roomID
                                System.out.println("You are about to change Room Number!");
                                System.out.println("Enter original Room Number");
                                int testing_roomID = sc.nextInt();
                                if(testing_roomID != roomID){
                                    System.out.println("Room number not verified! Exiting to Update Menu");
                                    break;
                                }
                                System.out.println("Enter new Room Number");
                                String new_roomID = sc.next();
                                System.out.println("Would you like to change Room Number to " + new_roomID + " ?");
                                System.out.println("(1) Yes");
                                System.out.println("(0) No");
                                confirmation = sc.nextInt();
                                if(confirmation == 1){
                                    RoomController.updateRoom(roomID, attribute_choice, new_roomID);
                                    System.out.println("Room number has been changed to: " + RoomController.checkRoom(roomID, attribute_choice));
                                }
                                if(confirmation == 0) {
                                    break;
                                }
                                break;
                            case 2: // roomSize
                                System.out.println("You are about to change Room Size!");
                                System.out.println("Enter new Room Size");
                                String new_roomSize = sc.next();
                                System.out.println("Would you like to change Room Size to " + new_roomSize + " ?");
                                System.out.println("(1) Yes");
                                System.out.println("(0) No");
                                confirmation = sc.nextInt();
                                if(confirmation == 1){
                                    RoomController.updateRoom(roomID, attribute_choice, new_roomSize);
                                    System.out.println("Room Size has been changed to: " + RoomController.checkRoom(roomID, attribute_choice));
                                }
                                if(confirmation == 0){
                                    break;
                                }
                                break;
                            case 3: //roomStatus
                                System.out.println("You are about to change Room Status!");
                                System.out.println("(0) VACANT");
                                System.out.println("(1) OCCUPIED");
                                System.out.println("(2) UNDER MAINTENANCE");
                                System.out.println("(3) CLOSED");
                                System.out.println("Enter Status Number: ");
                                int new_roomStatus = sc.nextInt();
                                if (new_roomStatus<0 || new_roomStatus > 3) throw new Exception("Invalid Status Number");

                                System.out.println("Would you like to change Room Status to Status Number " + new_roomStatus + " ?");
                                System.out.println("(1) Yes");
                                System.out.println("(0) No");
                                confirmation = sc.nextInt();
                                if(confirmation == 1){
                                    RoomController.updateRoom(roomID, attribute_choice, Integer.toString(new_roomStatus));
                                    System.out.println("Room Status has been changed to: " + RoomController.checkRoom(roomID, attribute_choice));
                                }
                                if(confirmation == 0){
                                    break;
                                }
                                break;

                            case 4: // Bedding Type
                                System.out.println("You are about to change Bedding Type!");
                                System.out.println("(0) SINGLE");
                                System.out.println("(1) SUPER SINGLE");
                                System.out.println("(2) QUEEN");
                                System.out.println("(3) KING");
                                System.out.println("Enter Bedding Type Number: ");
                                int new_beddingType = sc.nextInt();
                                if (new_beddingType<0 || new_beddingType > 3) throw new Exception("Invalid Status Number");

                                System.out.println("Would you like to change Bedding Type to Status Number " + new_beddingType + " ?");
                                System.out.println("(1) Yes");
                                System.out.println("(0) No");
                                confirmation = sc.nextInt();
                                if(confirmation == 1){
                                    RoomController.updateRoom(roomID, attribute_choice, Integer.toString(new_beddingType));
                                    System.out.println("Bedding Type has been changed to: " + RoomController.checkRoom(roomID, attribute_choice));
                                }
                                if(confirmation == 0){
                                    break;
                                }
                                break;

                            case 5: // WIFI Availability
                                System.out.println("You are about to change WIFI availability!");
                                System.out.println("(0) NOT AVAILABLE");
                                System.out.println("(1) AVAILABLE");
                                System.out.println("Enter Number: ");
                                int new_WIFI = sc.nextInt();
                                if (new_WIFI<0 || new_WIFI > 1) throw new Exception("Invalid Status Number");

                                System.out.println("Would you like to change WIFI Availability to Status Number " + new_WIFI + " ?");
                                System.out.println("(1) Yes");
                                System.out.println("(0) No");
                                confirmation = sc.nextInt();
                                if(confirmation == 1){
                                    RoomController.updateRoom(roomID, attribute_choice, Integer.toString(new_WIFI));
                                    System.out.println("WIFI Availability has been changed to: " + RoomController.checkRoom(roomID, attribute_choice));
                                }
                                if(confirmation == 0){
                                    break;
                                }
                                break;
                            case 6: //Smoking Availability
                                System.out.println("You are about to change Smoking availability!");
                                System.out.println("(0) NOT AVAILABLE");
                                System.out.println("(1) AVAILABLE");
                                System.out.println("Enter Number: ");
                                int new_Smoking = sc.nextInt();
                                if (new_Smoking<0 || new_Smoking > 1) throw new Exception("Invalid Status Number");

                                System.out.println("Would you like to change Smoking Availability to Status Number " + new_Smoking + " ?");
                                System.out.println("(1) Yes");
                                System.out.println("(0) No");
                                confirmation = sc.nextInt();
                                if(confirmation == 1){
                                    RoomController.updateRoom(roomID, attribute_choice, Integer.toString(new_Smoking));
                                    System.out.println("Smoking Availability has been changed to: " + RoomController.checkRoom(roomID, attribute_choice));
                                }
                                if(confirmation == 0){
                                    break;
                                }
                                break;

                            case 7: // Room View
                                System.out.println("You are about to change Room View!");
                                System.out.println("Enter New Room View: ");
                                String new_View = sc.next();

                                System.out.println("Would you like to change Room View to " + new_View + " ?");
                                System.out.println("(1) Yes");
                                System.out.println("(0) No");
                                confirmation = sc.nextInt();
                                if(confirmation == 1){
                                    RoomController.updateRoom(roomID, attribute_choice, new_View);
                                    System.out.println("Room number has been changed to: " + RoomController.checkRoom(roomID, attribute_choice));
                                }
                                if(confirmation == 0){
                                    break;
                                }
                                break;
                            case 8: //balcony availability
                                System.out.println("You are about to change Balcony availability!");
                                System.out.println("(0) NOT AVAILABLE");
                                System.out.println("(1) AVAILABLE");
                                System.out.println("Enter Number: ");
                                int new_Balcony = sc.nextInt();
                                if (new_Balcony<0 || new_Balcony > 1) throw new Exception("Invalid Status Number");

                                System.out.println("Would you like to change Balcony Availability to Status Number " + new_Balcony + " ?");
                                System.out.println("(1) Yes");
                                System.out.println("(0) No");
                                confirmation = sc.nextInt();
                                if(confirmation == 1){
                                    RoomController.updateRoom(roomID, attribute_choice, Integer.toString(new_Balcony));
                                    System.out.println("Balcony Availability has been changed to: " + RoomController.checkRoom(roomID, attribute_choice));
                                }
                                if(confirmation == 0){
                                    break;
                                }
                                break;
                            case 9: //Minibar availability
                                System.out.println("You are about to change Minibar availability!");
                                System.out.println("(0) NOT AVAILABLE");
                                System.out.println("(1) AVAILABLE");
                                System.out.println("Enter Number: ");
                                int new_Minibar = sc.nextInt();
                                if (new_Minibar<0 || new_Minibar > 1) throw new Exception("Invalid Status Number");

                                System.out.println("Would you like to change Minibar Availability to Status Number " + new_Minibar + " ?");
                                System.out.println("(1) Yes");
                                System.out.println("(0) No");
                                confirmation = sc.nextInt();
                                if(confirmation == 1){
                                    RoomController.updateRoom(roomID, attribute_choice, Integer.toString(new_Minibar));
                                    System.out.println("Minibar Availability has been changed to: " + RoomController.checkRoom(roomID, attribute_choice));
                                }
                                if(confirmation == 0){
                                    break;
                                }
                                break;
                            case 10: //weekday daily rate
                                System.out.println("You are about to change Weekday Daily Rate!");
                                System.out.println("Enter new Weekday Rate in Dollars:$ ");
                                float new_WeekdayRate = sc.nextFloat();
                                if (new_WeekdayRate<0) throw new Exception("Rate cannot be less than $0");

                                System.out.println("Would you like to change the weekday daily rate to " + new_WeekdayRate + " ?");
                                System.out.println("(1) Yes");
                                System.out.println("(0) No");
                                confirmation = sc.nextInt();
                                if(confirmation == 1){
                                    RoomController.updateRoom(roomID, attribute_choice, Float.toString(new_WeekdayRate));
                                    System.out.println("Weekday Rate has been changed to: " + RoomController.checkRoom(roomID, attribute_choice));
                                }
                                if(confirmation == 0){
                                    break;
                                }
                                break;
                            case 11: //weekend daily rate
                                System.out.println("You are about to change Weekend Daily Rate!");
                                System.out.println("Enter new Weekday Rate in Dollars:$ ");
                                float new_WeekendRate = sc.nextFloat();
                                if (new_WeekendRate<0) throw new Exception("Rate cannot be less than $0");

                                System.out.println("Would you like to change the weekday daily rate to " + new_WeekendRate + " ?");
                                System.out.println("(1) Yes");
                                System.out.println("(0) No");
                                confirmation = sc.nextInt();
                                if(confirmation == 1){
                                    RoomController.updateRoom(roomID, attribute_choice, Float.toString(new_WeekendRate));
                                    System.out.println("Weekend Rate has been changed to: " + RoomController.checkRoom(roomID, attribute_choice));
                                }
                                if(confirmation == 0){
                                    break;
                                }
                                break;
                            case 12: //maxOccupancy
                                System.out.println("You are about to change Maximum Room Occupancy!");
                                System.out.println("Enter new maximum room occupancy: ");
                                int new_maxOccupancy = sc.nextInt();
                                if (new_maxOccupancy<0 || new_maxOccupancy>10) throw new Exception("Max Occupancy needs to be between 1 to 10.");

                                System.out.println("Would you like to change the weekday daily rate to " + new_maxOccupancy + " ?");
                                System.out.println("(1) Yes");
                                System.out.println("(0) No");
                                confirmation = sc.nextInt();
                                if(confirmation == 1){
                                    RoomController.updateRoom(roomID, attribute_choice, Float.toString(new_maxOccupancy));
                                    System.out.println("Maximum Room Occupancy has been changed to: " + RoomController.checkRoom(roomID, attribute_choice));
                                }
                                if(confirmation == 0){
                                    break;
                                }
                                break;
                            case 0:
                                flag = false;
                        }


                    }while(flag);
                    break;

                case 3: //retrieve current room status
                    System.out.println("Enter the room number to retrieve current status: ");
                    roomID = sc.nextInt();
                    if (roomID<100 || roomID > 503) throw new Exception("Room does not exist.");

                    System.out.println("Current Room Status of " + roomID + " is " + RoomController.checkRoomStatus(roomID));
                    break;

                case 4:// find room information by room number
                    System.out.println("Find room information by Room Number. Enter Room Number: ");
                    roomID = sc.nextInt();
                    if (roomID<100 || roomID > 503) throw new Exception("Room does not exist.");

                    RoomController.findRoomByID(roomID);
                    break;

                default:
                    System.out.println("Other features under development.");
                    break;

                case 5: // check room vacancies by room type
                        System.out.println("Check for vacancies by Room Types");
                        System.out.println("(1) Wonderful Rooms");
                        System.out.println("(2) Spectacular Rooms");
                        System.out.println("(3) Fabulous Rooms");
                        System.out.println("(4) Away Rooms");
                        System.out.println("(5) Suite Rooms");
                        int choice_roomType = sc.nextInt();
                        if(choice_roomType<1 || choice_roomType >5) throw new Exception("Room does not exist.");

                        int num_vacant = 0;
                        switch (choice_roomType){
                            case 1:
                                num_vacant = RoomController.vacantWonderfulRooms(num_vacant);
                                break;
                            case 2:
                                num_vacant = RoomController.vacantSpectacularRooms(num_vacant);
                                break;
                            case 3:
                                num_vacant = RoomController.vacantFabulousRooms(num_vacant);
                                break;
                            case 4:
                                num_vacant = RoomController.vacantAwayRooms(num_vacant);
                                break;
                            case 5:
                                num_vacant = RoomController.vacantSuiteRooms(num_vacant);
                                break;
                        }
                        System.out.println("Total Vacant Rooms in chosen Room Type: " + num_vacant);
                        break;

                case 6: // occupancy rate report
                    RoomController.occupancyRateReport();
                    break;
                case 7: // room status report
                    RoomController.roomStatusReport();
                    break;
            }

        }while(true);
    }
}
