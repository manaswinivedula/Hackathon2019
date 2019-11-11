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
public abstract class Account {
    int accountNumber;
	double balance;
	
	public Account(int accountNumber){
		this.accountNumber = accountNumber;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public double withdraw(double amount) {
		
		if(balance - amount < 0){
			return balance;
		}
		else{
			balance -= amount;
		}
			
		
		return balance;
	}

	public double deposit(double amount) {
		balance +=amount;
		return balance;
	}
	public String toString(){
		return " Number: " + getAccountNumber() + " Balance: $" + getBalance();
	}
}
    
}
