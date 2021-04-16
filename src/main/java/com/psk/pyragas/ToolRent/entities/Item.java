package com.psk.pyragas.ToolRent.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "Item.findAll", query = "select i from Item as i")
})
public class Item implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String location;

    //TODO: think of data type for fuel, if there isi fuel property anyways
    private String fuelLevel;

    //TODO: think over naming, make enum for status
    private String status;

    //TODO:implement properties
    @ManyToOne
    private Advertisement advertisement;

    @ManyToMany(mappedBy = "items")
    private List<Order> orders;
}
