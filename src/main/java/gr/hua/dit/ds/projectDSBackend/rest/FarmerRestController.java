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
    public void saveFarmer(@RequestBody  Farmer farmer) {
        System.out.println(farmer.toString());
        Farmer save_farmer = new Farmer();
        save_farmer.setFirstName(farmer.getFirstName());
        save_farmer.setLastName(farmer.getLastName());
        save_farmer.setUsername(farmer.getUsername());
        save_farmer.setEmail(farmer.getEmail());
        save_farmer.setPassword(farmer.getPassword());
        save_farmer.setPhone(farmer.getPhone());

        farmerService.saveFarmer(save_farmer);
    }

    @DeleteMapping("deleteFarmerById/{farmer_id}")
    public void deleteFarmerById(@PathVariable Integer farmer_id) {
        farmerService.deleteFarmerById(farmer_id);
    }


}