package dev.aloysius.grocerystoreapplication.Domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_sequence")
    @SequenceGenerator(name = "cart_sequence", allocationSize = 1)
    private long id;
    private int quantity;
    private BigDecimal subAmount;
    @OneToOne
    @JoinColumn(name = "products_id")
    private Products products;

    @ManyToOne
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;

    public void setSubAmount() {
        this.subAmount = products.getPrice().multiply(BigDecimal.valueOf(quantity));
    }
}
