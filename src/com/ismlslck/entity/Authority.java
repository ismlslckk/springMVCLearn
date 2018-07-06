package com.ismlslck.entity;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String authority;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinTable(
            name = "User_Authority",
            joinColumns = @JoinColumn(name = "authorityId"),
            inverseJoinColumns = @JoinColumn(name = "userId")
    )
    private User user;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

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




}
