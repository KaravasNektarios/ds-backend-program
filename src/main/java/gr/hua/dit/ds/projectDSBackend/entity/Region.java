package gr.hua.dit.ds.projectDSBackend.entity;

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
    private Integer id;

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotNull
    private boolean available;


    @OneToMany(mappedBy="region", cascade = CascadeType.ALL)
    private List<Farmer> participants;

    public Region() {
    }

    public Region(String name, boolean available, List<Farmer> participants) {
        this.name = name;
        this.available = available;
        this.participants = participants;
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

    public List<Farmer> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Farmer> participants) {
        this.participants = participants;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", available=" + available +
                ", participants=" + participants +
                '}';
    }
}
