import java.util.List;
import java.util.Scanner;

import controller.CarListHelper;
import model.CarList;

public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static CarListHelper lih = new CarListHelper();

	private static void addAnCar() {
		// TODO Auto-generated method stub
		System.out.print("Enter a model: ");
		String model = in.nextLine();
		System.out.print("Enter an make: ");
		String make = in.nextLine();
		
		CarList toAdd = new CarList(model, make);
		lih.insertCar(toAdd);
	}

	private static void deleteAnCar() {
		// TODO Auto-generated method stub
		System.out.print("Enter the model to delete: ");
		String model = in.nextLine();
		System.out.print("Enter the make to delete: ");
		String make = in.nextLine();
		
		CarList toDelete = new CarList(model, make);
		lih.deleteCar(toDelete);

	}

	private static void editAnItem() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Model");
		System.out.println("2 : Search by Make");
		int searchBy = in.nextInt();
		in.nextLine();
		List<CarList> foundCars;
		if (searchBy == 1) {
			System.out.print("Enter the car's model: ");
			String model = in.nextLine();
			foundCars = lih.searchForCarByModel(model);
		} else {
			System.out.print("Enter the car's make: ");
			String make = in.nextLine();
			foundCars = lih.searchForCarByMake(make);
		}

		if (!foundCars.isEmpty()) {
			System.out.println("Found Results.");
			for (CarList c : foundCars) {
				System.out.println(c.getId() + " : " + c.returnCarDetails());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			CarList toEdit = lih.searchForCarById(idToEdit);
			System.out.println("Retrieved " + toEdit.getModel() + " from " + toEdit.getMake());
			System.out.println("1 : Update Model");
			System.out.println("2 : Update Make");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Model: ");
				String newModel = in.nextLine();
				toEdit.setModel(newModel);
			} else if (update == 2) {
				System.out.print("New Make: ");
				String newMake = in.nextLine();
				toEdit.setMake(newMake);
			}

			lih.updateCar(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to car list! ---");
		while (goAgain) {
			System.out.println("*  Select an car:");
			System.out.println("*  1 -- Add an car");
			System.out.println("*  2 -- Edit an car");
			System.out.println("*  3 -- Delete an car");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnCar();
			} else if (selection == 2) {
				editAnItem();
			} else if (selection == 3) {
				deleteAnCar();
			} else if (selection == 4) {
				viewTheList();
			} else {
				//lih.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		List<CarList> allCars = lih.showAllCars();
		for(CarList singleItem : allCars){
			System.out.println(singleItem.returnCarDetails());
		}
	}
}
