package lab8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class labEight {
	private static Scanner kbd = new Scanner(System.in);
	public static void main(String [] args) {
		
		String [] name = {"Noah Slavik", "Randolph Schriener", "William Trigona", "Dylan Walsh","Harley Johnson","Tom Rowland","Kevin Barclay"," Ashley Newman","Bailie Richard","Golam Chowdhury", "Faizan Alam" };
		String [] homeTown = {"Birch Run", "Flint", "Saginaw", "Detriot","Jackson","Warren","Ann Arbor","Yspilanti","Muskegon","Toledo", "Ferndale" };
		String [] favoriteFood = {"Tacos", "Pizza", "Lobster", "Steak Medium-Rare","Fettucine Alfredo","Salmon Salad","Burger and fries"," Chicken noodle soup","scallop risotto","chicken and waffles", "pineapple cocount curry" };
		
		doSomething(name,homeTown, favoriteFood);
	}
	
	private static boolean doesUserWantToContinue() {
		System.out.print("Continue? (y/n): ");
		return kbd.next().startsWith("y");
	}		
	public static void printPrompt() {
		System.out.println("Enter a number 1-10, I'll tell you about that student: ");
	}
	
	public static void doSomething(String [] name, String [] homeTown, String [] favoriteFood) {
	try {
		do {	
			printPrompt();
			int userInput = kbd.nextInt();
			userInput = userInput - 1;
			
		
			String studentName = name[userInput];
			System.out.println("Student " + (userInput + 1) + " is " + studentName + ". What would you like to know about " + studentName + "?");
			
			kbd.nextLine();
			String secondUserInput = kbd.nextLine();
			if(secondUserInput.equalsIgnoreCase("hometown")) {
				System.out.print(studentName + " is from " + homeTown[userInput] + ". ");
				
				
			}
			else if(secondUserInput.equalsIgnoreCase("favorite food")) {
				System.out.print(studentName + "s favorite food is " + favoriteFood[userInput] + ". ");
			}
			else {
				System.out.println("You entered an unknown value, think about it and start over.");
				doSomething(name,homeTown, favoriteFood);
			}
			
		}while(doesUserWantToContinue());
	
	}catch(ArrayIndexOutOfBoundsException iob) {
		System.out.println("That student does not exist. Please try again. (enter a number 1-10): ");
		doSomething(name,homeTown,favoriteFood);
	}catch(InputMismatchException mis) {
	 	System.out.println("Try another value of the correct type please!");
	 	kbd.next();
	 	doSomething(name,homeTown,favoriteFood);
	}
	
}	
}
