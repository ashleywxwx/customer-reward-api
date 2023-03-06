package com.recursivechaos.customerrewardapi.rest;

import com.recursivechaos.customerrewardapi.dao.CustomerTransaction;
import com.recursivechaos.customerrewardapi.dao.CustomerTransactionRepository;
import com.recursivechaos.customerrewardapi.service.RewardCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RepositoryRestController
public class TransactionController {

    private final CustomerTransactionRepository repository;
    private final RewardCalculator calculator;

    @Autowired
    public TransactionController(CustomerTransactionRepository repository, RewardCalculator calculator) {
        this.repository = repository;
        this.calculator = calculator;
    }

    // This endpoint overrides the default provide by Spring Data REST
    @RequestMapping(method = RequestMethod.POST, value = "/transactions")
    public @ResponseBody ResponseEntity<?> createTransaction(@RequestBody CustomerTransaction request) {

        // Calculate reward points at creation
        request.setRewardPoints(calculator.calculatePoints(request.getAmount()));

        // Set timestamp if not set
        if(null == request.getTimestamp()) {
            request.setTimestamp(LocalDateTime.now());
        }
        CustomerTransaction savedRequest = repository.save(request);

        // Build response
        EntityModel<CustomerTransaction> resources = EntityModel.of(savedRequest);
        // TODO: Build link to specific entity
        resources.add(linkTo(methodOn(TransactionController.class).createTransaction(request)).withSelfRel());
        return ResponseEntity.ok(resources);
    }

}
