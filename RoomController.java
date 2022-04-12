import java.util.ArrayList;
import java.util.HashMap;

/*Summary of Methods:
- createWonderfulRoom
- createSpectacularRoom
- createFabulousRoom
- createAwayRoom
- createSuiteRoom
- update(
- updateRoomStatus
- updateWeekdayRate
- updateWeekendRate
- updateMaxOccupancy
- updateRequestButler

- checkRoomStatus
- findRoomByID (prints all current room information)
- occupancy rate report
- room status report

//Vacant methods print out room numbers of all vacant rooms in each room type.
- vacantWonderfulRooms
- vacantSpectacularRooms
- vacantFabulousRooms
- vacantAwayRooms
- vacantSuiteRooms

// Requested methods from Billing
- getWeekdayRate (by roomID)
- getWeekendRate (by roomID)


*/

public class RoomController {
    /*Attributes*/
    public static final int SIZE = 48;
    public static final int SIZE_WONDERFUL = 16;
    public static final int SIZE_SPECTACULAR = 14;
    public static final int SIZE_FABULOUS = 8;
    public static final int SIZE_AWAY = 6;
    public static final int SIZE_SUITES = 4;
    private ArrayList<Wonderful> Wonderful_List = new ArrayList<Wonderful>(SIZE_WONDERFUL);
    private ArrayList<Spectacular> Spectacular_List = new ArrayList<Spectacular>(SIZE_SPECTACULAR);
    private ArrayList<Fabulous> Fabulous_List = new ArrayList<Fabulous>(SIZE_FABULOUS);
    private ArrayList<Away> Away_List = new ArrayList<Away>(SIZE_AWAY);
    private ArrayList<Suites> Suites_List = new ArrayList<Suites>(SIZE_SUITES);

    /* CREATE Methods*/
    void createWonderfulRoom(int roomID, int roomSize, int roomStatus, int bedType, boolean isWifiEnabled, boolean isSmoking,
                             String view, boolean hasBalcony, boolean hasMinibar, float weekdayRate,
                             float weekendRate, int maxOccupancy) {
        Wonderful obj_W = new Wonderful();
        obj_W.setRoomID(roomID);
        obj_W.setRoomSize(roomSize);
        obj_W.setRoomStatus(roomStatus);
        obj_W.setBedType(bedType);
        obj_W.setWifiEnabled(isWifiEnabled);
        obj_W.setSmoking(isSmoking);
        obj_W.setView(view);
        obj_W.setHasBalcony(hasBalcony);
        obj_W.setHasMinibar(hasMinibar);
        obj_W.setWeekdayRate(weekdayRate);
        obj_W.setWeekendRate(weekendRate);
        obj_W.setMaxOccupancy(maxOccupancy);
        Wonderful_List.add(obj_W);
    }

    void createSpectacularRoom(int roomID, int roomSize, int roomStatus, int bedType, boolean isWifiEnabled, boolean isSmoking,
                               String view, boolean hasBalcony, boolean hasMinibar, float weekdayRate,
                               float weekendRate, int maxOccupancy) {
        Spectacular obj_S = new Spectacular();
        obj_S.setRoomID(roomID);
        obj_S.setRoomSize(roomSize);
        obj_S.setRoomStatus(roomStatus);
        obj_S.setBedType(bedType);
        obj_S.setWifiEnabled(isWifiEnabled);
        obj_S.setSmoking(isSmoking);
        obj_S.setView(view);
        obj_S.setHasBalcony(hasBalcony);
        obj_S.setHasMinibar(hasMinibar);
        obj_S.setWeekdayRate(weekdayRate);
        obj_S.setWeekendRate(weekendRate);
        obj_S.setMaxOccupancy(maxOccupancy);
        Spectacular_List.add(obj_S);
    }

