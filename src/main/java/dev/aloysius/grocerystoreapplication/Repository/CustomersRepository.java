package dev.aloysius.grocerystoreapplication.Repository;

import dev.aloysius.grocerystoreapplication.Domains.Customers;
import dev.aloysius.grocerystoreapplication.Service.AuthenticationService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomersRepository extends JpaRepository<Customers, Long> {
    Optional<Customers> findByUsername(String username);
}

