package gr.hua.dit.ds.projectDSBackend.rest;

import gr.hua.dit.ds.projectDSBackend.entity.Farmer;
import gr.hua.dit.ds.projectDSBackend.entity.Product;
import gr.hua.dit.ds.projectDSBackend.entity.Region;
import gr.hua.dit.ds.projectDSBackend.service.FarmerService;
import gr.hua.dit.ds.projectDSBackend.service.ProductService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    @Autowired
    private ProductService productService;


    @GetMapping("")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("{product_id}")
    public Product getProductById(@PathVariable Integer product_id) {
        if (productService.existsProductById(product_id)) {
            return productService.getProductById(product_id);
        }
        return null;
    }

    @DeleteMapping("deleteProductById/{product_id}")
    public void deleteProductById(@PathVariable Integer product_id) {
        productService.deleteProductById(product_id);
    }


    @PostMapping("newProduct")
    public void saveProduct(@RequestBody  Product product) {

        productService.saveProduct(product);
    }

    @GetMapping("{product_id}/farmers")
    public List<Farmer> getProductByIdFarmers(@PathVariable Integer product_id) {
        if (productService.existsProductById(product_id)) {
            return productService.getProductById(product_id).getFarmers();
        }
        return null;
    }

    @GetMapping("{product_id}/regions")
    public List<Region> getProductByIdRegions(@PathVariable Integer product_id) {
        if (productService.existsProductById(product_id)) {
            return productService.getProductById(product_id).getRegions();
        }
        return null;
    }


}