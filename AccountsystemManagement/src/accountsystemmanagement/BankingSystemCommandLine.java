/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountsystemmanagement;

/**
 *
 * @author manas
 */
import java.util.Scanner;
import java.util.Date;
import java.util.InputMismatchException;

public class BankingSystemCommandLine {
	

	private static Scanner scanner = new Scanner(System.in);
	private static boolean exitProgram = false;
    private static boolean exitAccountLoop = false;
    private static boolean exitClientLoop = false;
	private static IBankingSystemController controller;
    
    BankingSystemCommandLine(IBankingSystemController controller){
    	BankingSystemCommandLine.controller = controller;
    }
    
	public void commandLoop(){
	while(exitProgram == false){
		
		try{
		
		System.out.println("1. Add Customer\n" + "2. Manage a customer\n" + "3. arrange All Customers\n" + "4. Remove Customer\n" + "5. Exit");
		int userSelection = scanner.nextInt();
		scanner.nextLine();
			
		//add a client
		if(userSelection == 1){
			addClient();	
		}

		//Manage a client
		if(userSelection == 2){
			System.out.println("Enter a Customer ID: ");
			int clientID = scanner.nextInt();
			if(controller.checkClient(clientID) == false){
				System.err.println("Error: Customer Doesn't Exit");
			}
			else{
			
			//display client information
			System.out.println(controller.viewClient(clientID));
			
			//Start client loop
			exitClientLoop = false;
			while(exitClientLoop == false){
			
			System.out.println("1. Create Account" + "\n2. Manage Account" + "\n3. Remove Account" + "\n4. Sort Accounts" + "\n5. Back to Main Menu");
			userSelection = scanner.nextInt();
			
			if(userSelection == 1){
				System.out.println("1. Checking Account\n" + "2. Savings Account");
				    userSelection = scanner.nextInt();
				
				if(userSelection == 1){
					createChecking(clientID);
					clientLoop();
				}
				if(userSelection == 2){
					createSavings(clientID);
					clientLoop();
				}	
			}
			//Manage an Account
			else if(userSelection == 2){
				exitAccountLoop = false;
				System.out.println("Enter an Account Number");
				int accountNumber = scanner.nextInt();
				
				//start account loop
				while(exitAccountLoop == false){
					
					System.out.println("1. Deposit\n" + "2. Withdraw\n" + "3. Cash Check (Checking Account Only)\n" + "4. View Account\n" + "5. Exit Account");
					    userSelection = scanner.nextInt();
					
					if(userSelection == 1){
						deposit(clientID, accountNumber);
						accountLoop();
					}
					else if(userSelection == 2){
						withdraw(clientID, accountNumber);
						accountLoop();
					}
					else if(userSelection == 3){
						cashCheck(clientID,accountNumber);
						accountLoop();
					}
					else if(userSelection == 4){
						System.out.println(controller.viewAccount(clientID, accountNumber));
						accountLoop();
					}
					else if(userSelection == 5){
						exitAccountLoop = true;
					}
				}//end account loop
			}	
			
			else if(userSelection == 3){
				removeAccount(clientID);
				clientLoop();
			}	
			else if(userSelection == 4){
				sortAccounts(clientID);
				clientLoop();
				}
			else if(userSelection == 5){
				exitClientLoop = true;
			}
			}//end client loop
			}
		}
		
		else if(userSelection == 3){
			sortClient();
		}
		
		else if(userSelection == 4){
			removeClient();
			exitClientLoop = true;
		}
		else if(userSelection == 5){
			System.out.print("Transaction was sucessful");
			exitProgram = true;
		}
		}
		catch (InputMismatchException e)
		{
		    System.err.println("Error. Try again.");
		    scanner.next();
		    exitProgram = false;
		}
	}
	}

	public static boolean clientLoop(){
		System.out.println("Do you wish to continue with this customer? (Y/N)");
		String userResponse = scanner.next();
		if(userResponse.equalsIgnoreCase("y")){
			exitClientLoop = false;
		}
		else if(userResponse.equalsIgnoreCase("n")){
			exitClientLoop = true;
			return exitClientLoop;
		}
		else{
			System.err.println("Error: Try Again");
			exitClientLoop = true;
		}
		return exitClientLoop;
	}
		
	public static boolean accountLoop(){
		System.out.println("Do you wish to continue in this account? (Y/N)");
		String userResponse = scanner.next();
		if(userResponse.equalsIgnoreCase("y")){
			exitAccountLoop = false;
		}
		else if(userResponse.equalsIgnoreCase("n")){
			exitAccountLoop = true;
			return exitAccountLoop;
		}
		else{
			System.err.println("Error: Try Again");
			exitClientLoop = true;
		}
		return exitAccountLoop;
	}
	
