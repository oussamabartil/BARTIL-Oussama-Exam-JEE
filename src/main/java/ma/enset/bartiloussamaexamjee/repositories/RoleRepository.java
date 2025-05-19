package ma.enset.bartiloussamaexamjee.repositories;

import ma.enset.bartiloussamaexamjee.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}