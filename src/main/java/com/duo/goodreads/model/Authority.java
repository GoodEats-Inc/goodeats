package com.duo.goodreads.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
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

}
