package com.car.service;

import com.car.dao.example.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    List<Car> getAllCar();
    Car getCarByNo(Integer Cno);
    void insertCar(Car car);
    void deleteCarByNo(Integer Cno);
    void updateCar(Car car);
}
