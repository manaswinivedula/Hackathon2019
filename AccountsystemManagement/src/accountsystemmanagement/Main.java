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
  
public class Main {

 public static void main(String[] args){
  
  ClientIDGenerator clientIDGen = new ClientIDGenerator();
  AccountNumberGenerator accountNumGen = new AccountNumberGenerator();
  IBankingSystemController controller = new BankingSystemController(clientIDGen, accountNumGen); 
  BankingSystemCommandLine commandLine = new BankingSystemCommandLine(controller);
  
  commandLine.commandLoop();
 

}
}