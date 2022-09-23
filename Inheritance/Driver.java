
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	private static ArrayList<Dog> dogList = new ArrayList<Dog>();
	private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
	// Instance variables (if needed)

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int counter = 0;
		String userInput;
		initializeDogList();
		initializeMonkeyList();
		// Add a loop that displays the menu, accepts the users input
		// and takes the appropriate action.
		// For the project submission you must also include input validation
		// and appropriate feedback to the user.
		// Hint: create a Scanner and pass it to the necessary
		// methods
		// Hint: Menu options 4, 5, and 6 should all connect to the printAnimals()
		// method.
		displayMenu();
		while (counter == 0) {
			userInput = scnr.nextLine();
			if (userInput.compareTo("q") == 0) {
				System.out.println("Closing Application");
				counter++;
			}

			else if(userInput.compareTo("1") == 0) { 
				intakeNewDog(scnr);	
			}
			else if (userInput.compareTo("2") == 0) {
				intakeNewMonkey(scnr);
			}
			else if (userInput.compareTo("3") == 0) {
				reserveAnimal(scnr);
			}
			else if (userInput.compareTo("4") == 0) {
				printAnimals();
			}
			else if (userInput.compareTo("5") == 0) {
				System.out.println("This option needs to be implemented");
			}
			else if (userInput.compareTo("6") == 0) {
				System.out.println("This option needs to be implemented");
			}
			else {
				System.out.println("Invalid Input, must be between 1-6. Try again.");

			}
		}
	}

	// This method prints the menu options
	public static void displayMenu() {
		System.out.println("\n\n");
		System.out.println("\t\t\t\tRescue Animal System Menu");
		System.out.println("[1] Intake a new dog");
		System.out.println("[2] Intake a new monkey");
		System.out.println("[3] Reserve an animal");
		System.out.println("[4] Print a list of all dogs");
		System.out.println("[5] Print a list of all monkeys");
		System.out.println("[6] Print a list of all animals that are not reserved");
		System.out.println("[q] Quit application");
		System.out.println();
		System.out.println("Enter a menu selection");
	}

	// Adds dogs to a list for testing
	public static void initializeDogList() {
		Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake",
				false, "United States");
		Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false,
				"United States");
		Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true,
				"Canada");

		dogList.add(dog1);
		dogList.add(dog2);
		dogList.add(dog3);
	}

	// Adds monkeys to a list for testing
	// Optional for testing
	public static void initializeMonkeyList() {
		Monkey monkey1 = new Monkey("Herold", "male", "2", "22.6", "Capuchin", "10.20", "5.22",
				"10.65");
		Monkey monkey2 = new Monkey("George", "male", "3", "21.6", "Capuchin", "10.18", "5.25",
				"10.66");
		Monkey monkey3 = new Monkey("Macy", "female", "1", "27.6", "Capuchin", "10.17", "5.15",
				"10.65");

		monkeyList.add(monkey1);
		monkeyList.add(monkey2);
		monkeyList.add(monkey3);

	}

	// Complete the intakeNewDog method
	// The input validation to check that the dog is not already in the list
	// is done for you
	public static void intakeNewDog(Scanner scanner) {
		String name;
		String breed;
		String gender;
		String age;
		String weight;
		String acquisitionDate;
		String acquisitionLocation;
		String trainingStatus;
		String reserved;
		boolean isReserved = false;
		String inServiceCountry;
		int counter = 0;
		System.out.println("What is the dog's name?");
		name = scanner.nextLine();
		while(counter == 0) {
			for (Dog dog : dogList) {
				if (dog.getName().equalsIgnoreCase(name)) {
					System.out.println("\n\nThis dog is already in our system\n\n");
					displayMenu();
					return; // returns to menu
				}
			}
			// Add the  code to instantiate a new dog and add it to the appropriate list
			if(name.isBlank() == false) {
				counter++;
			}
			else {
				System.out.println("Please enter characters for name, cannot leave blank");
				name = scanner.nextLine();
			}
		}
		System.out.println("What is the dog's breed?");
		breed = scanner.nextLine();
		while(counter == 1) {
			if(breed.isBlank() ==  false) {
				counter++;
			}
			else {
				System.out.println("Please enter characters for breed type");
				breed = scanner.nextLine();
			}
		}
		System.out.println("What it the dog's gender?");
		gender = scanner.nextLine();
		while(counter == 2) {
			if(gender.compareToIgnoreCase("male") == 0 || gender.compareToIgnoreCase("female") == 0) {
				counter++;
			}
			else {
				System.out.println("Please enter male or female for gender.");
				gender = scanner.nextLine().trim();
			}
		}
		System.out.println("What is the dog's age?");
		age = scanner.nextLine();
		while(counter == 3) {
			int countLetters = 0;
			for(int i  = 0; i < age.length(); i++) {
				if(Character.isDigit(age.charAt(i)) == false || age.charAt(0) == '0') {
					countLetters++;
				}
			}
			if(countLetters > 0 || age.isEmpty() == true) {
				System.out.println("Invalid input, only  whole numbers excluding zero.");
				age = scanner.nextLine().trim();
			}
			else {
				counter++;
			}
		}
		System.out.println("What is the dog's weight?");
		weight = scanner.nextLine();
		while(counter == 4) {
			int countLetters = 0;
			for(int i  = 0; i < weight.length(); i++) {
				if(Character.isDigit(weight.charAt(i)) == false && weight.charAt(i) != '.' || weight.charAt(0) == '0'
						|| weight.endsWith(".") || weight.isEmpty() == true) {
					countLetters++;
				}
			}
			if(countLetters > 0 || weight.isEmpty() == true || weight.contains(".") == false) {
				System.out.println("Invalid input, only numbers excluding zero, decimal needed.");
				weight = scanner.nextLine();
			}
			else {
				counter++;
			}
		}
		System.out.println("What is the dog's acquisition date?");
		acquisitionDate = scanner.nextLine();		
		while(counter == 5) {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			try {

				@SuppressWarnings("unused")
				LocalDate date = LocalDate.parse(acquisitionDate, format);
				counter++;
			}
			catch (IllegalArgumentException e) {
				System.out.println("Invalid input, format must be dd-mm-yyyy");
				acquisitionDate = scanner.nextLine();
			}
			catch (DateTimeParseException e) {
				System.out.println("Invalid input, format must be dd-mm-yyyy");
				acquisitionDate = scanner.nextLine();
			}
		}
		System.out.println("Where did you acquire this dog?");
		acquisitionLocation = scanner.nextLine();
		while(counter == 6) {
			if(acquisitionLocation.isBlank() ==  false) {
				counter++;
			}
			else {
				System.out.println("Please enter valid location");
				acquisitionLocation = scanner.nextLine();
			}
		}
		System.out.println("Please enter the training status of dog");
		trainingStatus = scanner.nextLine();
		while(counter == 7) {
			if(trainingStatus.compareToIgnoreCase("Phase I") == 0 ||
					trainingStatus.compareToIgnoreCase("Phase II") == 0 || trainingStatus.compareToIgnoreCase("Phase III") == 0 ||
					trainingStatus.compareToIgnoreCase("Phase IV") == 0){
				counter++;
			}
			else if (trainingStatus.compareToIgnoreCase("Phase V") == 0) {
				trainingStatus = "in-service";
				counter++;
			}
			else {
				trainingStatus = "farm";
				counter++;
			}
		}
		System.out.println("Is this dog reserved");
		reserved = scanner.nextLine();
		while(counter == 8) {
			if(acquisitionLocation.isBlank() ==  true) {
				System.out.println("Invalid input, please try again");
				reserved = scanner.nextLine();
			}
			else if(reserved.compareToIgnoreCase("yes") == 0) {
				isReserved = true;
				counter++;
			}
			else if(reserved.compareToIgnoreCase("no")== 0) {
				isReserved = false;
				counter++;
			}
			else {
				System.out.println("Invalid input, please try again");
				reserved = scanner.nextLine();
			}
		}
		System.out.println("What is the inservice country of dog?");
		inServiceCountry = scanner.nextLine();
		while(counter == 9) {
			if(inServiceCountry.isBlank() ==  false) {
				counter++;
			}
			else {
				System.out.println("Please enter valid location");
				acquisitionLocation = scanner.nextLine();
			}
		}
		Dog dog1 = new Dog(name.trim(), breed.trim(), gender.trim(), age.trim(), 
				weight.trim(), acquisitionDate.trim(), acquisitionLocation.trim(),
				trainingStatus.trim(), isReserved, inServiceCountry.trim());
		dogList.add(dog1);
		printAnimals();
		displayMenu();
		return;
	}

	// Complete intakeNewMonkey
	// Instantiate and add the new monkey to the appropriate list
	// For the project submission you must also validate the input
	// to make sure the monkey doesn't already exist and the species type is allowed
	public static void intakeNewMonkey(Scanner scanner) {
		String name;
		String gender;
		String age;
		String weight;
		String species;
		String tailLength;
		String bodyHeight;
		String lengthBody;
		int counter = 0;
		System.out.println("What is the monkey's name?");
		name = scanner.nextLine().trim();
		while (counter == 0) {
			for (Monkey monkey : monkeyList) {
				if (monkey.getName().equalsIgnoreCase(name)) {
					System.out.println("\n\nThis monkey is already in our system\n\n");
					displayMenu();
					return; // returns to menu
				}
			}
			if(name.isBlank() == false) {
				counter++;
			}
			else {
				System.out.println("Please enter characters for name, cannot leave blank");
				name = scanner.nextLine().trim();
			}
		}
		System.out.println("What is the monkey's gender?");
		gender = scanner.nextLine().trim();
		while(counter == 1) {
			if(gender.compareToIgnoreCase("male") == 0 || gender.compareToIgnoreCase("female") == 0) {
				counter++;
			}
			else {
				System.out.println("Please enter male or female for gender.");
				gender = scanner.nextLine().trim();
			}
		}
		System.out.println("What is the monkey's age?");
		age = scanner.nextLine().trim();
		while(counter == 2) {
			int countLetters = 0;
			for(int i  = 0; i < age.length(); i++) {
				if(Character.isDigit(age.charAt(i)) == false || age.charAt(0) == '0') {
					countLetters++;
				}
			}
			if(countLetters > 0 || age.isEmpty() == true) {
				System.out.println("Invalid input, only  whole numbers excluding zero.");
				age = scanner.nextLine().trim();
			}
			else {
				counter++;
			}
		}
		System.out.println("What is the monkey's weight?");
		weight = scanner.nextLine().trim();
		while(counter == 3) {
			int countLetters = 0;
			for(int i  = 0; i < weight.length(); i++) {
				if(Character.isDigit(weight.charAt(i)) == false && weight.charAt(i) != '.' || weight.charAt(0) == '0'
						|| weight.endsWith(".") || weight.isEmpty() == true) {
					countLetters++;
				}
			}
			if(countLetters > 0 || weight.isEmpty() == true || weight.contains(".") == false) {
				System.out.println("Invalid input, only numbers excluding zero, decimal needed.");
				weight = scanner.nextLine().trim();
			}
			else {
				counter++;
			}
		}
		System.out.println("What is the monkey's species type?");
		species = scanner.nextLine().trim();
		while(counter == 4) {
			if(species.compareToIgnoreCase("Capuchin") == 0 ||species.compareToIgnoreCase("Guenon") == 0 
					|| species.compareToIgnoreCase("Macaque") == 0 || species.compareToIgnoreCase("Marmoset") == 0
					|| species.compareToIgnoreCase("Squirrel monkey") == 0 || species.compareToIgnoreCase("Tamarin") == 0
					) {
				counter++;
			}
			else {
				System.out.println("Invalid input, please retry from avaliable species refer to guide");
				species = scanner.nextLine().trim();
			}
		}
		System.out.println("What is the monkey's tail length?");
		tailLength = scanner.nextLine().trim();
		while(counter == 5) {
			int countLetters = 0;
			for(int i  = 0; i < tailLength.length(); i++) {
				if(Character.isDigit(tailLength.charAt(i)) == false && tailLength.charAt(i) != '.' || tailLength.charAt(0) == '0'
						|| tailLength.endsWith(".")) {
					countLetters++;
				}
			}
			if(countLetters > 0 || tailLength.isEmpty() == true || tailLength.contains(".") == false) {
				System.out.println("Invalid input, only numbers excluding zero, decimal needed.");
				tailLength = scanner.nextLine().trim();
			}
			else {
				counter++;
			}
		}
		System.out.println("What is the monkey's body height?");
		bodyHeight = scanner.nextLine().trim();
		while(counter == 6) {
			int countLetters = 0;
			for(int i  = 0; i < bodyHeight.length(); i++) {
				if(Character.isDigit(bodyHeight.charAt(i)) == false && bodyHeight.charAt(i) != '.' || bodyHeight.charAt(0) == '0' ||
						bodyHeight.endsWith(".")) {
					countLetters++;
				}
			}
			if(countLetters > 0 || bodyHeight.isEmpty() == true || bodyHeight.contains(".") == false) {
				System.out.println("Invalid input, only numbers excluding zero, decimal needed.");
				bodyHeight = scanner.nextLine().trim();
			}
			else {
				counter++;
			}
		}
		System.out.println("What is the monkey's body length?");
		lengthBody = scanner.nextLine().trim();
		while(counter == 7) {
			int countLetters = 0;
			for(int i  = 0; i < lengthBody.length(); i++) {
				if(Character.isDigit(lengthBody.charAt(i)) == false && lengthBody.charAt(i) != '.' || lengthBody.charAt(0) == '0'
						|| lengthBody.endsWith(".")) {
					countLetters++;
				}
			}
			if(countLetters > 0 || lengthBody.isEmpty() == true || lengthBody.contains(".") == false) {
				System.out.println("Invalid input, only numbers excluding zero, decimal needed.");
				lengthBody = scanner.nextLine().trim();
			}
			else {
				counter++;
			}
		}
		Monkey monkey1 = new Monkey(name.trim(), gender.trim(), age.trim(), weight.trim(), species.trim(), tailLength.trim(), bodyHeight.trim(),
				lengthBody.trim());
		monkeyList.add(monkey1);
		displayMenu();
		return;
	}

	// Complete reserveAnimal
	// You will need to find the animal by animal type and in service country
	public static void reserveAnimal(Scanner scanner) {
		String animalType;
		String serviceCountry;
		System.out.println("Please enter the animal type");
		animalType = scanner.nextLine();
		if(animalType.trim().compareToIgnoreCase("Capuchin") == 0 ||animalType.trim().compareToIgnoreCase("Guenon") == 0 
				|| animalType.trim().compareToIgnoreCase("Macaque") == 0 || animalType.trim().compareToIgnoreCase("Marmoset") == 0
				|| animalType.trim().compareToIgnoreCase("Squirrel monkey") == 0 || animalType.trim().compareToIgnoreCase("Tamarin") == 0
				) {
			System.out.println("Breed unavaliable.");
		}
		else {
			System.out.println("Please enter country in service");
			serviceCountry = scanner.nextLine();
			for(Dog dog : dogList) {
				if(dog.getBreed().compareToIgnoreCase(animalType.trim()) == 0 && 
						dog.getInServiceLocation().compareToIgnoreCase(serviceCountry.trim()) == 0 &&
						dog.getReserved() == false) {
					System.out.println(dog.getName() + " is avaliable to be reserved.");
					break;
				}
				else {
					System.out.println("There is no reserved animal under those specifications.");
					break;
				}
			}
		}
		displayMenu();
	}

	// Complete printAnimals
	// Include the animal name, status, acquisition country and if the animal is
	// reserved.
	// Remember that this method connects to three different menu items.
	// The printAnimals() method has three different outputs
	// based on the listType parameter
	// dog - prints the list of dogs
	// monkey - prints the list of monkeys
	// available - prints a combined list of all animals that are
	// fully trained ("in service") but not reserved
	// Remember that you only have to fully implement ONE of these lists.
	// The other lists can have a print statement saying "This option needs to be
	// implemented".
	// To score "exemplary" you must correctly implement the "available" list.
	public static void printAnimals() {
		for(Dog dog : dogList) {
			System.out.print(dog.getName() + " " + dog.getTrainingStatus() + " " + 
					dog.getAcquisitionLocation() + " " + dog.getReserved());
			System.out.println("");
		}
		displayMenu();
	}
}


