package com.duo.goodreads.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String username;

    @Column
    private String password;

    @Column
    private boolean enabled;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Authority authority;

    @ManyToMany
    @JoinTable(
            //name = "users_foods",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "id_food"))
    Set<Food> foods = new HashSet<>();

    @OneToMany(mappedBy="user")
    private Set<FoodRating> ratings;
    
    @Override
    public boolean equals(Object o){
        if (!(o instanceof User))
            return false;
        User user = (User) o;
        return Objects.equals(this.username, user.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.username);
    }

	public String getUsername() { return username; }

	public void setUsername(String username) { this.username = Objects.requireNonNull(username); }

	public String getPassword() { return password; }

	public void setPassword(String password) { this.password = Objects.requireNonNull(password); }

	public boolean isEnabled() { return enabled; }

	public void setEnabled(boolean enabled) { this.enabled = enabled; }

	public Authority getAuthority() { return authority; }

	public void setAuthority(Authority authority) { this.authority = Objects.requireNonNull(authority); }

	public Set<Food> getFoods() { return foods; }

	public void setFoods(Set<Food> foods) { this.foods = Objects.requireNonNull(foods); }

	public Set<FoodRating> getRatings() { return ratings; }

	public void setRatings(Set<FoodRating> ratings) { this.ratings = Objects.requireNonNull(ratings); }
}
