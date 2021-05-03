package com.duo.goodreads.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Food {
    @Id
    @Column(name = "ID_FOOD")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFood")
    @SequenceGenerator(name = "seqFood", sequenceName = "SEQ_FOOD", allocationSize = 1)
    Long id;

    private String name;

    private String imgUrl;

    @ManyToMany(mappedBy = "foods")
    private Set<User> users = new HashSet<>();

}
