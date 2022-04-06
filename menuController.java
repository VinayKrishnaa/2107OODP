package sce.cz2002.project;


/* Controller class of model menuItem and view menuUI/HotelView */

import java.util.ArrayList;

public class menuController{
	ArrayList<menuItem> menuItems;
    ArrayList<menuItem> orders;
    public int numMenuItem = 0;
    public static menuController instance = null;
    
    // initialize menu and order array list
    public menuController() {
    	menuItems = new ArrayList<menuItem>();
    	orders = new ArrayList<menuItem>();
	}
    
    // function to create instance of the constructor menuController
    public static menuController createInstance() {
    	if (instance == null)
    		instance = new menuController();
    	return instance;
    }

    // update all variables of selected menu item 
	public void updateMenu(int index, String name, String description, float price, int preparationTime) {
		menuItems.get(index).setName(name);
		menuItems.get(index).setPrice(price);
		menuItems.get(index).setDescription(description);
		menuItems.get(index).setPreparationTime(preparationTime);
    }

	// remove an item from the menu
	public void removeItem(int index){
		menuItems.remove(index);
		numMenuItem--;
    }

	// add an item into the menu
    public void createItem(String name, String description, float price, int preparationTime){
    	menuItems.add(new menuItem(name, description, price, preparationTime));
    	numMenuItem++;
    }

    // select an item from the menu and add it into order list
    public void orderItem(int index, int roomID){
    	orders.add(menuItems.get(index));
    }
    
    // prints out current running orders 
    public void currentOrders(){
    	System.out.println(orders);
    }
    
    // prints out menu 
    /*public void printMenu() {
    	int index = 0;
    	for (menuItem menu: menuItems) {
    		System.out.println("Item " + (index++) + ": " + menuItems);
    	}
    }*/
    
    public void printMenu(ArrayList<menuItem> arr) {
    	System.out.println(arr.size());
    	int index = 0;
    	for (index = 0; index < arr.size(); index++) {
    		System.out.println("Item " + index + ":" +
			    				"{Name: " + arr.get(index).getName() + "\n" +
			    				"Description: " + arr.get(index).getDescription() + "\n" +
			    				"Price: $" + arr.get(index).getPrice() + "\n" +
			    				"Preparation Time: " + arr.get(index).getPreparationTime() + "mins}\n");
    	}
    }
   
}
