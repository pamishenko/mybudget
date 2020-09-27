package ru.pamishenko.myBudget.entitys;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cathegoryes")
public class Cathegory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;


    @OneToMany(mappedBy = "cathegory")
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Cathegory() {
    }

    public Cathegory(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }
}
