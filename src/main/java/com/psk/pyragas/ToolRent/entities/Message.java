package com.psk.pyragas.ToolRent.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "Message.findAll", query = "select m from Message as m")
})
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    private Date timeSent;

    private String text;

    //TODO: decide, if it is the correct way to store image
    private String photoUrl;

    @ManyToOne
    private Chat chat;
}
