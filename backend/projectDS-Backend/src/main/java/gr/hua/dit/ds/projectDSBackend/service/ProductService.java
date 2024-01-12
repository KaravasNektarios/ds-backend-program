package gr.hua.dit.ds.projectDSBackend.service;


import gr.hua.dit.ds.projectDSBackend.entity.Product;
import gr.hua.dit.ds.projectDSBackend.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Transactional
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Transactional
    public void deleteProductById(Integer productId) {
        productRepository.deleteById(productId);
    }

    @Transactional
    public Product getProductById(Integer productId) {
        return productRepository.findById(productId).get();
    }

    @Transactional
    public Boolean existsProductById(Integer productId) {
        return productRepository.existsById(productId);
    }

}
