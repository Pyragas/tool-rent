package com.psk.pyragas.ToolRent.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Getter
@Setter
@DiscriminatorValue("1")
public class LegalPerson extends Profile implements Serializable {

    @NotNull
    @Column(unique = true)
    private String companyCode;

    @NotNull
    private String name;
}
