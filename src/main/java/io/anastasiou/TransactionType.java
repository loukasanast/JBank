package io.anastasiou;

public enum TransactionType {
    SALARY("Salary"),
    BANK_TRANSFER("Bank Transfer");

    private String type;

    TransactionType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
