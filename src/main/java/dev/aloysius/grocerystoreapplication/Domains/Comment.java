package dev.aloysius.grocerystoreapplication.Domains;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name= "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comments_sequence")
    @SequenceGenerator(name = "comments_sequence", allocationSize = 1)
    private long id;
    private String text;
    @ManyToOne
    @JoinColumn(name = "products_id")
    private Products products;
}
