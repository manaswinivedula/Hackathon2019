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

public class Person implements IPerson {
	
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String address;
	
	public Person(){
		
	}
	public Person(String firstName, String lastName, Date dateOfBirth, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	@Override
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public void setAddress(String address) {
		this.address = address;
	}

	
	@Override
	public String toString() {
		return "Name: " + getFirstName() + " " + getLastName() + "\nDate Of Birth:" + getDateOfBirth()
				+ "\nAddress: " + getAddress();
				
	}

	
}