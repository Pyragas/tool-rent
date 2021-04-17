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
        @NamedQuery(name = "Chat.findAll", query = "select c from Chat as c")
})
public class Chat implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @ManyToMany
    private List<Profile> profiles = new ArrayList<>();

    @ManyToMany
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "chat")
    private List<Message> messages = new ArrayList<>();
}
