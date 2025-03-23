package com.example.ManagementAndBookingHotelApp.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDTO {
    private Long id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numOfAdults;
    private int numOfChildrens;
    private String bookingConfirmationCode;
    private RoomDTO room;
    private UserDTO user;
}
