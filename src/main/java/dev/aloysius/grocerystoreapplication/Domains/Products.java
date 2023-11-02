package dev.aloysius.grocerystoreapplication.Domains;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Entity
@Getter
@Setter
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    @SequenceGenerator(name = "product_sequence", allocationSize = 1)
    private long id;
    private String name;
    private BigDecimal price;
    private boolean inStock;
    @OneToMany(mappedBy = "products")
    private List<Comment> commentList;
}
