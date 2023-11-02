package dev.aloysius.grocerystoreapplication.Domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "items_sequence")
    @SequenceGenerator(name = "items_sequence", allocationSize = 1)
    private long id;
    private int quantity;
    @OneToOne()
    @JoinColumn(name = "product_id")
    private Products products;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders orders;

}
