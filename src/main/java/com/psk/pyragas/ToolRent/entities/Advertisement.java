package com.psk.pyragas.ToolRent.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "Advertisement.findAll", query = "select a from Advertisement as a")
})
public class Advertisement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    private String text;

    //TODO: make statuses enum
    // Laisvas, užimtas etc
    private String status;

    private String name;

    //TODO: make types enum
    private String type;

    //TODO: think over property name, and enum
    private String fuelType;

    // FROM ITEM
    private String location;

    // FROM ITEM
    private String fuelLevel;

    private String measurements;

    private Double weight;
    private BigDecimal rentPrice;
    private BigDecimal operatorPrice;

    @ManyToOne
    private Profile profile;

    private String image;

    @OneToMany(mappedBy = "advertisement", cascade = CascadeType.ALL)
    private List<Order> orders;

    public void addOrder(Order order){
        orders.add(order);
        order.setAdvertisement(this);
    }
}
