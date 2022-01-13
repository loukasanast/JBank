package io.anastasiou.util;

import io.anastasiou.TransactionException;

public interface Transactor {
    void printTransactions();
    void printBalance();
    void transferMoney() throws TransactionException;
    void getPaid();
}
