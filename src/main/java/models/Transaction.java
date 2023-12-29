package models;

public class Transaction {
    private String transactionId;
    private String type;
    private double amount;
    private String accountId;
    private String customerId;


    public String getTransactionId() {
        return transactionId;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getCustomerId() {
        return customerId;
    }
}
