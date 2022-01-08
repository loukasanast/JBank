package io.anastasiou.repository;

import io.anastasiou.Transaction;
import io.anastasiou.TransactionException;

import java.util.List;

public interface Repository<T> {
    List<Transaction> getAll();
    void add(T transaction) throws TransactionException;
}
