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
    @GeneratedValue
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    private String text;

    //TODO: make statuses enum
    private String status;

    private String name;

    //TODO: make types enum
    private String type;

    //TODO: think over property name, and enum
    private String fuelType;

    private String measurements;

    private Double weight;
    private BigDecimal rentPrice;
    private BigDecimal operatorPrice;

    @ManyToOne
    private Profile profile;

    //TODO: think over, if this is the right way to store photos
    @OneToMany(mappedBy = "advertisement")
    private List<Photo> photos;

    @OneToMany(mappedBy = "advertisement")
    private List<Item> items;
}
