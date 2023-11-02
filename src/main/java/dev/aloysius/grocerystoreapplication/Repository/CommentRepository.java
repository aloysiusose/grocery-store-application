package dev.aloysius.grocerystoreapplication.Repository;

import dev.aloysius.grocerystoreapplication.Domains.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
