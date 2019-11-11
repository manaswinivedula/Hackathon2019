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

public interface IPerson {

	String getFirstName();

	void setFirstName(String firstName);

	String getLastName();

	void setLastName(String lastName);

	Date getDateOfBirth();

	void setDateOfBirth(Date dateOfBirth);

	String getAddress();

	void setAddress(String address);

	String toString();

}
