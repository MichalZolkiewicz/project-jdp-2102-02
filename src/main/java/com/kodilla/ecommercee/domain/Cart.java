package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CARTS")
public class Cart {

    private int cartId;
    private List<Product> products = new LinkedList<>();
    private User user;
    private Order order;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "CART_ID")
    public int getCartId() {
        return cartId;
    }

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinTable(
            name = "CART_PRODUCT",
            joinColumns = {@JoinColumn(name = "JOIN_CART_ID", referencedColumnName = "CART_ID")},
            inverseJoinColumns = {@JoinColumn(name = "JOIN_PRODUCT_ID", referencedColumnName = "PRODUCT_ID")})

    public List<Product> getProducts() {
        return products;
    }

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    public User getUser() {
        return user;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    public Order getOrder() {
        return order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return cartId == cart.cartId && products.equals(cart.products) && user.equals(cart.user) && order.equals(cart.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, products, user, order);
    }
}