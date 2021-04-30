package com.duo.goodreads.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Meal {
    @Id
    @Column(name = "ID_MEAL")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMeal")
    @SequenceGenerator(name = "seqMeal", sequenceName = "SEQ_MEAL", allocationSize = 1)
    Long id;

    private String name;

    private String imgUrl;

    @ManyToMany(mappedBy = "meals")
    private Set<User> users = new HashSet<>();

}
