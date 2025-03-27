package com.example.ManagementAndBookingHotelApp.Service.Interface;

import com.example.ManagementAndBookingHotelApp.DTO.LoginRequest;
import com.example.ManagementAndBookingHotelApp.DTO.Response;
import com.example.ManagementAndBookingHotelApp.Model.User;

public interface IUserService {
    Response register(User user);
    Response login(LoginRequest loginRequest);
    Response getAllUsers();
    Response getUserBookingHistory(String userId);
    Response deleteUser(String userId);
    Response getUserById(String userId);
    Response getMyInfo(String email);
}
