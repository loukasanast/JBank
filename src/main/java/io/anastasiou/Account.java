package io.anastasiou;

import java.util.Objects;

public class Account {
    private String firstName;
    private String lastName;
    private static Account INSTANCE;

    private Account() {
        firstName = "John";
        lastName = "Doe";
    }

    public static Account getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Account();
        }

        return INSTANCE;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getInitials() {
        return Character.toString(firstName.charAt(0)) + lastName.charAt(0);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.firstName, this.lastName);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Account)  || obj == null) {
            return false;
        }

        Account other = (Account)obj;
        return this.firstName.equals(other.getFirstName()) && this.lastName.equals(other.getLastName());
    }
}