    void createFabulousRoom(int roomID, int roomSize, int roomStatus, int bedType, boolean isWifiEnabled, boolean isSmoking,
                            String view, boolean hasBalcony, boolean hasMinibar, float weekdayRate,
                            float weekendRate, int maxOccupancy) {
        Fabulous obj_F = new Fabulous();
        obj_F.setRoomID(roomID);
        obj_F.setRoomSize(roomSize);
        obj_F.setRoomStatus(roomStatus);
        obj_F.setBedType(bedType);
        obj_F.setWifiEnabled(isWifiEnabled);
        obj_F.setSmoking(isSmoking);
        obj_F.setView(view);
        obj_F.setHasBalcony(hasBalcony);
        obj_F.setHasMinibar(hasMinibar);
        obj_F.setWeekdayRate(weekdayRate);
        obj_F.setWeekendRate(weekendRate);
        obj_F.setMaxOccupancy(maxOccupancy);
        Fabulous_List.add(obj_F);

    }

    void createAwayRoom(int roomID, int roomSize, int roomStatus, int bedType, boolean isWifiEnabled, boolean isSmoking,
                        String view, boolean hasBalcony, boolean hasMinibar, float weekdayRate,
                        float weekendRate, int maxOccupancy, int requestButler, boolean hasPrivatePool) {
        Away obj_A = new Away();
        obj_A.setRoomID(roomID);
        obj_A.setRoomSize(roomSize);
        obj_A.setRoomStatus(roomStatus);
        obj_A.setBedType(bedType);
        obj_A.setWifiEnabled(isWifiEnabled);
        obj_A.setSmoking(isSmoking);
        obj_A.setView(view);
        obj_A.setHasBalcony(hasBalcony);
        obj_A.setHasMinibar(hasMinibar);
        obj_A.setWeekdayRate(weekdayRate);
        obj_A.setWeekendRate(weekendRate);
        obj_A.setMaxOccupancy(maxOccupancy);
        obj_A.setRequestButler(requestButler);
        obj_A.setHasPrivatePool(hasPrivatePool);

        Away_List.add(obj_A);
    }

    void createSuiteRoom(int roomID, int roomSize, int roomStatus, int bedType, boolean isWifiEnabled, boolean isSmoking,
                         String view, boolean hasBalcony, boolean hasMinibar, float weekdayRate,
                         float weekendRate, int maxOccupancy, int requestButler, boolean hasPrivatePool) {
        Suites obj_Su = new Suites();
        obj_Su.setRoomID(roomID);
        obj_Su.setRoomSize(roomSize);
        obj_Su.setRoomStatus(roomStatus);
        obj_Su.setBedType(bedType);
        obj_Su.setWifiEnabled(isWifiEnabled);
        obj_Su.setSmoking(isSmoking);
        obj_Su.setView(view);
        obj_Su.setHasBalcony(hasBalcony);
        obj_Su.setHasMinibar(hasMinibar);
        obj_Su.setWeekdayRate(weekdayRate);
        obj_Su.setWeekendRate(weekendRate);
        obj_Su.setMaxOccupancy(maxOccupancy);
        obj_Su.setRequestButler(requestButler);
        obj_Su.setHasPrivatePool(hasPrivatePool);

        Suites_List.add(obj_Su);
    }

    /*{
        HashMap<string, Object> map = new HashMap<string, Object>();
        map.put("roomTyp")
        int s = 5;
        Object a = s;

    }
    void update(object entity, object value){
        entity =
    }*/

    /* UPDATE Methods*/
    Room rm;
    Away aw;
    Suites su;
    public void updateRoom(int roomID, int attribute_choice, String variable){
        int roomNo = roomID % 100;
        switch (getRoomType(roomID)) {
            case 1 -> rm = Wonderful_List.get(roomNo - 1);
            case 2 -> rm = Spectacular_List.get(roomNo - 1);
            case 3 -> rm = Fabulous_List.get(roomNo - 1);
            case 4 -> rm = Away_List.get(roomNo - 1);
            case 5 -> rm = Suites_List.get(roomNo - 1);
        }
        switch(attribute_choice){
            //case 1: roomID
            case 1:
                rm.setRoomID(Integer.parseInt(variable));
                break;
            //case 2: roomSize
            case 2:
                rm.setRoomSize(Integer.parseInt(variable));
                break;
            //case 3: roomStatus
            case 3:
                rm.setRoomStatus(Integer.parseInt(variable));
                break;
            //case 4: bedType
            case 4:
                rm.setBedType(Integer.parseInt(variable));
                break;
            //case 5: isWifiEnabled
            case 5:
                rm.setWifiEnabled(Boolean.parseBoolean(variable));
                break;
            case 6:
            //case 6: isSmoking
                rm.setSmoking(Boolean.parseBoolean(variable));
                break;
            case 7:
            //case 7: View
                rm.setView(variable);
                break;
            case 8:
            //case 8: hasBalcony
                rm.setHasBalcony(Boolean.parseBoolean(variable));
                break;
            case 9:
            //case 9: hasMinibar
                rm.setHasMinibar(Boolean.parseBoolean(variable));
                break;
            case 10:
            //case 10: weekdayRate
                rm.setWeekdayRate(Float.parseFloat(variable));
                break;
            case 11:
            //case 11: weekendRate
                rm.setWeekendRate(Float.parseFloat(variable));
                break;
            case 12:
            //case 12: maxOccupancy
                rm.setMaxOccupancy(Integer.parseInt(variable));
                break;
        }


    }

