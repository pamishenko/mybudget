package ru.pamishenko.myBudget.entitys;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rolles")
public class Rolle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rolle(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Rolle [id = %d, name = %s]", id, name);
    }
}
