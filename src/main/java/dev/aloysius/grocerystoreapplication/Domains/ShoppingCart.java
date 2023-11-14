package dev.aloysius.grocerystoreapplication.Domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_sequence")
    @SequenceGenerator(name = "cart-sequence", allocationSize = 1)
    private long id;
    private BigDecimal totalAmount;
    @OneToMany(mappedBy = "shoppingCart", orphanRemoval = true) //orphan removal is set to true because once a shopping cart item result in an order, the shopping cart is deleted so also are cart items in the db
    private Set<CartItems> cartItems = new LinkedHashSet<>();
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customers;

    public void setTotalAmount(){

    }

}