	public static void addClient(){
		String firstName;
		String lastName;
		String address;	
		
		System.out.println("First Name: ");
		firstName = scanner.nextLine();
		System.out.println("Last Name: ");
		lastName = scanner.nextLine();
		System.out.println("Address: ");
		address = scanner.nextLine();	
		Date dateOfBirth = getDateOfBirth();
		
		System.out.println(controller.addClient(firstName,lastName, dateOfBirth ,address, new Date()));
		System.out.println("The coustmer " + firstName + " "+ lastName + " has been added\n");
	}
	
	@SuppressWarnings("deprecation")
	public static Date getDateOfBirth(){
		String[] temp;
		Date dateOfBirth = null;
		boolean loop;
		while(loop = true){
			try{
				System.out.println("Enter Birth Year: month/day/year");
				temp = scanner.nextLine().split("/");
				int month = Integer.parseInt(temp[0]);
				int day = Integer.parseInt(temp[1]);
				int year = Integer.parseInt(temp[2]);
				dateOfBirth = new Date(year-1900,month-1,day);
				loop = false;
				return dateOfBirth;
		}
		catch(NumberFormatException | ArrayIndexOutOfBoundsException e){
			System.err.println("Error: Try again");
			loop = true;
		}
	}
		return dateOfBirth;
	}
	
	
	public static void deposit(int clientID, int accountNumber){
		double amount;
		
		System.out.println("Enter Amount: ");
		amount = scanner.nextDouble();
		controller.deposit(clientID,accountNumber, amount);	
		System.out.println("The amount of $" + amount + " has been deposited in your account");
	}
	
	public static void withdraw(int clientID, int accountNumber){
		double amount;
		
		System.out.println("Enter Amount: ");
		amount = scanner.nextDouble();
		
		if(controller.withdraw(clientID,accountNumber, amount) == true){
			controller.withdraw(clientID, accountNumber, amount);
			System.out.println("The amount of $" + amount + " has been withdrawn from your account");
		}
		else
			System.out.println("There is not enough money in your account");
	}
	
	public static void cashCheck(int clientID, int accountNumber){
		int amount;
		
		System.out.println("Enter the amount of the check");
		amount = scanner.nextInt();
		controller.cashCheck(clientID, accountNumber, amount);
		System.out.println("A check for the amount of $" + amount + " has been cashed");
	}
	
	public static void removeAccount(int clientID){
		System.out.println("Enter the Account Number to be closed");
		int accountNumber = scanner.nextInt();
		controller.closeAccount(clientID, accountNumber);
		System.out.println("The account has been closed");
	}
	
	public static void removeClient(){
		System.out.println("Enter the Coustmer ID to be removed:");
		int clientID = scanner.nextInt();
		controller.removeClient(clientID);
		System.out.println("The Coustmer has been removed");
	}
	
	public static void createSavings(int clientID){
		System.out.println("Enter an interest rate: ");
		double interestRate = scanner.nextDouble();
		controller.addSavingsAccount(clientID, interestRate);
		System.out.println("Savings Account has been created");
	}
	
	public static void createChecking(int clientID){
		controller.addCheckingAccount(clientID);
		System.out.println("Checking Account has been created");	
	}
	
	public static void sortClient(){
		System.out.print("1. Sort by Account Number\n" + "2. Sort by First Name\n" + "3. Sort by Last Name\n" + "4. Sort by Creation Date\n");
		int userResponse = scanner.nextInt();
		scanner.nextLine();
		if(userResponse == 1){
			System.out.println(controller.sortClientID() + "\n");
		}
		else if(userResponse == 2){
			System.out.println(controller.sortClientFirstName() + "\n");
		}
		else if(userResponse == 3){
			System.out.println(controller.sortClientLastName() + "\n");
		}
		else if(userResponse == 4){
			System.out.println(controller.sortCreationDate() + "\n");
		}
	}
	public static void sortAccounts(int clientID){
		System.out.println("1. Sort by Balance\n" + "2. Sort by Account Number");
		int userResponse = scanner.nextInt();
		scanner.nextLine();
		if(userResponse == 1){
			System.out.println(controller.getClient(clientID).sortAccountBalance() + "\n");
		}
		else if(userResponse == 2){
			System.out.println(controller.getClient(clientID).sortAccountNumber() + "\n");

		}
	}
}
