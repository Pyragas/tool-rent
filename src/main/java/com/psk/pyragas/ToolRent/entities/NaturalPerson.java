package com.psk.pyragas.ToolRent.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Getter
@Setter
@DiscriminatorValue("0")
@NotNull
public class NaturalPerson extends Profile implements Serializable {
    //TODO: make it safe
    @NotNull
    @Column(unique = true)
    private String personalCode;

    @NotNull
    private String name;

    @NotNull
    private String surname;
}
