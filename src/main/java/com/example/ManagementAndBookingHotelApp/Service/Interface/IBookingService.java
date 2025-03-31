package com.example.ManagementAndBookingHotelApp.Service.Interface;

import com.example.ManagementAndBookingHotelApp.DTO.Response;
import com.example.ManagementAndBookingHotelApp.Model.Booking;

public interface IBookingService {
    Response saveBooking(Long roomId, Long userId, Booking bookingRequest);
    Response findBookingByConfirmationCode(String confirmationCode);
    Response getAllBookings();
    Response cancelBooking(Long bookingId);
}
