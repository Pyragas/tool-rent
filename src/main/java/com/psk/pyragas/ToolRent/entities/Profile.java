package com.psk.pyragas.ToolRent.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "Profile.findAll", query = "select p from Profile as p")
})
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn(name="customer_type",
        discriminatorType = DiscriminatorType.INTEGER)
public class Profile implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    private String phoneNo;
    private String email;

    //TODO: implement secure password
    private String password;

    private String username;

    private Float rating;

    @OneToMany(mappedBy = "profile")
    private List<Order> orders = new ArrayList<>();

    @ManyToMany(mappedBy = "profiles")
    private List<Chat> chats = new ArrayList<>();

    @OneToMany(mappedBy = "profile")
    private List<Advertisement> ads = new ArrayList<>();

    public void setName(String username) {
        this.username = username;
    }
}
