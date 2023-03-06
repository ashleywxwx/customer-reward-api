package com.recursivechaos.customerrewardapi.service;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class StandardRewardCalcImplTest {

    RewardCalculator calc = new StandardRewardCalcImpl();

    @Test
    void calculatePoints() {

        assertEquals(0, calc.calculatePoints(BigDecimal.valueOf(0.0)));
        assertEquals(90, calc.calculatePoints(BigDecimal.valueOf(120.0)));
        assertEquals(49, calc.calculatePoints(BigDecimal.valueOf(99.0)));

    }
}