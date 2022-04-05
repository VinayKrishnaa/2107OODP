package sce.cz2002.project;

/*Class to read and write menu to a text file. 
 * Data saved here even when program is not running. */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
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
			
			FileWriter fw = new FileWriter("menu.txt", true);
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
	public void readData() {
		try {
		    FileInputStream fstream = new FileInputStream("menu.txt");
		    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		    String line = br.readLine();
		    
		    // Read File Line By Line
		    while (line != null) {
		        System.out.println(line);     
		        line = br.readLine();
		    }
		    // Close the input stream
		    br.close();       
		} catch (Exception ex) {// Catch exception if any
		    ex.printStackTrace();
		}
	}
}

