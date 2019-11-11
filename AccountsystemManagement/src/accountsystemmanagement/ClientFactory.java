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

public class ClientFactory {

	public static IClient create(String firstName, String lastName, Date date, String address, int clientID, Date creationDate){
		IClient client = new Client(firstName, lastName, date, address, clientID, creationDate);
		return client; 
	}
}