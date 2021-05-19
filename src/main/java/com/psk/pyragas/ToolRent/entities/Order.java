package com.psk.pyragas.ToolRent.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "Message.findAll", query = "select m from Message as m")
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

    private Boolean operator;

    @ManyToOne(fetch = FetchType.LAZY)
    private Profile profile;

    @ManyToOne(fetch = FetchType.LAZY)
    private Advertisement advertisement;

    public BigDecimal getFullPrice(){
        if (operatorPrice != null) {
            return rentPrice.add(operatorPrice);
        }
        else return rentPrice;
    }
}
