/**
 * 
 */
package com.duo.goodreads.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 *
 * @author Matthew Mazzotta
 */
@Embeddable
public class FoodRatingKey implements Serializable {

	private static final long serialVersionUID = -3044196888412577966L;

	@Column
	private String username;
	
	@Column(name="id_food")
	private Long id;

	public String getUsername() { return username; }

	public void setUsername(String username) { this.username = Objects.requireNonNull(username); }

	public Long getId() { return id; }

	public void setId(Long id) { this.id = Objects.requireNonNull(id); }
	
	@Override
	public boolean equals(Object o) {
		if(o == this) return true;
		if(!(o instanceof FoodRatingKey)) return false;
		FoodRatingKey frk = (FoodRatingKey) o;
		return Objects.equals(frk.id, id) && Objects.equals(frk.username, username);
	}
	
	@Override
	public int hashCode() {
		int result = Long.hashCode(id);
		result = 31 * result + username.hashCode();
		return result;
	}
}