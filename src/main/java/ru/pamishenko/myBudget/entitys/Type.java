package ru.pamishenko.myBudget.entitys;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "types")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "type")
    private List<Cathegory> cathegories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cathegory> getCathegories() {
        return cathegories;
    }

    public void setCathegories(List<Cathegory> cathegories) {
        this.cathegories = cathegories;
    }

    public Type() {
    }

    public Type(String name, List<Cathegory> cathegories) {
        this.name = name;
        this.cathegories = cathegories;
    }

    @Override
    public String toString() {
        return name;
    }
}
