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
import java.util.Date;
import java.util.HashMap;

public interface IClient extends IPerson {
	
	public IPerson getAccountHolder();

	public int getClientID();

	public Date getTimeCreated();

	public void setTimeCreated(Date timeCreated);

	public Account getAccount(int accountNumber);

	public HashMap<Integer, Account> viewAccounts();

	public void addSavingsAccount(double interestRate);

	public void addCheckingAccount();

	public String toString();

	public String sortAccountBalance();
	
	public String sortAccountNumber();


}