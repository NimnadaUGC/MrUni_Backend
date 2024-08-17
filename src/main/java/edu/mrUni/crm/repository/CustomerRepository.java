package edu.mrUni.crm.repository;

import edu.mrUni.crm.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    public List<Customer> findAllByActiveStatus(boolean status);
}
