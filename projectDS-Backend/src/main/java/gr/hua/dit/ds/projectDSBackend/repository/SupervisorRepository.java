package gr.hua.dit.ds.projectDSBackend.repository;

import gr.hua.dit.ds.projectDSBackend.entity.Supervisor;
import gr.hua.dit.ds.projectDSBackend.entity.User;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Hidden
public interface SupervisorRepository extends JpaRepository<Supervisor, Integer> {
    Optional<Supervisor> findByUsername(String username);
    Boolean existsByUsername(String username);
}
