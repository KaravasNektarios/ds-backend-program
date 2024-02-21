package gr.hua.dit.ds.projectDSBackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;


    @Column
    private String name;

    @Column
    private double price;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "product_farmers",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "farmer_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames={"farmer_id", "product_id"})}
    )
    private List<Farmer> farmers;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "request_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "request_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames={"product_id", "request_id"})}
    )
    private List<Request> requests;


    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "region_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "region_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames={"product_id", "region_id"})}
    )
    private List<Region> regions;

    public Product(Integer id, String name, double price, List<Farmer> farmers, List<Request> requests, List<Region> regions) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.farmers = farmers;
        this.requests = requests;
        this.regions = regions;
    }

    public Product(String name, double price, List<Farmer> farmers, List<Request> requests, List<Region> regions) {
        this.name = name;
        this.price = price;
        this.farmers = farmers;
        this.requests = requests;
        this.regions = regions;
    }

    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Farmer> getFarmers() {
        return farmers;
    }

    public void setFarmers(List<Farmer> farmers) {
        this.farmers = farmers;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", farmers=" + farmers +
                ", requests=" + requests +
                ", regions=" + regions +
                '}';
    }
}
