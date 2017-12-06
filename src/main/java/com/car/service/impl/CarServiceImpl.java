package com.car.service.impl;


import com.car.dao.CarMapper;
import com.car.dao.example.Car;
import com.car.dao.example.CarExample;
import com.car.service.CarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CarServiceImpl implements CarService{
    @Resource
    private CarMapper carMapper;

    public List<Car> getAllCar()
    {
        CarExample carExample=new CarExample();
        List<Car> list=carMapper.selectByExample(carExample);
        return list;
    }

    public Car getCarByNo(Integer Cno)
    {
        Car car=carMapper.selectByPrimaryKey(Cno);
        return car;
    }

    public void insertCar(Car car)
    {
        carMapper.insertSelective(car);
    }
    public void deleteCarByNo(Integer Cno)
    {
        carMapper.deleteByPrimaryKey(Cno);
    }

    public void updateCar(Car car)
    {
        carMapper.updateByPrimaryKeySelective(car);
    }
}
