package com.hotel.service.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="hotel")
public class Hotel {

	@Id
	private String hotelId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="location")
	private String location;
	
	@Column(name="about")
	private String about;
	
}
