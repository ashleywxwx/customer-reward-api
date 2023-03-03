package com.recursivechaos.customerrewardapi.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;

@Entity
public class CustomerTransaction {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NonNull
    private String userId;

    private BigDecimal amount;

    public CustomerTransaction() {
    }

    public CustomerTransaction(@NonNull String userId, BigDecimal amount) {
        this.userId = userId;
        this.amount = amount;
    }

    public CustomerTransaction(String id, @NonNull String userId, BigDecimal amount) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    @NonNull
    public String getUserId() {
        return userId;
    }

    public void setUserId(@NonNull String userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