    public void updateSpecialRoom(int roomID, int attribute_choice, String variable){
        int roomNo = roomID % 100;
        switch (getRoomType(roomID)) {
            case 4:
                aw = Away_List.get(roomNo - 1);
                switch(attribute_choice){
                    case 13:
                        aw.setRequestButler(Integer.parseInt(variable));
                    case 14:
                        aw.setRequestButler(Integer.parseInt(variable));
                }
            case 5:
                su = Suites_List.get(roomNo - 1);
                switch(attribute_choice){
                    case 13:
                        su.setRequestButler(Integer.parseInt(variable));
                    case 14:
                        su.setRequestButler(Integer.parseInt(variable));
                }
        }

    }


    /* CHECK Methods */
    Room.RoomStatus checkRoomStatus(int roomID) {
        //roomType/roomID to find the right arraylist/index to access
        int roomNo = roomID % 100;
        return switch (getRoomType(roomID)) {
            case 1 -> Wonderful_List.get(roomNo - 1).getRoomStatus();
            case 2 -> Spectacular_List.get(roomNo - 1).getRoomStatus();
            case 3 -> Fabulous_List.get(roomNo - 1).getRoomStatus();
            case 4 -> Away_List.get(roomNo - 1).getRoomStatus();
            case 5 -> Suites_List.get(roomNo - 1).getRoomStatus();
            default -> null;
        };
    }
    public String checkRoom(int roomID, int attribute_choice){
        int roomNo = roomID % 100;
        switch (getRoomType(roomID)) {
            case 1 -> rm = Wonderful_List.get(roomNo - 1);
            case 2 -> rm = Spectacular_List.get(roomNo - 1);
            case 3 -> rm = Fabulous_List.get(roomNo - 1);
            case 4 -> rm = Away_List.get(roomNo - 1);
            case 5 -> rm = Suites_List.get(roomNo - 1);
        }
        switch(attribute_choice){
            //case 1: roomID
            case 1:
                return String.valueOf(rm.getRoomID());
                //case 2: roomSize
            case 2:
                return String.valueOf(rm.getRoomSize());
                //case 3: roomStatus
            case 3:
                return String.valueOf(rm.getRoomStatus());
                //case 4: bedType
            case 4:
                return String.valueOf(rm.getBedType());
                //case 5: isWifiEnabled
            case 5:
                return String.valueOf(rm.isWifiEnabled());
            case 6:
                //case 6: isSmoking
                return String.valueOf(rm.isSmoking());
            case 7:
                //case 7: View
                return rm.getView();
            case 8:
                //case 8: hasBalcony
                return String.valueOf(rm.isHasBalcony());
            case 9:
                //case 9: hasMinibar
                return String.valueOf(rm.isHasMinibar());
            case 10:
                //case 10: weekdayRate
                return String.valueOf(rm.getWeekdayRate());
            case 11:
                //case 11: weekendRate
                return String.valueOf(rm.getWeekendRate());
            case 12:
                //case 12: maxOccupancy
                return String.valueOf(rm.getMaxOccupancy());
            default:
                return null;
        }
    }

