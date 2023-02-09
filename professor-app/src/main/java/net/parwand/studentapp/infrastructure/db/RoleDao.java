package net.parwand.studentapp.infrastructure.db;

import net.parwand.studentapp.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}
