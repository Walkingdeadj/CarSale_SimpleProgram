import java.util.List;
import java.util.Scanner;

import controller.CarListHelper;
import model.CarList;

import model.Buyer;
import controller.BuyerHelper;

public class Connection_Tester {

		static Scanner in = new Scanner(System.in);
		static CarListHelper carHelp = new CarListHelper();
		static BuyerHelper buyHelp = new BuyerHelper();

		private static void addAnItem() {
			System.out.print("Enter the make: ");
			String make = in.nextLine();
			//in.nextLine();
			System.out.print("Enter the model: ");
			String model = in.nextLine();
			CarList toAdd = new CarList(model, make);//create list item
			carHelp.insertCar(toAdd);//insert list item into the helper

		}

		/*private static void deleteAnItem() {
			System.out.print("Enter what number they were: ");
			int num = in.nextInt();
			in.nextLine();
			System.out.print("Enter thier name: ");
			String name = in.nextLine();
			CarList toDelete=new CarList(num, name);//create list item
			carHelp.deleteCarList(toDelete);
		}

		private static void editAnItem() {
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Number");
			System.out.println("2 : Search by Name");
			int searchBy = in.nextInt();
			List<CarList> foundPres;
			if (searchBy == 1) {
				System.out.print("Enter	the CarList number:	");
				int num = in.nextInt();
				foundPres =	carHelp.searchForCarListByNum(num);				
				
			} else {
				System.out.print("Enter the CarList name:	");
				String presName = in.nextLine();
				foundPres =	carHelp.searchForCarListByName(presName);
			}

			if (!foundPres.isEmpty()) {
				System.out.println("Found Results.");
				for (CarList p : foundPres) {
					System.out.println(p.getId() + " : " + p.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				CarList toEdit = carHelp.searchForCarListById(idToEdit);
				System.out.println("Retrieved " + toEdit.getName() + ", #" + toEdit.getPresidencyNumber());
				System.out.println("1 : Update Name");
				System.out.println("2 : Update Number");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Name: ");
					String newName = in.nextLine();
					toEdit.setName(newName);
				} else if (update == 2) {
					System.out.print("New Presidency Number: ");
					int newNum = in.nextInt();
					toEdit.setPresidencyNumber(newNum);
				}

				carHelp.updateCarList(toEdit);

			} else {
				System.out.println("---- No results found :(");
			}
		}*/

		public static void main(String[] args) {
			runController();
		}

		public static void runController() {
			boolean goAgain = true;
			System.out.println("--- Welcome to Car registery ---");
			while (goAgain) {
				System.out.println("\n\n\nSelect an option:");
				System.out.println("Add Buyer -1");				
				System.out.println("View Car List -2");
				System.out.println("Register Car -3");
				System.out.println("View Buyers - 4");
				System.out.println("Exit registery -5");
				System.out.print("*  Your choice: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					//editAnItem();					
				} else if (selection == 2) {
					viewTheList();
				} else if (selection == 3) {
					addAnItem();
				} else if (selection == 4) {
					veiwBuyers();
				} else {
					carHelp.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}
		
		private static void veiwBuyers() {
			List<Buyer> allBuyers = buyHelp.showAllBuyers();
			for(Buyer singleItem :	allBuyers){
			System.out.println(singleItem.returnBuyerDetails());
			}				
		}

		private static void viewTheList() {
			List<CarList>	allItems	=	carHelp.showAllCars();
			for(CarList singleItem :	allItems){
			System.out.println(singleItem.returnCarDetails());
			}			
		}

	}
