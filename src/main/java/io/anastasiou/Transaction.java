package io.anastasiou;

public class Transaction implements Comparable<Transaction> {
    private final TransactionType type;
    private final double amount;
    private final String from;
    private final String to;

    public Transaction(TransactionType type, double amount, String from, String to) {
        this.type = type;
        this.amount = amount;
        this.from = from;
        this.to = to;
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public int compareTo(Transaction o) {
        if(o == null) {
            return -1;
        }

        return (int)(o.getAmount() - this.amount * 100);
    }
}
