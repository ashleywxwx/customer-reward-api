package com.recursivechaos.customerrewardapi.service;

import java.math.BigDecimal;

public interface RewardCalculator {

    int calculatePoints(BigDecimal amount);

}
