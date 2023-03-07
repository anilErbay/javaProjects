import java.sql.SQLOutput;
import java.util.Scanner;

public class BankAccount {
    private String customerName;
    private String customerID;
    private double balance;
    private double previousTransaction;

    public BankAccount(String customerName, String customerID, double balance, double prevTransfer) {
        this.customerName = customerName;
        this.customerID = customerID;
        this.balance = balance;
        this.previousTransaction = prevTransfer;
    }

    public BankAccount(String customerName, String customerID) {
        this.customerName = customerName;
        this.customerID = customerID;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            this.previousTransaction = amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            this.balance -= amount;
            this.previousTransaction -= amount;
        } else if (balance < amount) {
            System.out.println("** -> Insufficient Balance!");
        }
    }

    public void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("** -> Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("** -> Withdrawn. " + Math.abs(previousTransaction));
        } else {
            System.out.println("** -> No transaction occured.");
        }
    }

    public void menu() {
        int option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome "+customerName);
        System.out.println("Your ID:"+customerID);
        System.out.println("\n");
        System.out.println("1) Check Balance");
        System.out.println("2) Deposit Amount");
        System.out.println("3) Withdraw Amount");
        System.out.println("4) Previous Transaction");
        System.out.println("5) Exit");

        do {
            System.out.println("********************************************");
            System.out.println("Choose an option");
            option=Integer.parseInt(sc.nextLine());
            System.out.println("\n");

            switch (option) {
                case 1:
                    System.out.println("......................");
                    System.out.println("Balance = "+balance);
                    System.out.println("......................");
                    System.out.println("\n");
                    break;
                case 2:
                    System.out.println("......................");
                    System.out.println("Enter a amount to deposit :");
                    System.out.println("......................");
                    double amount=Double.parseDouble(sc.nextLine());
                    deposit(amount);
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.println("......................");
                    System.out.println("Enter a amount to Withdraw :");
                    System.out.println("......................");
                    double amountW=Double.parseDouble(sc.nextLine());
                    withdraw(amountW);
                    System.out.println("\n");
                    break;
                case 4:
                    System.out.println("......................");
                    System.out.println("Previous Transaction:");
                    getPreviousTransaction();
                    System.out.println("......................");
                    System.out.println("\n");
                    break;
                case 5:
                    System.out.println("......................");
                    break;
                default:
                    System.out.println("Choose a correct option to proceed");
                    break;
            }
        } while (option != 5);
        System.out.println("Thank you for using our service.");
    }
}
