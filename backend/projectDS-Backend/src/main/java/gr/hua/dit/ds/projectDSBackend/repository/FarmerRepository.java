package gr.hua.dit.ds.projectDSBackend.repository;

import gr.hua.dit.ds.projectDSBackend.entity.Farmer;
import gr.hua.dit.ds.projectDSBackend.entity.Role;
import gr.hua.dit.ds.projectDSBackend.entity.User;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Hidden
public interface FarmerRepository extends JpaRepository<Farmer, Integer> {
    Optional<Farmer> findByUsername(String username);
    Boolean existsByUsername(String username);
}
