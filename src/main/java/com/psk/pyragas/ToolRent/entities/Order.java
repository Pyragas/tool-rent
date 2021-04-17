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
        @NamedQuery(name = "Message.findAll", query = "select m from Message as m")
})
public class Order implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    private BigDecimal price;

    //TODO: think over naming, make enum for status
    private String status;

    private String deliveryLocation;

    private Date rentTimeStart;

    private Date rentTimeEnd;

    private Boolean operator;

    @ManyToOne
    private Profile profile;

    @ManyToMany
    private List<Item> items;

    //TODO:implement properties

}
