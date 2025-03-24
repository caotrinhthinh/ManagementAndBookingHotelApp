package com.example.ManagementAndBookingHotelApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ManagementAndBookingHotelApp.Model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
