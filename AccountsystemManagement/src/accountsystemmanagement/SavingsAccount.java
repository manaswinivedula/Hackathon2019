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
public class SavingsAccount extends Account {

	double interestRate;
	
	public SavingsAccount(int accountNumber){
		super(accountNumber);
		this.accountNumber = accountNumber;
	}
	public SavingsAccount(int accountNumber, double interestRate){
		super(accountNumber);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public String toString(){
		return "Savings Account" + super.toString() + " Interest Rate: %" + getInterestRate();
	}
}