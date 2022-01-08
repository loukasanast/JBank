package io.anastasiou.repository;

import io.anastasiou.Transaction;
import io.anastasiou.TransactionException;

import java.util.List;

public interface Repository {
    List<Transaction> getAll();
    void add(Transaction transaction) throws TransactionException;
}
