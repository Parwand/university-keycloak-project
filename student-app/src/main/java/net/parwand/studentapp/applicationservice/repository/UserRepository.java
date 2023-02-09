package net.parwand.studentapp.applicationservice.repository;

import net.parwand.studentapp.domain.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    User findByUsername(String username);
}
