package com.recursivechaos.customerrewardapi.dao;

import com.recursivechaos.customerrewardapi.dao.CustomerTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "transactions")
public interface CustomerTransactionRepository extends PagingAndSortingRepository<CustomerTransaction, String>, CrudRepository<CustomerTransaction, String> {

}
