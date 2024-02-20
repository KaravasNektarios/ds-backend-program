package gr.hua.dit.ds.projectDSBackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @NotBlank
    @Column
    private String name;

    @NotNull
    @Column
    private Integer status; // 0 --> kamia apantisi pros to paron
                            // 1 --> thetiki apantisi
                            // -1 --> arnitiki apantisi

    @Column
    private String details ;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "request_farmers",
            joinColumns = @JoinColumn(name = "request_id"),
            inverseJoinColumns = @JoinColumn(name = "farmer_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames={"farmer_id", "request_id"})}
    )
    private List<Farmer> farmers;




    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "request_products",
            joinColumns = @JoinColumn(name = "request_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames={"product_id", "request_id"})}
    )
    private List<Product> products;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="region_id")
    private Region region;

    public Request(String name, Integer status, String details) {
        this.name = name;
        this.status = status;
        this.details = details;
    }

    public Request(String name, Integer status, String details, List<Farmer> farmers, List<Product> products, Region region) {
        this.name = name;
        this.status = status;
        this.details = details;
        this.farmers = farmers;
        this.products = products;
        this.region = region;
    }

    public Request() {
    }

    public Request(Integer id, String name, Integer status, String details, List<Farmer> farmers, List<Product> products, Region region) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.details = details;
        this.farmers = farmers;
        this.products = products;
        this.region = region;
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

    public List<Farmer> getFarmers() {
        return farmers;
    }

    public void setFarmers(List<Farmer> farmers) {
        this.farmers = farmers;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", details='" + details + '\'' +
                ", farmers=" + farmers +
                ", products=" + products +
                ", region=" + region +
                '}';
    }
}
