
// Bank Application

import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your 'Name' and 'CustomerID' to access your Bank Account");
        String name = sc.nextLine();
        String customerID = sc.nextLine();

        BankAccount person = new BankAccount(name,customerID);
        person.menu();
    }
}
