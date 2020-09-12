package ru.pamishenko.myBudget.entitys;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "salers")
public class Saler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "saler")
    private List<Purchase> purchases;

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

    public Saler() {
    }

    public Saler(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
