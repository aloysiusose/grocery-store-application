package dev.aloysius.grocerystoreapplication.Domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class ApplicationUsers {

    @Id
    protected long id;
    protected String email;
    protected String username;
    protected String password;
    protected String firstName;
    protected String lastName;

    public ApplicationUsers(ApplicationUsers users){
        this.username = users.username;
        this.password = users.password;
    }
}
