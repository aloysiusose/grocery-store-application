package dev.aloysius.grocerystoreapplication.Domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
    @SequenceGenerator(name = "order_sequence", allocationSize = 1)
    private long id;
    private LocalDateTime date;
    private BigDecimal totalAmount;
    private String paymentMethod;
    @OneToMany(mappedBy = "orders", orphanRemoval = true)
    private Set<OrderItems> orderItemsSet = new LinkedHashSet<>();
    private List<CartItems> itemsList;

    public void addItems(OrderItems items){
        orderItemsSet.add(items);
       // totalAmount = totalAmount.add(items.)
    }


}
