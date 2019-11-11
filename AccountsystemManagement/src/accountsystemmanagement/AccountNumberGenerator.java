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

public class AccountNumberGenerator {

private static int lastIDUsed = 1;
	
	public int generateID(){
		int id = lastIDUsed;
		lastIDUsed++;
		return id;
	}
}