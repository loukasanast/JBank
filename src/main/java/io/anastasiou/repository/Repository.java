package io.anastasiou.repository;

import io.anastasiou.TransactionException;

import java.util.List;

public interface Repository<T> {
    List<T> getAll();
    void add(T transaction) throws TransactionException;
}
