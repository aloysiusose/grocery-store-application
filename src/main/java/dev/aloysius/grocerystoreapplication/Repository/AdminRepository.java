package dev.aloysius.grocerystoreapplication.Repository;

import dev.aloysius.grocerystoreapplication.Domains.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
