package com.user.service.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.user.service.Entity.User;

public interface UserRepository extends JpaRepository<User, String> {


}
