package gr.hua.dit.ds.projectDSBackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(length = 50)
    private String name;

    public Role() {

    }

    public Role(String name) {

        this.name = name;
    }

    public Integer getId() {

        return id;
    }


    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    @Override
    public String toString() {

        return name;
    }


}

