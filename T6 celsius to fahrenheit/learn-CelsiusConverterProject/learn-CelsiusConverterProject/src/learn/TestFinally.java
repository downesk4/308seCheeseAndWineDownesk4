/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learn;

/**
 *
 * @author downesk4
 */
public class TestFinally {
    public static void main(String args[]) {
        TestFinally andFinally = new TestFinally();
        System.out.println(andFinally.proveIt());
    }
    
    public int proveIt() {
        try {
            return 1;
        }
        catch (Exception ex) {
            // exception code here
        }
        finally {
            System.out.println("finally block is run before"
                + " method returns control back to main");
        }
        System.out.println("this does not print");
        return 0;
    }
}
