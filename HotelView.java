package sce.cz2002.project;

/* Overall app for the hotel management system.*/

import java.util.Scanner;
import java.io.IOException;
import java.time.LocalDate;

public class HotelView{

	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to W Hotel!");
		System.out.println("Please enter your option: ");
		System.out.println("|1. View hotel administrative information.");
		System.out.println("|2. Guest stay functions.");
		System.out.println("|3. Hotel adminstration procedures.");
		System.out.println("|4. Save and exit menu");
		
		Scanner sc = new Scanner(System.in);
		do {
			switch(sc.nextInt()) {
			case 1:
				System.out.println("|1. View current reservation list.");
				System.out.println("|2. View current guest list.");
				System.out.println("|3. View past billing information.");
				System.out.println("|4. View room status");
				switch(sc.nextInt()) {
				case 1: 
					break;
				case 2: 
					break;
				case 3:
					break;
				case 4:
					break;
				}
			case 2:
				System.out.println("|1. Check in");
				System.out.println("|2. Check out");
				System.out.println("|3. Walk-in guest");
				switch(sc.nextInt()) {
				case 1: 
					break;
				case 2: 
					break;
				case 3:
					break;
				}
				break;
			case 3:
				System.out.println("|1. Update room status.");
				System.out.println("|2. Order room service");
				switch(sc.nextInt()) {
				case 1: 
					break;
				case 2: 
					MenuUI.getinstance().displayOptions();
					break;
				case 3:
					break;
				}
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("Please enter a valid option!");
			}
		} while (true);
	}

}
