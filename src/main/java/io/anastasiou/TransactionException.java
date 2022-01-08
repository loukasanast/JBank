package io.anastasiou;

public class TransactionException extends Exception {
    public TransactionException() {
        super("Could not add transaction");
    }
}
