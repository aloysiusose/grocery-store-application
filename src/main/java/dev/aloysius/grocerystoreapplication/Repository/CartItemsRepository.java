package dev.aloysius.grocerystoreapplication.Repository;

import dev.aloysius.grocerystoreapplication.Domains.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemsRepository extends JpaRepository<CartItems, Long> {
}
