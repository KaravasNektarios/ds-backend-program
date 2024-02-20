package gr.hua.dit.ds.projectDSBackend.service;

import gr.hua.dit.ds.projectDSBackend.entity.*;
import gr.hua.dit.ds.projectDSBackend.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import com.github.javafaker.Faker;

@Service
public class InitialDataService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;
    private final FarmerRepository farmerRepository;
    private final ProductRepository productRepository;
    private final RegionRepository regionRepository;

    private final RequestRepository requestRepository;
    private final SupervisorRepository supervisorRepository;

    private final PasswordEncoder passwordEncoder;


    public InitialDataService(UserRepository userRepository,
                              RoleRepository roleRepository,
                              FarmerRepository farmerRepository,
                              ProductRepository productRepository,
                              RegionRepository regionRepository,
                              RequestRepository requestRepository,
                              SupervisorRepository supervisorRepository,
                              PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.farmerRepository = farmerRepository;
        this.productRepository = productRepository;
        this.regionRepository = regionRepository;
        this.requestRepository = requestRepository;
        this.supervisorRepository = supervisorRepository;
        this.passwordEncoder = passwordEncoder;
    }


    private void createUsersAndRoles() {
        final List<String> rolesToCreate = List.of("ROLE_ADMIN", "ROLE_SUPERVISOR", "ROLE_USER");
        for (final String roleName : rolesToCreate) {
            roleRepository.findByName(roleName).orElseGet(() -> {
                roleRepository.save(new Role(roleName));
                return null;
            });
        }

        this.userRepository.findByUsername("user").orElseGet(() -> {
            User user = new User("user", "user@hua.gr", this.passwordEncoder.encode("pass123"));
            Set<Role> roles = new HashSet<>();
            roles.add(this.roleRepository.findByName("ROLE_USER").orElseThrow());
            user.setRoles(roles);
            userRepository.save(user);
            return null;
        });

        this.userRepository.findByUsername("supervisor").orElseGet(() -> {
            User user = new User("supervisor", "supervisor@hua.gr", this.passwordEncoder.encode("pass123"));
            Set<Role> roles = new HashSet<>();
            roles.add(this.roleRepository.findByName("ROLE_SUPERVISOR").orElseThrow());
            user.setRoles(roles);
            userRepository.save(user);
            return null;
        });

        this.userRepository.findByUsername("admin").orElseGet(() -> {
            User user = new User("admin", "admin@hua.gr", this.passwordEncoder.encode("pass123"));
            Set<Role> roles = new HashSet<>();
            roles.add(this.roleRepository.findByName("ROLE_USER").orElseThrow());
            roles.add(this.roleRepository.findByName("ROLE_SUPERVISOR").orElseThrow());
            roles.add(this.roleRepository.findByName("ROLE_ADMIN").orElseThrow());
            user.setRoles(roles);
            userRepository.save(user);
            return null;
        });
    }

    private void createFarmers() {
        this.farmerRepository.findByUsername("Farmer1").orElseGet(() -> {
            Farmer farmer = new Farmer();
            farmer.setFirstName("Farmer1");
            farmer.setLastName("Farmer1");
            farmer.setUsername("Farmer1");
            farmer.setEmail("farmer1@gmail.com");
            farmer.setPassword(this.passwordEncoder.encode("pass123"));
            farmer.setPhone("1212312312");
            farmerRepository.save(farmer);
            return null;
        });

        this.farmerRepository.findByUsername("Farmer2").orElseGet(() -> {
            Farmer farmer = new Farmer();
            farmer.setFirstName("Farmer2");
            farmer.setLastName("Farmer2");
            farmer.setUsername("Farmer2");
            farmer.setEmail("farmer2@gmail.com");
            farmer.setPassword(this.passwordEncoder.encode("pass123"));
            farmer.setPhone("9872312312");
            farmerRepository.save(farmer);
            return null;
        });

        this.farmerRepository.findByUsername("Farmer3").orElseGet(() -> {
            Farmer farmer = new Farmer();
            farmer.setFirstName("Farmer3");
            farmer.setLastName("Farmer3");
            farmer.setUsername("Farmer3");
            farmer.setEmail("farmer3@gmail.com");
            farmer.setPassword(this.passwordEncoder.encode("pass123"));
            farmer.setPhone("9911991112");
            farmerRepository.save(farmer);
            return null;
        });
    }

    private void createSupervisors() {
        this.supervisorRepository.findByUsername("Supervisor1").orElseGet(() -> {
            Supervisor supervisor = new Supervisor();
            supervisor.setFirstName("Supervisor1");
            supervisor.setLastName("Supervisor1");
            supervisor.setUsername("Supervisor1");
            supervisor.setEmail("supervisor1@gmail.com");
            supervisor.setPassword(this.passwordEncoder.encode("pass123"));
            supervisor.setPhone("1212312312");
            supervisorRepository.save(supervisor);
            return null;
        });

        this.supervisorRepository.findByUsername("Supervisor2").orElseGet(() -> {
            Supervisor supervisor = new Supervisor();
            supervisor.setFirstName("Supervisor2");
            supervisor.setLastName("Supervisor2");
            supervisor.setUsername("Supervisor2");
            supervisor.setEmail("supervisor2@gmail.com");
            supervisor.setPassword(this.passwordEncoder.encode("pass123"));
            supervisor.setPhone("12987112312");
            supervisorRepository.save(supervisor);
            return null;
        });

        this.supervisorRepository.findByUsername("Supervisor3").orElseGet(() -> {
            Supervisor supervisor = new Supervisor();
            supervisor.setFirstName("Supervisor3");
            supervisor.setLastName("Supervisor3");
            supervisor.setUsername("Supervisor3");
            supervisor.setEmail("supervisor3@gmail.com");
            supervisor.setPassword(this.passwordEncoder.encode("pass123"));
            supervisor.setPhone("87012312312");
            supervisorRepository.save(supervisor);
            return null;
        });
    }

    private void createProducts() {
        this.productRepository.findByName("Product1").orElseGet(() -> {
            Product product = new Product();
            product.setName("Product1");
            product.setPrice(1234.0);
            productRepository.save(product);
            return null;
        });

        this.productRepository.findByName("Product2").orElseGet(() -> {
            Product product = new Product();
            product.setName("Product2");
            product.setPrice(564.0);
            productRepository.save(product);
            return null;
        });

        this.productRepository.findByName("Product3").orElseGet(() -> {
            Product product = new Product();
            product.setName("Product3");
            product.setPrice(984.0);
            productRepository.save(product);
            return null;
        });

        this.productRepository.findByName("Product4").orElseGet(() -> {
            Product product = new Product();
            product.setName("Product4");
            product.setPrice(124.0);
            productRepository.save(product);
            return null;
        });

    }

    private void createRegions() {
        this.regionRepository.findByName("Region1").orElseGet(() -> {
            Region region = new Region();
            region.setName("Region1");
            region.setAvailable(true);
            regionRepository.save(region);
            return null;
        });

        this.regionRepository.findByName("Region2").orElseGet(() -> {
            Region region = new Region();
            region.setName("Region2");
            region.setAvailable(true);
            regionRepository.save(region);
            return null;
        });

        this.regionRepository.findByName("Region3").orElseGet(() -> {
            Region region = new Region();
            region.setName("Region3");
            region.setAvailable(true);
            regionRepository.save(region);
            return null;
        });

        this.regionRepository.findByName("Region5").orElseGet(() -> {
            Region region = new Region();
            region.setName("Region5");
            region.setAvailable(true);
            regionRepository.save(region);
            return null;
        });
    }

    private void createRequests() {
        this.requestRepository.findByName("Request1").orElseGet(() ->{
           Request request = new Request();
           request.setStatus(0);
           request.setName("Request1");
           requestRepository.save(request);
           return null;
        });


        this.requestRepository.findByName("Request2").orElseGet(() ->{
            Request request = new Request();
            request.setStatus(0);
            request.setName("Request2");

            requestRepository.save(request);
            return null;
        });

        this.requestRepository.findByName("Request3").orElseGet(() ->{
            Request request = new Request();
            request.setStatus(0);
            request.setName("Request3");

            requestRepository.save(request);
            return null;
        });

        this.requestRepository.findByName("Request4").orElseGet(() ->{
            Request request = new Request();
            request.setStatus(0);
            request.setName("Request4");
            requestRepository.save(request);
            return null;
        });

        this.requestRepository.findByName("Request5").orElseGet(() ->{
            Request request = new Request();
            request.setStatus(0);
            request.setName("Request5");
            requestRepository.save(request);
            return null;
        });

    }

    @PostConstruct
    public void setup() {
        this.createUsersAndRoles();
        this.createFarmers();
        this.createSupervisors();
        this.createProducts();
        this.createRegions();
        this.createRequests();


    }

}
