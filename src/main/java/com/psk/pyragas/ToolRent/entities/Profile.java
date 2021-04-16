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

    //TODO: make it safe
    private String personalCode;

    private String companyCode;

    private String name;
    private String surname;

    private String phoneNo;
    private String email;

    //TODO: implement secure password
    private String password;

    private Float rating;

    @OneToMany(mappedBy = "order")
    private List<Order> orders = new ArrayList<>();

    @ManyToMany(mappedBy = "chat")
    private List<Chat> chats = new ArrayList<>();

    @OneToMany(mappedBy = "advertisement")
    private List<Advertisement> ads = new ArrayList<>();
}
