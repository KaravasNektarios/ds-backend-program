package gr.hua.dit.ds.projectDSBackend.rest;

import gr.hua.dit.ds.projectDSBackend.entity.Supervisor;
import gr.hua.dit.ds.projectDSBackend.service.SupervisorService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supervisors")
public class SupervisorRestController {

    @Autowired
    private SupervisorService supervisorService;


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
