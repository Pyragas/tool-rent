package com.psk.pyragas.ToolRent.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@DiscriminatorValue("0")
public class NaturalPerson extends Profile implements Serializable {
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }

    //TODO: make it safe
    private String personalCode;

    private String name;

    private String surname;
}