    void findRoomByID(int roomID) {
        int roomNo = roomID % 100;
        switch (getRoomType(roomID)) {
            case 1:
                System.out.println("Room Number: " + Wonderful_List.get(roomNo - 1).getRoomID());
                System.out.println("Room Size: " + Wonderful_List.get(roomNo - 1).getRoomSize());
                System.out.println("Bed Type: " + Wonderful_List.get(roomNo - 1).getBedType());
                System.out.println("Wifi in Room: " + Wonderful_List.get(roomNo - 1).isWifiEnabled());
                System.out.println("Smoking in Room: " + Wonderful_List.get(roomNo - 1).isSmoking());
                System.out.println("Balcony in Room: " + Wonderful_List.get(roomNo - 1).isHasBalcony());
                System.out.println("Minibar in Room: " + Wonderful_List.get(roomNo - 1).isHasMinibar());
                System.out.println("View from Room: " + Wonderful_List.get(roomNo - 1).getView());
                System.out.println("====================================================");
                System.out.println("Weekday Rate (SGD):$ " + Wonderful_List.get(roomNo - 1).getWeekdayRate());
                System.out.println("Weekend Rate (SGD):$ " + Wonderful_List.get(roomNo - 1).getWeekendRate());
                System.out.println("Maximum Room Occupancy: " + Wonderful_List.get(roomNo - 1).isHasBalcony());
                System.out.println("Room Current Status: " + Wonderful_List.get(roomNo - 1).getRoomStatus());
                break;

            case 2:
                System.out.println("Room Number: " + Spectacular_List.get(roomNo - 1).getRoomID());
                System.out.println("Room Size: " + Spectacular_List.get(roomNo - 1).getRoomSize());
                System.out.println("Bed Type: " + Spectacular_List.get(roomNo - 1).getBedType());
                System.out.println("Wifi in Room: " + Spectacular_List.get(roomNo - 1).isWifiEnabled());
                System.out.println("Smoking in Room: " + Spectacular_List.get(roomNo - 1).isSmoking());
                System.out.println("Balcony in Room: " + Spectacular_List.get(roomNo - 1).isHasBalcony());
                System.out.println("Minibar in Room: " + Spectacular_List.get(roomNo - 1).isHasMinibar());
                System.out.println("View from Room: " + Spectacular_List.get(roomNo - 1).getView());
                System.out.println("====================================================");
                System.out.println("Weekday Rate (SGD):$ " + Spectacular_List.get(roomNo - 1).getWeekdayRate());
                System.out.println("Weekend Rate (SGD):$ " + Spectacular_List.get(roomNo - 1).getWeekendRate());
                System.out.println("Maximum Room Occupancy: " + Spectacular_List.get(roomNo - 1).isHasBalcony());
                System.out.println("Room Current Status: " + Spectacular_List.get(roomNo - 1).getRoomStatus());
                break;

            case 3:
                System.out.println("Room Number: " + Fabulous_List.get(roomNo - 1).getRoomID());
                System.out.println("Room Size: " + Fabulous_List.get(roomNo - 1).getRoomSize());
                System.out.println("Bed Type: " + Fabulous_List.get(roomNo - 1).getBedType());
                System.out.println("Wifi in Room: " + Fabulous_List.get(roomNo - 1).isWifiEnabled());
                System.out.println("Smoking in Room: " + Fabulous_List.get(roomNo - 1).isSmoking());
                System.out.println("Balcony in Room: " + Fabulous_List.get(roomNo - 1).isHasBalcony());
                System.out.println("Minibar in Room: " + Fabulous_List.get(roomNo - 1).isHasMinibar());
                System.out.println("View from Room: " + Fabulous_List.get(roomNo - 1).getView());
                System.out.println("====================================================");
                System.out.println("Weekday Rate (SGD):$ " + Fabulous_List.get(roomNo - 1).getWeekdayRate());
                System.out.println("Weekend Rate (SGD):$ " + Fabulous_List.get(roomNo - 1).getWeekendRate());
                System.out.println("Maximum Room Occupancy: " + Fabulous_List.get(roomNo - 1).isHasBalcony());
                System.out.println("Room Current Status: " + Fabulous_List.get(roomNo - 1).getRoomStatus());
                break;

            case 4:
                System.out.println("Room Number: " + Away_List.get(roomNo - 1).getRoomID());
                System.out.println("Room Size: " + Away_List.get(roomNo - 1).getRoomSize());
                System.out.println("Bed Type: " + Away_List.get(roomNo - 1).getBedType());
                System.out.println("Wifi in Room: " + Away_List.get(roomNo - 1).isWifiEnabled());
                System.out.println("Smoking in Room: " + Away_List.get(roomNo - 1).isSmoking());
                System.out.println("Balcony in Room: " + Away_List.get(roomNo - 1).isHasBalcony());
                System.out.println("Minibar in Room: " + Away_List.get(roomNo - 1).isHasMinibar());
                System.out.println("View from Room: " + Away_List.get(roomNo - 1).getView());
                System.out.println("Private Pool in Room: " + Away_List.get(roomNo - 1).isHasPrivatePool());
                System.out.println("Butler Request Status: " + Away_List.get(roomNo - 1).getRequestButler());
                System.out.println("====================================================");
                System.out.println("Weekday Rate (SGD):$ " + Away_List.get(roomNo - 1).getWeekdayRate());
                System.out.println("Weekend Rate (SGD):$ " + Away_List.get(roomNo - 1).getWeekendRate());
                System.out.println("Maximum Room Occupancy: " + Away_List.get(roomNo - 1).isHasBalcony());
                System.out.println("Room Current Status: " + Away_List.get(roomNo - 1).getRoomStatus());
                break;

            case 5:
                System.out.println("Room Number: " + Suites_List.get(roomNo - 1).getRoomID());
                System.out.println("Room Size: " + Suites_List.get(roomNo - 1).getRoomSize());
                System.out.println("Bed Type: " + Suites_List.get(roomNo - 1).getBedType());
                System.out.println("Wifi in Room: " + Suites_List.get(roomNo - 1).isWifiEnabled());
                System.out.println("Smoking in Room: " + Suites_List.get(roomNo - 1).isSmoking());
                System.out.println("Balcony in Room: " + Suites_List.get(roomNo - 1).isHasBalcony());
                System.out.println("Minibar in Room: " + Suites_List.get(roomNo - 1).isHasMinibar());
                System.out.println("View from Room: " + Suites_List.get(roomNo - 1).getView());
                System.out.println("Private Pool in Room: " + Suites_List.get(roomNo - 1).isHasPrivatePool());
                System.out.println("Butler Request Status: " + Suites_List.get(roomNo - 1).getRequestButler());
                System.out.println("====================================================");
                System.out.println("Weekday Rate (SGD):$ " + Suites_List.get(roomNo - 1).getWeekdayRate());
                System.out.println("Weekend Rate (SGD):$ " + Suites_List.get(roomNo - 1).getWeekendRate());
                System.out.println("Maximum Room Occupancy: " + Suites_List.get(roomNo - 1).isHasBalcony());
                System.out.println("Room Current Status: " + Suites_List.get(roomNo - 1).getRoomStatus());
                break;
        }
    }

