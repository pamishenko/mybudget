package ru.pamishenko.myBudget.entitys;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    String login;

    @Column
    String name;

    @Column
    String password;

    @ManyToOne
    @JoinColumn(name = "rolle_id")
    private Rolle rolle;

    @OneToMany(mappedBy = "user")
    private List<Purchase> purchases;

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rolle getRolle() {
        return rolle;
    }

    public void setRolle(Rolle rolle) {
        this.rolle = rolle;
    }

    public User() {
    }

    public User(String login, String name, String password, Rolle rolle) {
        this.login = login;
        this.name = name;
        this.password = password;
        this.rolle = rolle;
    }

    @Override
    public String toString() {
        return String.format("User id: %d, login: %s, name: %s, rolle: %s", id, login, name, rolle);
    }
}
