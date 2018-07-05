package com.ismlslck.entity;

import javax.persistence.*;

@Entity
@Table(name = "authority")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinTable(
            name = "User_Authority",
            joinColumns = @JoinColumn(name = "authorityId"),
            inverseJoinColumns = @JoinColumn(name = "userId")
    )
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
