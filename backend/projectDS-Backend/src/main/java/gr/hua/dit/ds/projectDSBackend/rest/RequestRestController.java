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
    public void saveRequest(Request request) {
        requestService.saveRequest(request);
    }

}

