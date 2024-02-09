package gr.hua.dit.ds.projectDSBackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotNull
    private Integer status; // 0 --> kamia apantisi pros to paron
                            // 1 --> thetiki apantisi
                            // -1 --> arnitiki apantisi

    private String details ;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "request_farmers",
            joinColumns = @JoinColumn(name = "farmer_id"),
            inverseJoinColumns = @JoinColumn(name = "request_id"))
    private Set<Farmer> farmers = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "request_products",
            joinColumns = @JoinColumn(name = "request_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products = new HashSet<>();


    @OneToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="region_id")
    private Region region;



    public Request() {
    }

    public Request(String name, Integer status, String details, Set<Farmer> farmers,
                              Set<Product> products, Region region) {

        this.name = name;
        this.status = status;
        this.details = details;
        this.farmers = farmers;
        this.products = products;
        this.region = region;
    }

    public Request(String name, Integer status, String details) {

        this.name = name;
        this.status = status;
        this.details = details;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Set<Farmer> getFarmers() {
        return farmers;
    }

    public void setFarmers(Set<Farmer> farmers) {
        this.farmers = farmers;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "RequestForApproval{" +
                "id=" + id +
                ", name='" + name + '\'' +
                "status=" + status +
                ", details='" + details + '\'' +
                ", farmers=" + farmers +
                ", products=" + products +
                ", region=" + region +
                '}';
    }
}
