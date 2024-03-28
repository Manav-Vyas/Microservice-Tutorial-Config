package com.hotel.service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.service.Entity.Hotel;

public interface hotlRepository extends JpaRepository<Hotel, String> {

}
