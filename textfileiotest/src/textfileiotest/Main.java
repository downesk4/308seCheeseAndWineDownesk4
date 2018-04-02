/*
 * Program to demonstrate reading from and writing to text files
 */
package textfileiotest;

import java.util.Vector;
import java.util.Iterator;

/**
 *
 * @author cex001
 */
public class Main {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      // TODO code application logic here
      Vector recordSet = new Vector();
      AccountRecord accRecord = new AccountRecord();

      ReadTextFile fileReader = new ReadTextFile();

      fileReader.openFile();
      fileReader.readRecords(recordSet);
      fileReader.closeFile();

      //get an Iterator object from record set
      Iterator itr = recordSet.iterator();
      //use Iterator's hasNext and next methods
      System.out.println("Iterating through Vector elements...");
      while(itr.hasNext()) {
          accRecord = (AccountRecord)itr.next();
          accRecord.displayRecord();
       }

      WriteTextFile fileWriter = new WriteTextFile();
      fileWriter.openFile();
      fileWriter.addRecords(recordSet);
      fileWriter.closeFile();
   }
}
