package sce.cz2002.project;

/*Class to read and write menu to a text file. 
 * Data saved here even when program is not running. */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;


public class MenuDB {
	// create instance of menuDB
	public static MenuDB instance = null;
	public static MenuDB getInstance() {
		if (instance == null)
			instance = new MenuDB();
		return instance;
	}
	
	// write the current arraylist data of menu/orders into the text file for future usage
	public void saveData(ArrayList<menuItem> arr) {
		try {
			String lineSep = System.lineSeparator();
			
			FileWriter fw = new FileWriter("menu.txt");
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
	public void readData(ArrayList<menuItem> arr) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("menu.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
			    String[] split = line.split(" ");
			    arr.add(new menuItem(split[1], split[2], Float.parseFloat(split[3]), Integer.parseInt(split[4]))); 
			}
			reader.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}

