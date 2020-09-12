package ru.pamishenko.myBudget.entitys;

import javax.persistence.*;

/**
 * Запись каждой отдельной покупки
 */

@Entity
@Table(name = "purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "check_number")
    String check;

    @ManyToOne
    @JoinColumn(name = "saler_id")
    Saler saler;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    @Column
    Long price;

    @Column
    Integer count;

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public Saler getSaler() {
        return saler;
    }

    public void setSaler(Saler saler) {
        this.saler = saler;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Purchase() {
    }

//    public Purchase(String check, long price, Product product, Saler saler, User user) {
    public Purchase(User user, String check , Saler saler, Product product, Integer count,  long price) {
        this.user = user;
        this.check = check;
        this.saler = saler;
        this.product = product;
        this.price = price;
        this.count = count;
    }

    @Override
    public String toString() {
        return String.format("%s, count: %d, price: %d, User: %s, check: %s, saller: %s", product, count, price, user.getLogin(), check, saler);
    }
}
