package com.zpx.alpha.models.entities;


import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.time.LocalDateTime;
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
