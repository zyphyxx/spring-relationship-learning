package com.zpx.alpha.models.entities;


import jakarta.persistence.*;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * falta implementar o total
 * @author ZyphyX
 */

@Entity
@Table
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    LocalDateTime momentPag;
    OrderStatus orderStatus;

    @ManyToMany
    @JoinTable(name = "order_product",joinColumns = @JoinColumn(name = "order_id"),inverseJoinColumns = @JoinColumn (name = "product_id"))
    private List<Product> products = new ArrayList<>();

    public Order(){}
    public Order(Long id,LocalDateTime momentPag,OrderStatus orderStatus){
        this.id = id;
        this.momentPag = momentPag;
        this.orderStatus = orderStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return Objects.equals(getId(), order.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public double total(){
        //TODO
        throw new UnsupportedOperationException("Metodo não implementado ainda");
    }
}
