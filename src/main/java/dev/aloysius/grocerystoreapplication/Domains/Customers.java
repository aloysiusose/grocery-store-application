package dev.aloysius.grocerystoreapplication.Domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customers{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", allocationSize = 1)
    private long id;
    protected String email;
    protected String username;
    protected String password;
    protected String firstName;
    protected String lastName;

    private LocalDate customerSince = LocalDate.now();
    @OneToMany
    private Set<ShoppingCart> shoppingCartSet;
    @OneToMany
    private Set<Orders> ordersSet;

    public Customers(Customers users) {
        this.username = users.username;
        this.password = users.password;
    }
}
