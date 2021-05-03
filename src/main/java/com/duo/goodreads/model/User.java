package com.duo.goodreads.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
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

}
