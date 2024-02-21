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

import java.util.*;

import static java.lang.System.in;
import java.util.List;
import java.util.stream.Collectors;

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

        save_request.setStatus(0);

        Integer regionID = request.getRegionId();
        List<Region> regions = regionService.getRegions();
        Region save_region= null;

        for (Region region : regions) {
            if (region.getId().equals(regionID)){
                save_region = region;
            }
        }
        //save_request.setRegion(save_region);



        // -----------------


//        String[] idsArray = request.getProductsId().split(", ");
//
//        List<Integer> idsList = Arrays.stream(idsArray)
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//
//
//        System.out.println(idsList);
//
//
//        List<Product> products = productService.getProducts();
//        System.out.println(products);
//        List<Product> save_products = new ArrayList<>();
//
//        for (int id: idsList){
//            for (Product product: products){
//                if ((product.getId() == id)){
//                    System.out.printf("ID: %d", product.getId());
//                    save_products.add(product);
//                }
//            }
//        }
//
//        System.out.println("save_products:");
//        System.out.println(save_products.toString());
//        save_request.setProducts(null);




        System.out.println(save_request.toString());
        requestService.saveRequest(save_request);
    }

}

