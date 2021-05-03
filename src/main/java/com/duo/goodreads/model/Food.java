package com.duo.goodreads.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Food {
    @Id
    @Column(name = "id_food")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFood")
    @SequenceGenerator(name = "seqFood", sequenceName = "SEQ_FOOD", allocationSize = 1)
    Long id;

    private String name;

    private String imgUrl;

    @ManyToMany(mappedBy = "foods")
    private Set<User> users = new HashSet<>();
    
    @OneToMany(mappedBy="food")
    private Set<FoodRating> ratings;

	public Long getId() { return id; }

	public void setId(Long id) { this.id = Objects.requireNonNull(id); }

	public String getName() { return name; }

	public void setName(String name) { this.name = Objects.requireNonNull(name); }

	public String getImgUrl() { return imgUrl; }

	public void setImgUrl(String imgUrl) { this.imgUrl = Objects.requireNonNull(imgUrl); }

	public Set<User> getUsers() { return users; }

	public void setUsers(Set<User> users) { this.users = Objects.requireNonNull(users); }

	public Set<FoodRating> getRatings() { return ratings; }

	public void setRatings(Set<FoodRating> ratings) { this.ratings = Objects.requireNonNull(ratings); }
}