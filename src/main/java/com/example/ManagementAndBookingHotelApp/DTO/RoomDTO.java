package com.example.ManagementAndBookingHotelApp.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomDTO {
    private Long id;
    private String roomType;
    private String roomPrice;
    private String roomImageUrl;
    private String roomDescription;
    private List<BookingDTO> bookings;
}
