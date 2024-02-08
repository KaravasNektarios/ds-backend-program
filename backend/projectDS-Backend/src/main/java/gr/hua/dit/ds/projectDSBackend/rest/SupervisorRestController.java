package gr.hua.dit.ds.projectDSBackend.rest;

import gr.hua.dit.ds.projectDSBackend.entity.Supervisor;
import gr.hua.dit.ds.projectDSBackend.service.SupervisorService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supervisors")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class SupervisorRestController {

    @Autowired
    private SupervisorService supervisorService;

    @PostConstruct
    public void setup() {
        if (!supervisorService.existsSupervisorById(1)) {
            Supervisor supervisor = new Supervisor("Supervisor1", "Supervisor1",
                    "Supervisor1", "Supervisor1@gmail.com", "pass123", "1234567895");
            supervisorService.saveSupervisor(supervisor);
        }

        if (!supervisorService.existsSupervisorById(2)) {
            Supervisor supervisor = new Supervisor("Supervisor2", "Supervisor2",
                    "Supervisor2", "Supervisor2@gmail.com", "pass123", "9876543219");

            supervisorService.saveSupervisor(supervisor);
        }

        if (!supervisorService.existsSupervisorById(3)) {
            Supervisor supervisor = new Supervisor("Supervisor3", "Supervisor3",
                    "Supervisor3", "Supervisor3@gmail.com", "pass123", "4564567893");
            supervisorService.saveSupervisor(supervisor);
        }
    }

    @GetMapping("")
    public List<Supervisor> getSupervisors() {

        return supervisorService.getSupervisors();
    }


    @GetMapping("{supervisor_id}")
    public Supervisor getSupervisorById(@PathVariable Integer supervisor_id) {
        if (supervisorService.existsSupervisorById(supervisor_id)) {
            return supervisorService.getSupervisorById(supervisor_id);
        }
        return null;
    }

    @PostMapping("newSupervisor")
    public void saveSupervisor(@RequestBody Supervisor supervisor) {
        supervisorService.saveSupervisor(supervisor);

    }

    @DeleteMapping("deleteSupervisorById/{supervisor_id}")
    public void deleteSupervisorById(@PathVariable Integer supervisor_id) {
        supervisorService.deleteSupervisorById(supervisor_id);
    }

}