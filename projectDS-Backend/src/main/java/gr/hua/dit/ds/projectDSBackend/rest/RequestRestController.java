package gr.hua.dit.ds.projectDSBackend.rest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gr.hua.dit.ds.projectDSBackend.entity.*;
import gr.hua.dit.ds.projectDSBackend.service.FarmerService;
import gr.hua.dit.ds.projectDSBackend.service.ProductService;
import gr.hua.dit.ds.projectDSBackend.service.RegionService;
import gr.hua.dit.ds.projectDSBackend.service.RequestService;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.System.in;

@RestController
@RequestMapping("/api/requests")
public class RequestRestController {


    @Autowired
    private RequestService requestService;

    @Autowired
    private FarmerService farmerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private RegionService regionService;


    @GetMapping("")
    public List<Request> getRequests() {
        return requestService.getRequests();
    }

    @GetMapping("{request_id}")
    public Request getRequestById(@PathVariable Integer request_id) {
        if (requestService.existsRequestById(request_id)) {
            return requestService.getRequestById(request_id);
        }
        return null;
    }

    @DeleteMapping("deleteRequestById/{request_id}")
    public void deleteRequestById(@PathVariable Integer request_id) {
        requestService.deleteRequestById(request_id);
    }


    @PostMapping("newRequest")
    public void saveRequest(@RequestBody RequestForm request){
        System.out.println(request.toString());
        Request save_request = new Request();

        save_request.setName(request.getName());

        Integer farmerID1,farmerID2, farmerID3;
        if (request.getFarmersId().get(0) != null){
            farmerID1 = Integer.parseInt(String.valueOf(request.getFarmersId().get(0)));
        }else{
            farmerID1=null;
        }
        if (request.getFarmersId().get(1) != null){
            farmerID2 = Integer.parseInt(String.valueOf(request.getFarmersId().get(1)));
        }else{
            farmerID2=null;
        }
        if (request.getFarmersId().get(2) != null){
            farmerID3 = Integer.parseInt(String.valueOf(request.getFarmersId().get(2)));
        }else{
            farmerID3=null;
        }

        List<Farmer> farmers = farmerService.getFarmers();
        List<Farmer> save_farmers = null;
        for (Farmer farmer : farmers) {
            if ((farmer.getId().equals(farmerID1)) || (farmer.getId().equals(farmerID2)) || (farmer.getId().equals(farmerID3))){
                save_farmers.add(farmer);
            }
        }
        save_request.setFarmers(save_farmers);


        Integer productID1, productID2, productID3;
        if (request.getProductsId().get(0) != null){
            productID1 = Integer.parseInt(String.valueOf(request.getProductsId().get(0)));
        }else{
            productID1=null;
        }
        if (request.getProductsId().get(1) != null){
            productID2 = Integer.parseInt(String.valueOf(request.getProductsId().get(1)));
        }else{
            productID2=null;
        }
        if (request.getProductsId().get(2) != null){
            productID3 = Integer.parseInt(String.valueOf(request.getProductsId().get(2)));
        }else{
            productID3=null;
        }

        List<Product> products = productService.getProducts();
        List<Product> save_products = null;
        for (Product product : products) {
            if ((product.getId().equals(productID1)) || (product.getId().equals(productID2)) ||
                    (product.getId().equals(productID3))){
                save_products.add(product);
            }
        }
        save_request.setProducts(save_products);


        Integer regionID;
        if (request.getRegionId() != null){
            regionID = Integer.parseInt(String.valueOf(request.getRegionId()));
        }else{
            regionID = null;
        }

        List<Region> regions = regionService.getRegions();
        Region save_region= null;
        for (Region region : regions) {
            if (region.getId().equals(regionID)){
                save_region = region;
            }
        }
        save_request.setRegion(save_region);
        save_request.setStatus(0);
        System.out.println(save_request.toString());
        requestService.saveRequest(save_request);
    }
    
}

