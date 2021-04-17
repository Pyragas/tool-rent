package com.psk.pyragas.ToolRent.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "Photo.findAll", query = "select p from Photo as p")
})
public class Photo {
    @Id
    @GeneratedValue
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    private String url;

    @ManyToOne
    private Advertisement advertisement;
}
