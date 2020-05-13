package repositories;

import entities.Role;
import entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User findByRolesIn(List<Role> roles);
}