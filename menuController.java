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
	public void updateMenu(String name, String description, float price, int preparationTime) {
        for (menuItem menu: menuItems) {
        	if (menu.getName().contentEquals(name)) {
        		menu.setName(name);
        		menu.setPrice(price);
        		menu.setDescription(description);
        		menu.setPreparationTime(preparationTime);
        	}
        }
    }

	// remove an item from the menu
	public void removeItem(String name){
		menuItems.removeIf(m->m.getName() == name);
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
    public void printMenu() {
    	int index = 0;
    	for (menuItem menu: menuItems) {
    		System.out.println("Item " + (index++) + ": " + menuItems);
    	}
    }
   
}
