package com.car.service;

import com.car.dao.example.Car;
import com.car.dao.example.CarExample;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    List<Car> getAllCar();
    Car getCarByNo(Integer Cno);
    void insertCar(Car car);
    void deleteCarByNo(Integer Cno);
    void updateCar(Car car);

    boolean searchCar(String Cname, CarExample.Criteria criteria);
    //CarExample statusCar(CarExample carExample,Integer... status);
    //boolean statusCar(CarExample.Criteria criteria,List<Integer> list);
    CarExample orderCar(String field, String method,CarExample carExample);

    PageInfo<Car> pageCar(Integer pageNumber,Integer pageSize,List<Car> list);
    PageInfo<Car> getPageCar(Integer pageNumber,Integer pageSize);

    PageInfo<Car> getPageCar(Integer pageNumber,Integer pageSize,String sortName,String sortOrder);
    PageInfo<Car> getPageCar(Integer pageNumber,Integer pageSize,String sortName,String sortOrder,String searchText );

    List<Car> getCarTable();

}
