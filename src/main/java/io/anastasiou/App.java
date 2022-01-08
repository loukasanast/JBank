package io.anastasiou;

import io.anastasiou.util.Authenticator;
import io.anastasiou.util.BankTransactor;

import java.util.Scanner;

public class App
{
    private static final Account account = Account.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        try {
            Authenticator auth = () -> {
                System.out.println("Please, enter your initials (John Doe)");
                String initials = scanner.nextLine();

                if(!initials.toUpperCase().equals(account.getInitials().toUpperCase())) {
                    throw new UnauthorizedException();
                } else {
                    System.out.println("Welcome to JBank " + account.getFirstName() + " " + account.getLastName());
                }
            };

            auth.login();
        } catch(UnauthorizedException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        while(true) {
            int menuChoice = 0;

            printMenu();

            try {
                menuChoice = Integer.parseInt(scanner.nextLine());
            } catch(NumberFormatException e) {
                System.out.println(e.getMessage());
            }

            switch(menuChoice) {
                case 1:
                    new BankTransactor().printTransactions();
                    break;
                case 2:
                    new BankTransactor().printBalance();
                    break;
                case 3:
                    new BankTransactor().transferMoney();
                    break;
                case 4:
                    new BankTransactor().getPaid();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Please, enter a valid number");
            }
        }
    }

    static void printMenu() {
        System.out.println();
        System.out.println("1. Print transactions");
        System.out.println("2. Print balance");
        System.out.println("3. Transfer money");
        System.out.println("4. Get paid");
        System.out.println("5. Quit");
    }
}
