import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    private static final int MONTHS_IN_A_YEAR = 12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the principal amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter the annual interest rate: ");
        float annualInterestRate = scanner.nextFloat();

        System.out.print("Enter the term in years: ");
        int termInYears = scanner.nextInt();

        float monthlyInterestRate = annualInterestRate / MONTHS_IN_A_YEAR;
        int numberOfPayments = termInYears * MONTHS_IN_A_YEAR;

        double monthlyPayment = principal * (monthlyInterestRate *
                (Math.pow(1 + monthlyInterestRate, numberOfPayments))) /
                ((Math.pow(1 + monthlyInterestRate, numberOfPayments)) - 1);

        System.out.println("Monthly Payment     : " + NumberFormat.getCurrencyInstance().format(monthlyPayment));
        System.out.println("Total Payback amount: " + NumberFormat.getCurrencyInstance().format(monthlyPayment * numberOfPayments));
    }
}
