package DB;

/*Class to read and write menu to a text file.
 * Data saved here even when program is not running.
 * currently, does not work properly */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.sql.Date;
import java.util.ArrayList;
import Controller.GuestController;
import Class.Guest;

public class GuestDB {

    // Delimiter for data in text file.
    public static final String SEPARATOR = "|";

    //create instance of guestDB
    public static GuestDB instance = null;
    public static GuestDB getInstance() {
        if (instance == null)
            instance = new GuestDB();
        return instance;
    }

    // write the current arraylist data
    public static ArrayList saveData(String filename, ArrayList<Guest> arr) {
        try {
            //String lineSep = System.lineSeparator();

            FileWriter fw = new FileWriter("guest.txt");
            Writer output = new BufferedWriter(fw);

            for (int i = 0; i < arr.size(); i++) {
                //output.write(arr.get(i).toString() + lineSep);
                output.write(arr.get(i).toString() + SEPARATOR);
            }
            output.close();

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return arr;
    }

    // read the data from text file and add into guest arraylist
    public static ArrayList readData(ArrayList<Guest> arr) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("guest.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                //String[] split = line.split(" "); // space??
                String[] split = line.split("|");
                arr.add(new Guest(split[1],split[2],split[3],Boolean.parseBoolean(split[4]),split[5],
                        Integer.parseInt(split[6]),split[7],Integer.parseInt(split[8]),
                        split[9], split[10],Integer.parseInt(split[11])));
            }
            reader.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return arr;
    }
}
