import java.util.Scanner;
import java.util.*;


public class RoomInterface {
    public static void main(String[] args){
        RoomController RoomController = new RoomController();

        int user_choice;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("--------------------------------------");
            System.out.println("Welcome to the Room Management Interface");
            System.out.println("(1) Creating Hotel Rooms");
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
                case 4:
                    System.out.println("Find room information by Room Number. Enter Room Number:");
                    int roomID = sc.nextInt();
                    RoomController.findRoomByID(roomID);

                default:
                    System.out.println("Other features under development.");

            }

        }while(true);
    }
}
