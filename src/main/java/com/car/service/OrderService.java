package com.car.service;

import com.car.dao.example.Car;
import com.car.dao.example.Rent;
import com.car.dao.example.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface OrderService {
    //Rent setRentReturn(Rent rent);
    Rent setRent(User user, Car car);
    void insertRent(Rent rent);
    void updateRent(Rent rent);
    Rent getRentByNo(Integer rno);
    //List<Rent> getAllRents(Integer rno);
    List<Rent> getAllRentsByUcode(Integer ucode);
    List<Rent> getAllRentsByUcodeReturn(Integer ucode);
}
