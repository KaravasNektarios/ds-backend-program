package gr.hua.dit.ds.projectDSBackend.repository;

import gr.hua.dit.ds.projectDSBackend.entity.Request;
import gr.hua.dit.ds.projectDSBackend.entity.User;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Hidden
public interface RequestRepository extends JpaRepository<Request, Integer> {
    Optional<Request> findByName(String name);
    Boolean existsByName(String name);
}
