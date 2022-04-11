
abstract class Room {

    //Enums
    enum RoomStatus {
        VACANT, OCCUPIED, UNDER_MAINTENANCE, CLOSED
    }
    enum BedType{
        SINGLE, SUPER_SINGLE, QUEEN, KING
    }

    /* Attributes */
    private int roomID;
    private int roomSize;
    public RoomStatus roomStatus;
    private BedType bedType;

    private boolean isWifiEnabled;
    private boolean isSmoking;
    private String view;
    private boolean hasBalcony;
    private boolean hasMinibar;
    private float weekdayRate;
    private float weekendRate;
    private int maxOccupancy;


    /* Getter and Setter Methods */
    public int getRoomID() {
        return roomID;
    }


    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(int roomSize) {
        this.roomSize = roomSize;
    }

    public boolean isWifiEnabled() {
        return isWifiEnabled;
    }

    public void setWifiEnabled(boolean wifiEnabled) {
        isWifiEnabled = wifiEnabled;
    }

    public boolean isSmoking() {
        return isSmoking;
    }

    public void setSmoking(boolean smoking) {
        isSmoking = smoking;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    public boolean isHasMinibar() {
        return hasMinibar;
    }

    public void setHasMinibar(boolean hasMinibar) {
        this.hasMinibar = hasMinibar;
    }

    public float getWeekdayRate() {
        return weekdayRate;
    }

    public void setWeekdayRate(float weekdayRate) {
        this.weekdayRate = weekdayRate;
    }

    public float getWeekendRate() {
        return weekendRate;
    }

    public void setWeekendRate(float weekendRate) {
        this.weekendRate = weekendRate;
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setMaxOccupancy(int maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public void setRoomStatus(int roomStatus){
        switch(roomStatus){
            case 0:
                this.roomStatus = RoomStatus.VACANT;
                break;
            case 1:
                this.roomStatus = RoomStatus.OCCUPIED;
                break;
            case 2:
                this.roomStatus = RoomStatus.UNDER_MAINTENANCE;
                break;
            case 3:
                this.roomStatus = RoomStatus.CLOSED;
                break;
        }
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public BedType getBedType() {
        return bedType;
    }

    public void setBedType(int bedType) {
        switch(bedType) {
            case 0:
                this.bedType = BedType.SINGLE;
                break;
            case 1:
                this.bedType = BedType.SUPER_SINGLE;
                break;
            case 2:
                this.bedType = BedType.QUEEN;
                break;
            case 3:
                this.bedType = BedType.KING;
                break;
        }
    }

}




