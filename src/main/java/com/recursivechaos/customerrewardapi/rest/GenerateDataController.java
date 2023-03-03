package com.recursivechaos.customerrewardapi.rest;

import com.recursivechaos.customerrewardapi.dao.CustomerTransaction;
import com.recursivechaos.customerrewardapi.dao.CustomerTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Controller
public class GenerateDataController {

    private final CustomerTransactionRepository repository;

    @Autowired
    public GenerateDataController(CustomerTransactionRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/generate")
    @ResponseStatus(HttpStatus.CREATED)
    public void generateData(@RequestBody GenerateDataRequest request) {
        Set<CustomerTransaction> txs =
                generateUserIds(request.getUserCount()).stream()
                        .flatMap(userId -> generateTransactions(request.getTransactionCount(), userId))
                        .collect(Collectors.toSet());
        repository.saveAll(txs);
    }

    private Stream<CustomerTransaction> generateTransactions(int txCount, String userId) {
        Set<CustomerTransaction> subset = new HashSet<>();
        for (int i = 0; i < txCount; i++) {
            subset.add(new CustomerTransaction(userId, generateAmount()));
        }
        return subset.stream();
    }

    private BigDecimal generateAmount() {
        return new BigDecimal(ThreadLocalRandom.current().nextInt(1, 1000) + "." + ThreadLocalRandom.current().nextInt(0, 99));
    }

    private Set<String> generateUserIds(int userCount) {
        Set<String> results = new HashSet<>();
        for (int i = 0; i < userCount; i++) {
            results.add(UUID.randomUUID().toString());
        }
        return results;
    }

}
