package com.duo.goodreads.model;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    private String username;

    @Column
    private String authority;

    @OneToOne
    @MapsId
    @JoinColumn(name = "username")
    private User user;

	public String getUsername() { return username; }

	public void setUsername(String username) { this.username = username; }

	public String getAuthority() { return authority; }

	public void setAuthority(String authority) { this.authority = authority; }

	public User getUser() { return user; }

	public void setUser(User user) { this.user = user; }
}