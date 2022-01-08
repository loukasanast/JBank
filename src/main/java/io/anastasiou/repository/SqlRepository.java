package io.anastasiou.repository;

import io.anastasiou.Transaction;
import io.anastasiou.TransactionException;
import io.anastasiou.TransactionType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlRepository implements Repository {
    @Override
    public List<Transaction> getAll() {
        List<Transaction> result = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/jbank", "root", "changeit");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT type, amount, fromName, toName FROM tblTransactions");

            while(rs.next()) {
                result.add(new Transaction(TransactionType.valueOf(rs.getString("type")), rs.getDouble("amount"), rs.getString("fromName"), rs.getString("toName")));
            }
        } catch(ClassNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void add(Transaction transaction) throws TransactionException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/jbank", "root", "changeit");
            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO tblTransactions (type, amount, fromName, toName) VALUES " +
                    "('" + transaction.getType() + "', " + transaction.getAmount() + ", '" + transaction.getFrom() + "', '" + transaction.getTo() + "')";
            int result = stmt.executeUpdate(sql);

            if(result <= 0) {
                throw new TransactionException();
            }
        } catch(ClassNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
