import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ReservationDB {
    // create instance of menuDB
    public static ReservationDB instance = null;
    public static ReservationDB getInstance() {
        if (instance == null)
            instance = new ReservationDB();
        return instance;
    }

    // write the current arraylist data of menu/orders into the text file for future usage
    public void saveData(ArrayList<Reservation> arr) {
        try {
            String lineSep = System.lineSeparator();

            FileWriter fw = new FileWriter("Reservations.txt");
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
            BufferedReader reader = new BufferedReader(new FileReader("Reservations.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(" ");
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                arr.add(new Reservation(Integer.parseInt(split[1]), Integer.parseInt(split[2]), Boolean.parseBoolean(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]), formatter.parse(split[6]), formatter.parse(split[7]), Enum.valueOf(Reservation.statusType.class, split[8]), split[9]));
            }
            reader.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
