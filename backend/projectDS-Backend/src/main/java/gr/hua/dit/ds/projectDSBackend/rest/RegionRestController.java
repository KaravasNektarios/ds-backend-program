package gr.hua.dit.ds.projectDSBackend.rest;

import gr.hua.dit.ds.projectDSBackend.entity.Farmer;
import gr.hua.dit.ds.projectDSBackend.entity.Product;
import gr.hua.dit.ds.projectDSBackend.entity.Region;
import gr.hua.dit.ds.projectDSBackend.service.FarmerService;
import gr.hua.dit.ds.projectDSBackend.service.RegionService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/regions")
public class RegionRestController {

    @Autowired
    private RegionService regionService;

    @PostConstruct
    public void setup() {
        if (!regionService.existsRegionById(1)) {
            Region region = new Region("Region1", true, null);
            regionService.saveRegion(region);
        }
        if (!regionService.existsRegionById(2)) {
            Region region = new Region("Region2", true, null);
            regionService.saveRegion(region);
        }
        if (!regionService.existsRegionById(3)) {
            Region region = new Region("Region3", true, null);
            regionService.saveRegion(region);
        }
    }

    @GetMapping("")
    public List<Region> getRegions() {
        return regionService.getRegions();
    }

    @GetMapping("{region_id}")
    public Region getRegionById(@PathVariable Integer region_id) {
        if (regionService.existsRegionById(region_id)){
            return regionService.getRegionById(region_id);
        }
        return null;
    }

    @DeleteMapping("deleteRegionById/{region_id}")
    public void deleteRegionById(@PathVariable Integer region_id) {
        regionService.deleteRegionById(region_id);
    }


    @PostMapping("newRegion")
    public void saveRegion(Region region) {
        regionService.saveRegion(region);
    }


    @GetMapping("{region_id}/participants")
    public List<Farmer> getRegionByIdParticipants(@PathVariable Integer region_id) {
        if (regionService.existsRegionById(region_id)) {
            return regionService.getRegionById(region_id).getParticipants();
        }
        return null;
    }

}
