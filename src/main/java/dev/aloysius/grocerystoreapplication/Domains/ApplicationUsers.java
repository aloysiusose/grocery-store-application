package dev.aloysius.grocerystoreapplication.Domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class ApplicationUsers {

    protected String email;
    protected String username;
    protected String password;
    protected String firstName;
    protected String lastName;

}
