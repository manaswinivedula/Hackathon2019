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
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

public class Client extends Person implements IClient{
	
	private IPerson accountHolder;
	private int clientID;
	private Date timeCreated;
	private AccountNumberGenerator acctNum = new AccountNumberGenerator();
	AccountFactory accounts = new AccountFactory();
	HashMap<Integer, Account> accountList;
	
	public Client(){		
	}
	
	public Client(String firstName, String lastName, Date dateOfBirth, String address, int clientID, Date timeCreated){
		super(firstName, lastName, dateOfBirth, address);
		accountHolder = new Person(firstName,lastName,dateOfBirth,address);
		this.timeCreated = timeCreated;
		this.clientID = clientID;
		accountList = accounts.createAccount();
	}

	@Override
	public IPerson getAccountHolder() {
		return accountHolder;
	}

	@Override
	public int getClientID() {
		return clientID;
	}

	@Override
	public Date getTimeCreated() {
		return timeCreated;
	}

	@Override
	public void setTimeCreated(Date timeCreated) {
		this.timeCreated = timeCreated;
	}
	
	@Override
	public Account getAccount(int accountNumber) {
		return accountList.get(accountNumber);
	}
	
	@Override
	public HashMap<Integer, Account> viewAccounts() {
		return accountList;
	}

	@Override
	public void addSavingsAccount(double interestRate) {
		int accountNumber = acctNum.generateID();
		Account savings = new SavingsAccount(accountNumber, interestRate);
		accountList.put(accountNumber, savings);
	}
	
	@Override
	public void addCheckingAccount(){
		int accountNumber = acctNum.generateID();
		Account checking = new CheckingAccount(accountNumber);
		accountList.put(accountNumber, checking);
	}
	
	@Override
	public String sortAccountBalance(){
		LinkedList<Account> accountBalanceSort = new LinkedList<Account>(accountList.values());
		for(Account accounts: accountBalanceSort){
			Collections.sort(accountBalanceSort, new AccountBalanceComparator());
			return accountBalanceSort.toString();
		}
		return null;
	}
	
	@Override
	public String sortAccountNumber(){
		LinkedList<Account> accountNumberSort = new LinkedList<Account>(accountList.values());
		for(Account accounts: accountNumberSort){
			Collections.sort(accountNumberSort, new AccountNumberComparator());
			return accountNumberSort.toString();
		}
		return null;
	}
	
	
	@Override
	public String toString(){
		return accountHolder.toString() + "\nClient ID: " + getClientID() + "\nAccounts: " + viewAccounts() +"\nTime Created: "+ getTimeCreated() + "\n";
	}
}
