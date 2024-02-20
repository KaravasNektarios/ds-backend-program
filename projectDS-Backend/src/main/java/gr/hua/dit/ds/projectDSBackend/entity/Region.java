package gr.hua.dit.ds.projectDSBackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
@Entity
@Table(name = "regions")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @NotBlank
    @Column
    private String name;

    @NotNull
    @Column
    private boolean available;


    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "region_products",
            joinColumns = @JoinColumn(name = "region_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames={"product_id", "region_id"})}
    )
    private List<Product> products;

    public Region() {
    }

    public Region(String name) {
        this.name = name;
        this.available = true;
    }

    public Region(String name, boolean available) {
        this.name = name;
        this.available = available;
    }

    public Region(Integer id, String name, boolean available, List<Product> products) {
        this.id = id;
        this.name = name;
        this.available = available;
        this.products = products;
    }
    public Region(String name, boolean available, List<Product> products) {
        this.name = name;
        this.available = available;
        this.products = products;
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", available=" + available +
                ", products=" + products +
                '}';
    }
}
