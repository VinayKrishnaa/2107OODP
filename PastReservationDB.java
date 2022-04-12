import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class PastReservationDB {
    // create instance of menuDB
    public static PastReservationDB instance = null;
    public static PastReservationDB getInstance() {
        if (instance == null)
            instance = new PastReservationDB();
        return instance;
    }

    // write the current arraylist data of menu/orders into the text file for future usage
    public void saveData(ArrayList<Reservation> arr) {
        try {
            String lineSep = System.lineSeparator();

            FileWriter fw = new FileWriter("PastReservations.txt");
            Writer output = new BufferedWriter(fw);

            for (int i = 0; i < arr.size(); i++) {
                output.write(arr.get(i).toString() + lineSep);
            }
            output.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    // read the data from text file and add into menu/orders arraylist
    public void readData(ArrayList<Reservation> arr) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("PastReservations.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(" ");
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                arr.add(new Reservation(Integer.parseInt(split[1]), Integer.parseInt(split[2]), Boolean.parseBoolean(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]), formatter.parse(split[6]), formatter.parse(split[7]), Enum.valueOf(Reservation.statusType.class, split[8]), split[9]));
            }
            reader.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
