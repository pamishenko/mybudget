package ru.pamishenko.myBudget.entitys;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private  Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "cathegory_id")
    private Cathegory cathegory;

    @OneToMany(mappedBy = "product")
    private List<ProductUnit> productUnits;

    @OneToMany(mappedBy = "product")
    private List<Purchase> purchases;

    public List<ProductUnit> getProductUnits() {
        return productUnits;
    }

    public void setProductUnits(List<ProductUnit> productUnits) {
        this.productUnits = productUnits;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
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

    public Cathegory getCathegory() {
        return cathegory;
    }

    public void setCathegory(Cathegory cathegory) {
        this.cathegory = cathegory;
    }

    public Product() {
    }

    public Product(String name, Cathegory cathegory) {
        this.name = name;
        this.cathegory = cathegory;
    }

    @Override
    public String toString() {
        return String.format("Product: %s, Cathegory: %s, Type: %s", name, cathegory, cathegory.getType());

    }
}
