package com.example.ManagementAndBookingHotelApp.Utils;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

import com.example.ManagementAndBookingHotelApp.DTO.BookingDTO;
import com.example.ManagementAndBookingHotelApp.DTO.RoomDTO;
import com.example.ManagementAndBookingHotelApp.DTO.UserDTO;
import com.example.ManagementAndBookingHotelApp.Model.Booking;
import com.example.ManagementAndBookingHotelApp.Model.Room;
import com.example.ManagementAndBookingHotelApp.Model.User;

public class Utils {
    private static final String ALPHARNUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom secureRandom = new SecureRandom();

    public static String generateRandomConfirmationCode(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i < length; i++) {
            int randomIndex = secureRandom.nextInt(ALPHARNUMERIC_STRING.length());
            char randomChar = ALPHARNUMERIC_STRING.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }

    public static UserDTO mapUserEntityToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setRole(user.getRole());
        return userDTO;
    }

    public static RoomDTO mapRoomEntityToRoomDTO(Room room) {
        RoomDTO roomDTO = new RoomDTO();

        roomDTO.setId(room.getId());
        roomDTO.setRoomType(room.getRoomType());
        roomDTO.setRoomPrice(room.getRoomPrice());
        roomDTO.setRoomImageUrl(room.getRoomImageUrl());
        roomDTO.setRoomDescription(room.getRoomDescription());
        return roomDTO;
    }

    public static BookingDTO mapBookingEntityToBookingDTO(Booking booking) {
        BookingDTO bookingDTO = new BookingDTO();

        bookingDTO.setId(booking.getId());
        bookingDTO.setCheckInDate(booking.getCheckInDate());
        bookingDTO.setCheckOutDate(booking.getCheckOutDate());
        bookingDTO.setNumOfAdults(booking.getNumOfAdults());
        bookingDTO.setNumOfChildrens(booking.getNumOfChildrens());
        bookingDTO.setTotalNumOfGuest(booking.getTotalNumOfGuest());
        bookingDTO.setBookingConfirmationCode(booking.getBookingConfirmationCode());
        return bookingDTO;
    }

    public static RoomDTO mapRoomEntityToRoomDTOPlusBookings(Room room) {
        RoomDTO roomDTO = new RoomDTO();

        roomDTO.setId(room.getId());
        roomDTO.setRoomType(room.getRoomType());
        roomDTO.setRoomPrice(room.getRoomPrice());
        roomDTO.setRoomImageUrl(room.getRoomImageUrl());
        roomDTO.setRoomDescription(room.getRoomDescription());

        if(room.getBookings() != null) {
            roomDTO.setBookings(room.getBookings()
                                .stream()
                                .map(Utils::mapBookingEntityToBookingDTO)
                                .collect(Collectors.toList())
            );
        }
        return roomDTO;
    }

    public static BookingDTO mapBookingEntityToBookingDTOPlusBookedRooms(Booking booking, boolean mapUser) {
        BookingDTO bookingDTO = new BookingDTO();

        bookingDTO.setId(booking.getId());
        bookingDTO.setCheckInDate(booking.getCheckInDate());
        bookingDTO.setCheckOutDate(booking.getCheckOutDate());
        bookingDTO.setNumOfAdults(booking.getNumOfAdults());
        bookingDTO.setNumOfChildrens(booking.getNumOfChildrens());
        bookingDTO.setTotalNumOfGuest(booking.getTotalNumOfGuest());
        bookingDTO.setBookingConfirmationCode(booking.getBookingConfirmationCode());

        if(mapUser) {
            bookingDTO.setUser(Utils.mapUserEntityToUserDTO(booking.getUser()));
        }

        if(booking.getRoom() != null) {
            RoomDTO roomDTO = new RoomDTO();
            roomDTO.setId(booking.getRoom().getId());
            roomDTO.setRoomType(booking.getRoom().getRoomType());
            roomDTO.setRoomPrice(booking.getRoom().getRoomPrice());
            roomDTO.setRoomImageUrl(booking.getRoom().getRoomImageUrl());
            roomDTO.setRoomDescription(booking.getRoom().getRoomDescription());
            bookingDTO.setRoom(roomDTO);
        }
        return bookingDTO;
    }

    public static UserDTO mapUserEntityToUserDTOPlusUserBookingsAndRoom(User user) {
        UserDTO userDTO = new UserDTO();

        if(!user.getBookings().isEmpty()) {
            userDTO.setBookings(user.getBookings()
                                .stream()
                                .map(booking ->  mapBookingEntityToBookingDTOPlusBookedRooms(booking, false))
                                .collect(Collectors.toList())
            );
        }

        return userDTO;
    }

    public static List<UserDTO> mapUserListEntityToUserListDTO(List<User> userList) {
        return userList.stream()
                        .map(Utils::mapUserEntityToUserDTO)
                        .collect(Collectors.toList());
    }

    public static List<RoomDTO> mapRoomListEntityToRoomListDTO(List<Room> roomList) {
        return roomList.stream()
                        .map(Utils::mapRoomEntityToRoomDTO)
                        .collect(Collectors.toList());
    }

    public static List<BookingDTO> mapBookingListEntityToBookingListDTO(List<Booking> bookinglist) {
        return bookinglist.stream()
                          .map(Utils::mapBookingEntityToBookingDTO)
                          .collect(Collectors.toList());
    }
}
