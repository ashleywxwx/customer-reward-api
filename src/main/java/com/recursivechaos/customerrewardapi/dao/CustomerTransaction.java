package com.recursivechaos.customerrewardapi.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class CustomerTransaction {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NonNull
    private String userId;

    private BigDecimal amount;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime timestamp;

    private int rewardPoints;

    public CustomerTransaction() {
    }

    public CustomerTransaction(@NonNull String userId, BigDecimal amount, LocalDateTime timestamp, int rewardPoints) {
        this.userId = userId;
        this.amount = amount;
        this.timestamp = timestamp;
        this.rewardPoints = rewardPoints;
    }

    public CustomerTransaction(String id, @NonNull String userId, BigDecimal amount, LocalDateTime timestamp, int rewardPoints) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.timestamp = timestamp;
        this.rewardPoints = rewardPoints;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }
}
