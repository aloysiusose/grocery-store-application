package dev.aloysius.grocerystoreapplication.Repository;

import dev.aloysius.grocerystoreapplication.Domains.ApplicationUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicationUsersRepository extends JpaRepository<ApplicationUsers, Long> {
    Optional<ApplicationUsers> findByUsername(String username);
}
