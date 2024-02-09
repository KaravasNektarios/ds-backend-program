package gr.hua.dit.ds.projectDSBackend.service;

import gr.hua.dit.ds.projectDSBackend.entity.Farmer;
import gr.hua.dit.ds.projectDSBackend.repository.FarmerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FarmerService {

    @Autowired
    private FarmerRepository farmerRepository;


    @Transactional
    public List<Farmer> getFarmers() {
        return farmerRepository.findAll();
    }

    @Transactional
    public void saveFarmer(Farmer farmer) {
        farmerRepository.save(farmer);
    }

    @Transactional
    public void deleteFarmerById(Integer farmerId) {
        farmerRepository.deleteById(farmerId);
    }

    @Transactional
    public Farmer getFarmerById(Integer farmerId) {
        return farmerRepository.findById(farmerId).get();
    }

    @Transactional
    public Boolean existsFarmerById(Integer farmerId) {
        return farmerRepository.existsById(farmerId);
    }

    @Transactional
    public Boolean existsFarmerByUsername(String username) {
        return farmerRepository.existsByUsername(username);
    }

    @Transactional
    public Optional<Farmer> getFarmerByUsername(String username) {
        return farmerRepository.findByUsername(username);
    }

}
