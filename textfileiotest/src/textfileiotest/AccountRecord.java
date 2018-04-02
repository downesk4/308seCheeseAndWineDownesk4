package textfileiotest;

import java.util.Formatter;
import java.util.Scanner;
import java.util.Date;

public class AccountRecord {

   private int _accNum;
   private String _firstName;
   private String _lastName;
   private double _accBalance;
   private int _transAction;
   private double _lastTransAction;
   private long _date;

   public AccountRecord() {
   }  // end of default constructor

   public AccountRecord(AccountRecord accRec) {

      this._accNum = accRec._accNum;
      this._firstName = accRec._firstName;
      this._lastName = accRec._lastName;
      this._accBalance = accRec._accBalance;
      this._transAction = accRec._transAction;
      this._lastTransAction = accRec._lastTransAction;
      this._date = accRec._date;
   }  // end of copy constructor

   public void setAccount(int accNum) {
      this._accNum = accNum;
   }

   public void setFirstName(String firstName) {
      this._firstName = firstName;
   }

   public void setLastName(String lastName) {
      this._lastName = lastName;
   }

   public void setBalance(double accBalance) {
      this._accBalance = accBalance;
   }

   public void setTransAction(int transAction) {
      this._transAction = transAction;
    }
  
   public void setLastTransAction(double LastTransAction) {
      this._lastTransAction = LastTransAction;
   }
           
   public void setDate(long Date){
       this._date = Date;
   }
   
   public int getAccount() {
      return this._accNum;
   }

   public String getFirstName() {
      return this._firstName;
   }

   public String getLastName() {
      return this._lastName;
   }

   public double getBalance() {
      return this._accBalance;
   }
   
   public int getTransAction() {
       return this._transAction;
   }
   
   public double getLastTransAction() {
       return this._lastTransAction;
   }
   
   public long getDate(){
       return this._date;
   }

   public void setRecord(Scanner input) {
      this.setAccount(input.nextInt()); // read account number
      this.setFirstName(input.next()); // read first name
      this.setLastName(input.next()); // read last name
      this.setBalance(input.nextDouble()); // read balance
      this.setTransAction(input.nextInt());//read transaction
      this.setLastTransAction(input.nextDouble());//read last transaction
      this.setDate(input.nextLong());
   } // end method setRecord

   public void displayRecord() {
      System.out.printf("%-10d%-12s%-12s%10.2f\n",
              this.getAccount(),
              this.getFirstName(),
              this.getLastName(),
              this.getBalance(),
              this.getTransAction(),
              this.getLastTransAction(),
              this.getDate());
   } // end method displayRecord

   public void outputRecord(Formatter output) {
      output.format("%d %s %s %.2f\r\n",
              this.getAccount(),
              this.getFirstName(),
              this.getLastName(),
              this.getBalance(),
              this.getTransAction(),
              this.getLastTransAction(),
              this.getDate());
   } // end method displayRecord

}  // end of class AccountRecord

