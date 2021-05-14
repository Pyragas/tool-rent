package com.psk.pyragas.ToolRent.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "Order.findAll", query = "select o from Order as o"),
        @NamedQuery(name="Order.findAllByProfile", query = "select o from Order as o where o.profile.id=:profileId")
})
@Table(name = "order_table")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal rentPrice;
    private BigDecimal operatorPrice;

    //TODO: think over naming, make enum for status
    private String status;

    private String deliveryLocation;

    private Date rentTimeStart;

    private Date rentTimeEnd;

    @ManyToOne
    private Profile profile;

    @ManyToMany
    private List<Item> items;

    public BigDecimal getFullPrice(){
        if (operatorPrice != null) {
            return rentPrice.add(operatorPrice);
        }
        else return rentPrice;
    }
}