    int vacantWonderfulRooms(int counter) {
        System.out.println("Vacant Wonderful Rooms are:");
        for (Wonderful obj_W : Wonderful_List) {
            if (obj_W.getRoomStatus() == Room.RoomStatus.VACANT) {
                counter ++;
                System.out.println("Room No: " + obj_W.getRoomID());
                System.out.println();
            }
        }return counter;
    }

    int vacantSpectacularRooms(int counter) {
        System.out.println("Vacant Spectacular Rooms are:");
        for (Spectacular obj_S : Spectacular_List) {
            if (obj_S.getRoomStatus() == Room.RoomStatus.VACANT) {
                counter ++;
                System.out.println("Room No: " + obj_S.getRoomID());
                System.out.println();
            }
        }return counter;
    }

    int vacantFabulousRooms(int counter) {
        System.out.println("Vacant Fabulous Rooms are:");
        for (Fabulous obj_F : Fabulous_List) {
            if (obj_F.getRoomStatus() == Room.RoomStatus.VACANT) {
                counter ++;
                System.out.println("Room No: " + obj_F.getRoomID());
                System.out.println();
            }
        }return counter;
    }

    int vacantAwayRooms(int counter) {
        System.out.println("Vacant Away Rooms are:");
        for (Away obj_A : Away_List) {
            if (obj_A.getRoomStatus() == Room.RoomStatus.VACANT) {
                counter ++;
                System.out.println("Room No: " + obj_A.getRoomID());
                System.out.println();
            }
        }return counter;
    }

