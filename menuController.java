package sce.cz2002.project;


/* Controller class of model menuItem and view menuUI/HotelView */

import java.util.ArrayList;

public class menuController{
	ArrayList<menuItem> menuItems;
    ArrayList<OrderItem> orders;
    public int numMenuItem = 0;
    public static menuController instance = null;
    
    // initialize menu and order array list
    public menuController() {
    	menuItems = new ArrayList<menuItem>();
    	orders = new ArrayList<OrderItem>();
	}
    
    // function to create instance of the constructor menuController
    public static menuController createInstance() {
    	if (instance == null)
    		instance = new menuController();
    	return instance;
    }

    // update all variables of selected menu item 
	public void updateMenu(int index, String name, String description, float price) {
		menuItems.get(index).setName(name);
		menuItems.get(index).setPrice(price);
		menuItems.get(index).setDescription(description);
    }

	// remove an item from the menu
	public void removeItem(int index){
		menuItems.remove(index);
		numMenuItem--;
    }

	// add an item into the menu
    public void createItem(String name, String description, float price){
    	menuItems.add(new menuItem(name, description, price));
    	numMenuItem++;
    }

    // select an item from the menu and add it into order list
    public void orderItem(int index, int roomID,  String remarks){
    	orders.add(new OrderItem(menuItems.get(index).getName(), menuItems.get(index).getPrice(), roomID, "Confirmed", remarks));
    	OrderDB.getInstance().saveData();
    }
    
    // prints out current running orders 
    public void currentOrders(){
    	System.out.println(orders);
    }
    
 // remove an item from the order list
 	public void removeOrder(int index){
 		orders.remove(index);
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

	// update status of order
	public void updateOrder(int index, int status) {
		switch(status){
			case 1:
				orders.get(index).setStatus("Confirmed");
				break;
			case 2:
				orders.get(index).setStatus("Preparing");
				break;
			case 3:
				orders.get(index).setStatus("Delivered");
				break;
			default:
				System.out.println("Please enter a valid option!");
				break;
		}
	}
}
