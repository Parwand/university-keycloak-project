package net.parwand.studentapp.infrastructure.db;

import net.parwand.studentapp.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
