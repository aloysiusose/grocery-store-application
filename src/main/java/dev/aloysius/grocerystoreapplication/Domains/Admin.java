package dev.aloysius.grocerystoreapplication.Domains;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends ApplicationUsers{
    @OneToMany(mappedBy = "admin")
    private Set<Authority> authoritySet;
}
