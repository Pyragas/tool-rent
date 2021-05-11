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
        @NamedQuery(name = "Profile.findAll", query = "select p from Profile as p"),
        @NamedQuery(name="Profile.findOneByEmail", query = "select p from Profile as p where p.email = :curEmail")
})
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn(name="customer_type",
        discriminatorType = DiscriminatorType.INTEGER)
public abstract class Profile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

}
