package sce.cz2002.project;

/* View for Model menuItem and controller menuController*/

import java.io.IOException;
import java.util.Scanner;

public class MenuUI{

	public static MenuUI instance = null;
	
	public MenuUI() {
	}
	
	// create instance of menuUI
	public static MenuUI getinstance() {
		if (instance == null)
			instance = new MenuUI();
		return instance;
	}
	
	menuController m = new menuController();
	
	// display all available options of menuUI
	public void displayOptions() throws IOException {
		menuController.createInstance();
		MenuDB.getInstance().readData(m.menuItems);
		OrderDB.getInstance().readData(m.orders);
		Scanner sc = new Scanner(System.in);
		try {
			do {
				System.out.println("Please select your option");
				System.out.println("(1) Add menu item");
				System.out.println("(2) Update menu item");
				System.out.println("(3) Remove menu item");
				System.out.println("(4) Order room service");
				System.out.println("(5) Update order status");
				System.out.println("(6) Show current orders");
				System.out.println("(7) Show menu");
				System.out.println("(8) Exit");
				switch(sc.nextInt()) {
					case 1:									// add new item to menu
						System.out.println("Enter name of item");
						System.out.println("Enter description of item");
						System.out.println("Enter price of item");
						m.createItem(sc.next(), sc.next(), sc.nextInt());
						MenuDB.getInstance().saveData(m.menuItems);
						break;
					case 2:									// update a menu item
						System.out.println("Enter index of item to update");
						System.out.println("Enter new name of item");
						System.out.println("Enter new description of item");
						System.out.println("Enter new price of item");
						System.out.println("Enter new preparation time of item (in minutes)");
						m.updateMenu(sc.nextInt(), sc.next(), sc.next(), sc.nextInt());
						MenuDB.getInstance().saveData(m.menuItems);
						break;
					case 3:									// remove a menu item
						System.out.println("Enter index of item to remove");
						m.removeItem(sc.nextInt());
						MenuDB.getInstance().saveData(m.menuItems);
						break;
					case 4:									// order room service
						m.printMenu(m.menuItems);
						System.out.println("Enter index of item to order");
						System.out.println("Enter room ID");
						System.out.println("Enter special remarks");
						int index = sc.nextInt();
						int roomID = sc.nextInt();
						sc.nextLine();
						m.orderItem(index, roomID, sc.nextLine(), m.menuItems);
						OrderDB.getInstance().saveData(m.orders);
						break;
					case 5:									// update order status
						System.out.println("Enter ID of order to update status");
						System.out.println("Enter status to be updated to:");
						System.out.println("(1) Confirmed\n(2) Preparing\n(3) Delivered");
						m.updateOrder(sc.nextInt(), sc.nextInt());
						OrderDB.getInstance().saveData(m.orders);
						// call billing over here to update payment
						break;
					case 6:									// show current orders
						m.currentOrders();
						break;
					case 7:									// print menu
						m.printMenu(m.menuItems);
						break;
					case 8:
						System.exit(0);
						break;
					default:
						System.out.println("Please enter a valid number!");
						break;
				}
			} while (true);
		}	finally {
			sc.close();
			}
		}
}
