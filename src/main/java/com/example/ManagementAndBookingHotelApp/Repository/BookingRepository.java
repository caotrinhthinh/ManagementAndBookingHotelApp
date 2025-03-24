package com.example.ManagementAndBookingHotelApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ManagementAndBookingHotelApp.Model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
