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

public class BankingSystemController implements IBankingSystemController {
 
 private HashMap<Integer, IClient> clientList = new HashMap<Integer,IClient>(); 
 ClientIDGenerator clientIDGen;
 AccountNumberGenerator accountNumGen; 
 
 
 public BankingSystemController(ClientIDGenerator clientIDGen, AccountNumberGenerator accountNumGen){
  this.clientIDGen = clientIDGen;
  this.accountNumGen = accountNumGen;
 }
 
 
 @Override
 public String addClient(String firstName, String lastName, Date date, String address, Date creationDate){
  int clientID = clientIDGen.generateID();
  
  //create new ICient using IClientFactory
  IClient newClient = ClientFactory.create(firstName, lastName, date, address, clientID, creationDate);
  this.clientList.put(clientID, newClient);
  
  return "\nYour ClientID Number is: " + newClient.getClientID() + "\n";
 }
 
 @Override
 public void addSavingsAccount(int clientID, double interestRate){
  clientList.get(clientID).addSavingsAccount(interestRate);   
 }
 
 @Override
 public void addCheckingAccount(int clientID){
  clientList.get(clientID).addCheckingAccount();
 }
 
 @Override
 public String viewAccount(int clientID, int accountNumber){
  return clientList.get(clientID).getAccount(accountNumber).toString();
 }
 
 @Override
 public boolean checkClient(int clientID){
  if(clientList.get(clientID) == null){
   return false;
  }
  else
   return true;
 }
 
 @Override
 public String viewClient(int clientID){
  return clientList.get(clientID).toString();
 }
 
 @Override
 public IClient getClient(int clientID){
  return clientList.get(clientID);
 }
 @Override
 public void deposit(int clientID, int accountNumber, double amount){
  clientList.get(clientID).getAccount(accountNumber).deposit(amount);
 }
 
 @Override
 public boolean withdraw(int clientID, int accountNumber, double amount){
  if(amount > clientList.get(clientID).getAccount(accountNumber).getBalance()){
   return false;
  }
  else 
  clientList.get(clientID).getAccount(accountNumber).withdraw(amount);
  return true;
 }
 
 @Override
 public void cashCheck(int clientID, int accountNumber, double amount){
  ((CheckingAccount) clientList.get(clientID).getAccount(accountNumber)).cashCheck(amount);
 }
 
 @Override
 public void closeAccount(int clientID, int accountNumber){ 
  Client temp = (Client) clientList.get(clientID);
   temp.accountList.remove(accountNumber);
 }
 
 @Override
 public void removeClient(int clientID){ 
  clientList.remove(clientID);
 }
 
 @Override
 public String sortClientID(){
  LinkedList<IClient> clientIDSort = new LinkedList<IClient>(clientList.values());
  for(IClient client: clientIDSort){
  Collections.sort(clientIDSort, new ClientIDComparator());
  return clientIDSort.toString();
  }
  return null;
 }
 
 @Override
 public String sortClientLastName(){
  LinkedList<IClient> clientLastNameSort = new LinkedList<IClient>(clientList.values());
  for(IClient client: clientLastNameSort){
   Collections.sort(clientLastNameSort, new ClientLastNameComparator());
   return clientLastNameSort.toString();
  }
  return null;
 }

 @Override
 public String sortClientFirstName(){
  LinkedList<IClient> clientFirstNameSort = new LinkedList<IClient>(clientList.values());
  for(IClient client: clientFirstNameSort){
   Collections.sort(clientFirstNameSort, new ClientFirstNameComparator());
   return clientFirstNameSort.toString();
  }
  return null;
 }
 
 @Override
 public String sortCreationDate(){
  LinkedList<IClient> clientCreationNameSort = new LinkedList<IClient>(clientList.values());
  for(IClient client: clientCreationNameSort){
   Collections.sort(clientCreationNameSort, new CreationDateComparator());
   return clientCreationNameSort.toString();
  }
  return null;
 }
 
}