    int vacantSuiteRooms(int counter) {
        System.out.println("Vacant Suite Rooms are:");
        for (Suites obj_Su : Suites_List) {
            if (obj_Su.getRoomStatus() == Room.RoomStatus.VACANT) {
                counter ++;
                System.out.println("Room No: " + obj_Su.getRoomID());
                System.out.println();
            }
        }return counter;
    }

    /*PRINT METHODS*/
    void occupancyRateReport() {
        int num_occupied_wonderful = 0;
        num_occupied_wonderful = vacantWonderfulRooms(num_occupied_wonderful);
        System.out.println("Total Occupied Wonderful Rooms: "+ num_occupied_wonderful + " out of " + SIZE_WONDERFUL);

        System.out.println();

        int num_occupied_Spectacular = 0;
        num_occupied_Spectacular = vacantSpectacularRooms(num_occupied_Spectacular);
        System.out.println("Total Occupied Spectacular Rooms: "+ num_occupied_Spectacular+ " out of " + SIZE_SPECTACULAR);

        System.out.println();

        int num_occupied_Fabulous = 0;
        num_occupied_Fabulous = vacantFabulousRooms(num_occupied_Fabulous);
        System.out.println("Total Occupied Fabulous Rooms: "+ num_occupied_Fabulous+ " out of " + SIZE_FABULOUS);

        System.out.println();

        int num_occupied_Away = 0;
        num_occupied_Away = vacantAwayRooms(num_occupied_Away);
        System.out.println("Total Occupied Away Rooms: "+ num_occupied_Away+ " out of " + SIZE_AWAY);

        System.out.println();

        int num_occupied_Suite = 0;
        num_occupied_Suite = vacantSuiteRooms(num_occupied_Suite);
        System.out.println("Total Occupied Suite Rooms: "+ num_occupied_Suite+ " out of " + SIZE_SUITES);

        int total_occupied = num_occupied_wonderful+num_occupied_Spectacular+num_occupied_Fabulous+num_occupied_Away+num_occupied_Suite;
        float occupancy_rate = (total_occupied/SIZE) * 100;
        System.out.print("Occupancy Rate: ");
        System.out.format("%.2f", occupancy_rate);

    }

