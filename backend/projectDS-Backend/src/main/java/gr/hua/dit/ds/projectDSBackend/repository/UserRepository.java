package gr.hua.dit.ds.projectDSBackend.repository;

import gr.hua.dit.ds.projectDSBackend.entity.User;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
@Hidden
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
