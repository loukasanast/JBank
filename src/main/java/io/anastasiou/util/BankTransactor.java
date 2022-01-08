package io.anastasiou.util;

import io.anastasiou.Account;
import io.anastasiou.Transaction;
import io.anastasiou.TransactionException;
import io.anastasiou.TransactionType;
import io.anastasiou.repository.Repository;
import io.anastasiou.repository.SqlRepository;

import java.util.List;
import java.util.Scanner;

public class BankTransactor implements Transactor {
    private static final Account account = new Account();
    private static final Scanner scanner = new Scanner(System.in);
    private static final Repository repo = new SqlRepository();

    @Override
    public void printTransactions() {
        List<Transaction> transactions = repo.getAll();

        transactions.stream()
                .forEach(t -> System.out.printf("%-20s| $%-20.2f| %s\n", t.getType().getType(), t.getAmount(), t.getAmount() > 0 ? "From: " + t.getFrom() : "To: " + t.getTo()));
    }

    @Override
    public void printBalance() {
        List<Transaction> transactions = repo.getAll();
        double result = 0;

        for(int i = 0; i < transactions.size(); i++) {
            result += transactions.get(i).getAmount();
        }

        System.out.printf("Balance: $%.2f\n", result);
    }

    @Override
    public void transferMoney() {
        String to;
        double amount;

        while(true) {
            System.out.println("Please, enter a recipient");
            to = scanner.nextLine().trim();

            if(!to.isBlank()) {
                break;
            } else {
                System.out.println("Please, enter a valid name\n");
            }
        }

        while(true) {
            System.out.println("Please, enter an amount");

            try {
                amount = Double.parseDouble(scanner.nextLine().trim());
                break;
            } catch(NumberFormatException e) {
                System.out.println("Please, enter a valid amount\n");
            }
        }

        try {
            repo.add(new Transaction(TransactionType.BANK_TRANSFER, -amount, account.getFirstName() + " " + account.getLastName(), to));
            System.out.println("Your bank transfer completed successfully");
        } catch(TransactionException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getPaid() {
        String from;
        double amount;

        while(true) {
            System.out.println("Please, enter an employer");
            from = scanner.nextLine().trim();

            if(!from.isBlank()) {
                break;
            } else {
                System.out.println("Please, enter a valid company name\n");
            }
        }

        while(true) {
            System.out.println("Please, enter an amount");

            try {
                amount = Double.parseDouble(scanner.nextLine().trim());
                break;
            } catch(NumberFormatException e) {
                System.out.println("Please, enter a valid amount\n");
            }
        }

        try {
            repo.add(new Transaction(TransactionType.SALARY, amount, from, account.getFirstName() + " " + account.getLastName()));
            System.out.println("Your payment completed successfully");
        } catch(TransactionException e) {
            System.out.println(e.getMessage());
        }
    }
}