    void roomStatusReport() {
        System.out.println("Currently Vacant Rooms: ");
        for (Wonderful obj_W : Wonderful_List) {
            if (obj_W.getRoomStatus() == Room.RoomStatus.VACANT) {
                System.out.println(obj_W.getRoomID() + " , ");
            }
        }
        for (Spectacular obj_S : Spectacular_List) {
            if (obj_S.getRoomStatus() == Room.RoomStatus.VACANT) {
                System.out.println(obj_S.getRoomID() + " , ");
            }
        }
        for (Fabulous obj_F : Fabulous_List) {
            if (obj_F.getRoomStatus() == Room.RoomStatus.VACANT) {
                System.out.println(obj_F.getRoomID() + " , ");
            }
        }
        for (Away obj_A : Away_List) {
            if (obj_A.getRoomStatus() == Room.RoomStatus.VACANT) {
                System.out.println(obj_A.getRoomID() + " , ");
            }
        }
        for (Suites obj_Su : Suites_List) {
            if (obj_Su.getRoomStatus() == Room.RoomStatus.VACANT) {
                System.out.println(obj_Su.getRoomID() + " , ");
            }
        }
        System.out.println();
        System.out.println("===================================");
        System.out.println("Currently Occupied Rooms: ");
        for (Wonderful obj_W : Wonderful_List) {
            if (obj_W.getRoomStatus() == Room.RoomStatus.OCCUPIED) {
                System.out.println(obj_W.getRoomID() + " , ");
            }
        }
        for (Spectacular obj_S : Spectacular_List) {
            if (obj_S.getRoomStatus() == Room.RoomStatus.OCCUPIED) {
                System.out.println(obj_S.getRoomID() + " , ");
            }
        }
        for (Fabulous obj_F : Fabulous_List) {
            if (obj_F.getRoomStatus() == Room.RoomStatus.OCCUPIED) {
                System.out.println(obj_F.getRoomID() + " , ");
            }
        }
        for (Away obj_A : Away_List) {
            if (obj_A.getRoomStatus() == Room.RoomStatus.OCCUPIED) {
                System.out.println(obj_A.getRoomID() + " , ");
            }
        }
        for (Suites obj_Su : Suites_List) {
            if (obj_Su.getRoomStatus() == Room.RoomStatus.OCCUPIED) {
                System.out.println(obj_Su.getRoomID() + " , ");
            }
        }
        System.out.println();
        System.out.println("===================================");
        System.out.println("Currently Under Maintenance Rooms: ");
        for (Wonderful obj_W : Wonderful_List) {
            if (obj_W.getRoomStatus() == Room.RoomStatus.UNDER_MAINTENANCE) {
                System.out.println(obj_W.getRoomID() + " , ");
            }
        }
        for (Spectacular obj_S : Spectacular_List) {
            if (obj_S.getRoomStatus() == Room.RoomStatus.UNDER_MAINTENANCE) {
                System.out.println(obj_S.getRoomID() + " , ");
            }
        }
        for (Fabulous obj_F : Fabulous_List) {
            if (obj_F.getRoomStatus() == Room.RoomStatus.UNDER_MAINTENANCE) {
                System.out.println(obj_F.getRoomID() + " , ");
            }
        }
        for (Away obj_A : Away_List) {
            if (obj_A.getRoomStatus() == Room.RoomStatus.UNDER_MAINTENANCE) {
                System.out.println(obj_A.getRoomID() + " , ");
            }
        }
        for (Suites obj_Su : Suites_List) {
            if (obj_Su.getRoomStatus() == Room.RoomStatus.UNDER_MAINTENANCE) {
                System.out.println(obj_Su.getRoomID() + " , ");
            }
        }
        System.out.println();
        System.out.println("===================================");
        System.out.println("Currently Closed Rooms: ");
        for (Wonderful obj_W : Wonderful_List) {
            if (obj_W.getRoomStatus() == Room.RoomStatus.CLOSED) {
                System.out.println(obj_W.getRoomID() + " , ");
            }
        }
        for (Spectacular obj_S : Spectacular_List) {
            if (obj_S.getRoomStatus() == Room.RoomStatus.CLOSED) {
                System.out.println(obj_S.getRoomID() + " , ");
            }
        }
        for (Fabulous obj_F : Fabulous_List) {
            if (obj_F.getRoomStatus() == Room.RoomStatus.CLOSED) {
                System.out.println(obj_F.getRoomID() + " , ");
            }
        }
        for (Away obj_A : Away_List) {
            if (obj_A.getRoomStatus() == Room.RoomStatus.CLOSED) {
                System.out.println(obj_A.getRoomID() + " , ");
            }
        }
        for (Suites obj_Su : Suites_List) {
            if (obj_Su.getRoomStatus() == Room.RoomStatus.CLOSED) {
                System.out.println(obj_Su.getRoomID() + " , ");
            }
        }
    }

    //internal method
    private int getRoomType(int roomID) {
        int roomType = roomID;
        while (roomType >= 10) {
            roomType = roomType / 10;

        }return roomType;
    }

    //Methods for Billing Class
    float getCWeekdayRate(int roomID){
        int roomNo = roomID % 100;

        return switch (getRoomType(roomID)) {
            case 1 -> Wonderful_List.get(roomNo - 1).getWeekdayRate();
            case 2 -> Spectacular_List.get(roomNo - 1).getWeekdayRate();
            case 3 -> Fabulous_List.get(roomNo - 1).getWeekdayRate();
            case 4 -> Away_List.get(roomNo - 1).getWeekdayRate();
            case 5 -> Suites_List.get(roomNo - 1).getWeekdayRate();
            default -> 0;
        };
    }

    float getCWeekendRate(int roomID){
        int roomNo = roomID % 100;

        return switch (getRoomType(roomID)) {
            case 1 -> Wonderful_List.get(roomNo - 1).getWeekendRate();
            case 2 -> Spectacular_List.get(roomNo - 1).getWeekendRate();
            case 3 -> Fabulous_List.get(roomNo - 1).getWeekendRate();
            case 4 -> Away_List.get(roomNo - 1).getWeekendRate();
            case 5 -> Suites_List.get(roomNo - 1).getWeekendRate();
            default -> 0;
        };
    }


}








