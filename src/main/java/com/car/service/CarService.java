package com.car.service;

import com.car.dao.example.Car;
import com.car.dao.example.CarExample;
import com.github.pagehelper.Page;
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
    CarExample orderCar(String field, String method,CarExample carExample);
    //基本获取分页
    PageInfo<Car> pageCar(Integer pageNumber,Integer pageSize,List<Car> list);
    PageInfo<Car> getPageCar(Integer pageNumber,Integer pageSize);
    //管理员管理界面分页
    PageInfo<Car> getPageCar(Integer pageNumber,Integer pageSize,String sortName,String sortOrder);
    PageInfo<Car> getPageCar(Integer pageNumber,Integer pageSize,String sortName,String sortOrder,String searchText );
    //用户根据价格搜索分页
    PageInfo<Car> getPageCarByPrice(Integer pageNum,Integer pageSize,String searchText,Float minPrice,Float maxPrice);
    PageInfo<Car> getPageCarByPrice(Integer pageNum,Integer pageSize,String sortOrder,String searchText,Float minPrice,Float maxPrice);
    List<Car> getCarTable();
    boolean priceMin(Float minPrice,Float maxPrice,CarExample.Criteria criteria);
}
