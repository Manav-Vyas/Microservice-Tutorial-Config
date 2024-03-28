package com.rating.service.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="rating")
public class Rating {

	@Id
	private String ratingId;
	private String hotelId;
	private String userId;
	private int rating;
	private String feedback;
}
