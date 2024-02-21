package gr.hua.dit.ds.projectDSBackend.service;

import gr.hua.dit.ds.projectDSBackend.entity.Product;
import gr.hua.dit.ds.projectDSBackend.entity.Supervisor;
import gr.hua.dit.ds.projectDSBackend.repository.ProductRepository;
import gr.hua.dit.ds.projectDSBackend.repository.SupervisorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupervisorService {

    @Autowired
    private SupervisorRepository supervisorRepository;

    @Transactional
    public List<Supervisor> getSupervisors() {
        return supervisorRepository.findAll();
    }

    @Transactional
    public void saveSupervisor(Supervisor supervisor) {
        supervisorRepository.save(supervisor);
    }

    @Transactional
    public void deleteSupervisorById(Integer supervisorId) {
        supervisorRepository.deleteById(supervisorId);
    }

    @Transactional
    public Supervisor getSupervisorById(Integer supervisorId) {
        return supervisorRepository.findById(supervisorId).get();
    }

    @Transactional
    public Boolean existsSupervisorById(Integer supervisorId) {
        return supervisorRepository.existsById(supervisorId);
    }

}
