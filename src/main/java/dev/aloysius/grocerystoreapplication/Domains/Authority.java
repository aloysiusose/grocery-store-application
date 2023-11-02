package dev.aloysius.grocerystoreapplication.Domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Authority {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   @SequenceGenerator(name = "authority_sequence", allocationSize = 1)
   private Long id;
   private String name;
   @ManyToOne
   @JoinColumn(name = "admin_id")
   private Admin admin;
}
