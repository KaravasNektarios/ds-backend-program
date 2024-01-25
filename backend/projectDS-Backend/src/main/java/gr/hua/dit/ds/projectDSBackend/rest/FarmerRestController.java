package gr.hua.dit.ds.projectDSBackend.rest;

import gr.hua.dit.ds.projectDSBackend.entity.Farmer;
import gr.hua.dit.ds.projectDSBackend.entity.Role;
import gr.hua.dit.ds.projectDSBackend.service.FarmerService;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farmers")
public class FarmerRestController {

    @Autowired
    private FarmerService farmerService;

    @PostConstruct
    public void setup() {
        if (!farmerService.existsFarmerById(1)){
            Farmer farmer = new Farmer("farmer1","farmer1","farmer1",
                   "farmer1@gmail.com","pass123", "1212312312");
            farmerService.saveFarmer(farmer);
        }

        if (!farmerService.existsFarmerById(2)){
            Farmer farmer = new Farmer("farmer2","farmer2","farmer2",
                    "farmer2@gmail.com","pass123", "1231211112");
            farmerService.saveFarmer(farmer);
        }

        if (!farmerService.existsFarmerById(3)){
            Farmer farmer = new Farmer("farmer3","farmer3","farmer3",
                    "farmer3@gmail.com","pass123", "1231231234");
            farmerService.saveFarmer(farmer);
        }

    }

    @GetMapping("")
    public List<Farmer> getFarmers(){

        return farmerService.getFarmers();
    }

    @GetMapping("{farmer_id}")
    public Farmer gatFarmerById(@PathVariable Integer farmer_id){
        if (farmerService.existsFarmerById(farmer_id)){
            return farmerService.getFarmerById(farmer_id);
        }
        return null;
    }

    @PostMapping("newFarmer")
    public void saveFarmer(@RequestBody Farmer farmer) {
        farmerService.saveFarmer(farmer);
    }

    @DeleteMapping("deleteFarmerById/{farmer_id}")
    public void deleteFarmerById(@PathVariable Integer farmer_id) {
        farmerService.deleteFarmerById(farmer_id);
    }


}