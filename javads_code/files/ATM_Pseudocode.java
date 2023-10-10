import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer {

    /*
     * A utility method that shows the current balance. I'm giving you this one
     * for free.
     */
    public static void showBalance(Account acct) {
        System.out.printf("Your current balance is $%.2f\n", acct.getBalance());
    }

    /*
     * Given an Account object (acct) and a string that should contain a number,
     * this method makes sure the string does contain a number and
     * is greater than or equal to zero. If all these conditions are met, 
     * the amount is added to the account balance, and the method calls
     * showBalance() to display the updated balance. Otherwise, the method
     * prints an appropriate error message and leaves the acct variable unchanged.
     */
    public static void doDeposit(Account acct, String s) {
        
    }
    
    /*
     * Given an Account object (acct) and a string that should contain a number,
     * this method makes sure the string does contain a number and
     * is greater than or equal to zero and less than or equal to the account
     * balance. If all these conditions are met, the amount is subtracted from
     * the account balance., and the method calls showBalance() to display the
     * updated balance. Otherwise, the method prints an appropriate error
     * message and leaves the acct variable unchanged.
     */
    public static void doWithdrawal(Account acct, String s) {
        
    }
    
    /*
     * Given a Scanner that refers to an open account data file, this method
     * reads the file, and, for each line, splits the fields and creates a new
     * Account object which is added to an ArrayList<Account>. The method
     * returns the arraylist.
     * 
     * If this method encounters a NumberFormatException, which would be caused
     * by bad data in the input file, it will print an appropriate error message
     * and return an empty ArrayList<Account>.
     */
    public static ArrayList<Account> readAccounts(Scanner fileInput) {
        ArrayList<Account> accountList = new ArrayList<>();
        return accountList;
    }

    /*
     * Given an accountList (an ArrayList<Account>), this method will convert each 
     * Account to a colon-separated line of text (hint: use toString()) and
     * write it to file "accounts.dat". If the process encounters any type
     * of Exception,the method writes an appropriate error message. 
     */
    public static void writeAccounts(ArrayList<Account> accounttList) {

    }

    /*
     * Given an accountList (an ArrayList<Account>) and an account number, this method 
     * will return the index at which the account with the given account number was found,
     * or -1 if the account number does not belong to any account in the accountList.
     */
    public static int findIndex(ArrayList<Account> accountList, int accountNumber) {
        return -1;
    }
    
    /*
     * Given an accountList (an ArrayList<Account>) and a string that should contain
     * an integer account number, this method will validate that the string contains
     * an integer. If so, it will use findIndex() to return the index at which the
     * account number was found (which may be -1 if there is no such account number).
     * 
     * If the string does not contain a valid integer, the method prints an appropriate
     * error message and returns -1.
     */
    public static int getAccountIndex(ArrayList<Account> accountList, String s) {
        return -1;
    }

    /*
     * This method takes acct (an Account object) and a Scanner that scans
     * keyboard input.
     * 
     * Your method will repeatedly ask the user to type D to deposit, W to withdraw, or
     * F to finish their transactions. You must accept the answer in either upper or lower case.
     * If the input is F, the method finishes looping.
     * If the input is D, the method calls doDeposit() with the account and the next line of input.
     * If the input is W, the method calls doWithdrawal() with the account and the next line of input.
     * 
     * If the input is not W, D, or F, the method prints an appropriate error message.
     */
    public static void doTransactions(Account acct, Scanner input) {

    }

    public static void main(String[] args) {
        /*
         * Open the input file accounts.dat.
         * Create a new Scanner based on this file. If this fails due to a FileNotFoundException,
         * the program prints an error message and ends.
         * Read the accounts from the file to create accountList, an ArrayList<Account>
         * If the size of the list is greater than zero:
             * Create a Scanner based on System.in
             * Repeatedly do the following:
                 * Ask for an account number and read a line of input.
                 * If the user just presses ENTER, the program has finished.
                 * Otherwise, use getAccountIndex() to find the index of the account with
                 * the corresponding number.
                 * If the index is not -1, then:
                     * Set a variable named account to the account at the given index
                     * Print a "Hello" message that greets the account owner by name.
                     * Show the current account balance.
                     * Call doTransactions()
                     * Call writeAccounts() to write the updated account list to disk
                     * Print a personalized "Goodbye" message for the account owner
         * When the program finishes, print a message saying that the ATM program has concluded.
         */
    }
}
