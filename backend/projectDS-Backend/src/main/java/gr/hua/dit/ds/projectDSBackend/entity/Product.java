package gr.hua.dit.ds.projectDSBackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 50)
    private String name;

    private double price;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "farmer_products",
            joinColumns = @JoinColumn(name = "farmer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Farmer> farmers = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "region_products",
            joinColumns = @JoinColumn(name = "region_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Region> regions = new HashSet<>();

    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name, double price, Set<Farmer> farmers, Set<Region> regions) {
        this.name = name;
        this.price = price;
        this.farmers = farmers;
        this.regions = regions;
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

    public Set<Farmer> getFarmers() {
        return farmers;
    }

    public void setFarmers(Set<Farmer> farmers) {
        this.farmers = farmers;
    }

    public Set<Region> getRegions() {
        return regions;
    }

    public void setRegions(Set<Region> regions) {
        this.regions = regions;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", farmers=" + farmers +
                ", regions=" + regions +
                '}';
    }
}
