package com.psk.pyragas.ToolRent.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@DiscriminatorValue("1")
public class LegalPerson extends Profile implements Serializable {

    @Column(unique = true)
    private String companyCode;

    private String name;
}
