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

import java.util.Comparator;

public class ClientLastNameComparator implements Comparator<IClient> {

	@Override
	public int compare(IClient client1, IClient client2) {
		if(client1.getLastName().compareToIgnoreCase(client2.getLastName()) < 0){
			return -1;
		}
		else if(client1.getLastName().compareToIgnoreCase(client2.getLastName()) > 0){
		return 1;
	}
		else if(client1.getLastName().compareToIgnoreCase(client2.getLastName()) == 0)
		return 0;
	
	return 0;
	}

	
}

