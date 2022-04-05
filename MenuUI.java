package sce.cz2002.project;

/* View for Model menuItem and controller menuController*/

import java.io.IOException;
import java.util.Scanner;

public class MenuUI{
	public static MenuUI instance = null;
	
	public MenuUI() {
		Scanner sc = new Scanner(System.in);
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
		Scanner sc = new Scanner(System.in);
		try {
			do {
				System.out.println("Please select your option");
				System.out.println("(1) Add menu item");
				System.out.println("(2) Update menu item");
				System.out.println("(3) Remove menu item");
				System.out.println("(4) Order room service");
				System.out.println("(5) Show current orders");
				System.out.println("(6) Show menu");
				System.out.println("(7) Exit");
				switch(sc.nextInt()) {
					case 1:
						System.out.println("Enter name of item");
						System.out.println("Enter description of item");
						System.out.println("Enter price of item");
						System.out.println("Enter preparation time of item (in minutes)");
						m.createItem(sc.next(), sc.next(), sc.nextInt(), sc.nextInt());
						MenuDB.getInstance().saveData(m.menuItems);
						break;
					case 2:
						System.out.println("Enter name of item to update");
						System.out.println("Enter new description of item");
						System.out.println("Enter new price of item");
						System.out.println("Enter new preparation time of item (in minutes)");
						m.updateMenu(sc.next(), sc.next(), sc.nextInt(), sc.nextInt());
						MenuDB.getInstance().saveData(m.menuItems);
						break;
					case 3:
						System.out.println("Enter name of item to remove");
						m.removeItem(sc.next());
						MenuDB.getInstance().saveData(m.menuItems);
						break;
					case 4:
						m.printMenu();
						System.out.println("Enter ID of item to order");
						System.out.println("Enter room ID");
						m.orderItem(sc.nextInt(), sc.nextInt());
						break;
					case 5:
						m.currentOrders();
						break;
					case 6:
						MenuDB.getInstance().readData();
						break;
					case 7:
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
