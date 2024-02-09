package gr.hua.dit.ds.projectDSBackend.service;

import gr.hua.dit.ds.projectDSBackend.entity.Product;
import gr.hua.dit.ds.projectDSBackend.entity.Region;
import gr.hua.dit.ds.projectDSBackend.repository.ProductRepository;
import gr.hua.dit.ds.projectDSBackend.repository.RegionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    @Transactional
    public List<Region> getRegions() {
        return regionRepository.findAll();
    }

    @Transactional
    public void saveRegion(Region region) {
        regionRepository.save(region);
    }

    @Transactional
    public void deleteRegionById(Integer regionId) {
        regionRepository.deleteById(regionId);
    }

    @Transactional
    public Region getRegionById(Integer regionId) {
        return regionRepository.findById(regionId).get();
    }

    @Transactional
    public Boolean existsRegionById(Integer regionId) {
        return regionRepository.existsById(regionId);
    }

}
