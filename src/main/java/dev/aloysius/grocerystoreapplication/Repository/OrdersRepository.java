package dev.aloysius.grocerystoreapplication.Repository;

import dev.aloysius.grocerystoreapplication.Domains.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
