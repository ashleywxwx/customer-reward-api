package com.recursivechaos.customerrewardapi.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class StandardRewardCalcImpl implements RewardCalculator {

    @Override
    public int calculatePoints(BigDecimal amount) {

        int points = 0;
        int balance = amount.intValue();

        if(balance > 100){
            points += (balance - 100) * 2;
            balance = 100;
        }

        if(balance > 50) {
            points += (balance - 50);
        }

        return points;
    }
}
