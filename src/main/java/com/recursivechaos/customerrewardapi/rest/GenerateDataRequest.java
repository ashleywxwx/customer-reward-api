package com.recursivechaos.customerrewardapi.rest;

public class GenerateDataRequest {

    private int userCount;

    private int transactionCount;

    public GenerateDataRequest(int userCount, int transactionCount) {
        this.userCount = userCount;
        this.transactionCount = transactionCount;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(int transactionCount) {
        this.transactionCount = transactionCount;
    }
}
