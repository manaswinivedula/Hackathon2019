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
import java.util.ArrayList;

public class CheckingAccount extends Account{

	ArrayList<ICheck> cashedChecks = new ArrayList<ICheck>();
	ClientIDGenerator checkNum = new ClientIDGenerator();

	public CheckingAccount(int accountNumber){
		super(accountNumber);
	}
	
	public void cashCheck(double amount){
		ICheck c = new Check(checkNum.generateID(), amount);
		balance = super.getBalance()-amount;
		cashedChecks.add(c);
	}
	
	public ArrayList<ICheck> getCheckCashHistory(){
		return cashedChecks;
	}
	
	public String toString(){
		return "Checking Account" + super.toString() + " Checks: " + getCheckCashHistory();
	}


}
