package ru.pamishenko.myBudget.entitys;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_units")
public class ProductUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String value;

    @ManyToOne
    @JoinColumn(name = "product_unit_id")
    private Product product;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductUnit() {
    }

    public ProductUnit(String name, String value, Product product) {
        this.name = name;
        this.value = value;
        this.product = product;
    }
}
