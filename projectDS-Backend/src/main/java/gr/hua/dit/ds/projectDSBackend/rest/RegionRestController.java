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
    public void saveRegion(@RequestBody Region region) {
        System.out.println(region.toString());
        regionService.saveRegion(region);
    }


}
