package com.example.ManagementAndBookingHotelApp.Service.Interface;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.example.ManagementAndBookingHotelApp.DTO.Response;

public interface IRoomService {
    Response addNewRoom(String photo, String roomType, BigDecimal roomPrice, String description);
    List<String> getAllRoomsTypes();
    Response getAllRooms();
    Response deleetRoom(Long roomId);
    Response updateRoom(Long roomId, String description, String roomType, BigDecimal roomPrice, String imageUrl);
    Response getRoomById(Long roomId);
    Response getAvailableRoomsByDataAndType(LocalDate checkInDate, LocalDate checkOutDate, String roomType);
    Response getAllAvailableRooms();
}
