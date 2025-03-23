package com.example.ManagementAndBookingHotelApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ManagementAndBookingHotelApp.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
