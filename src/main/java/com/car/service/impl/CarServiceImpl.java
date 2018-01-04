package com.car.service.impl;

import com.car.dao.CarMapper;
import com.car.dao.example.Car;
import com.car.dao.example.CarExample;
import com.car.service.CarService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Override
    public void updateCar(Car car)
    {
        carMapper.updateByPrimaryKeySelective(car);
    }

    @Override
    public boolean searchCar(String Cname, CarExample.Criteria criteria) {
        criteria.andCnameLike("%" + Cname + "%");
        return true;
    }

    @Override
    public PageInfo<Car> pageCar(Integer pageNumber, Integer pageSize, List<Car> list)
    {
        if(list==null)
        {
            return null;
        }
        else
        {
            return new PageInfo<>(list);
        }
    }

    @Override
    public PageInfo<Car> getPageCar(Integer pageNumber,Integer pageSize)
    {
        PageHelper.startPage(pageNumber,pageSize);
        List<Car> list=getAllCar();
        return pageCar(pageNumber,pageSize,list);
    }

    @Override
    public List<Car> getCarTable()
    {
        List<Integer> list=new ArrayList<>();
        list.add(0);
        list.add(1);
        CarExample carExample=new CarExample();
        CarExample.Criteria criteria=carExample.createCriteria();
        criteria.andCstateIn(list);
        return carMapper.selectByExample(carExample);
    }


    @Override
    public CarExample orderCar(String field, String method,CarExample carExample)
    {
        carExample.setOrderByClause(field + " " +method);
        return carExample;
    }

    @Override
    public PageInfo<Car> getPageCar(Integer pageNumber,Integer pageSize,String sortName,String sortOrder)
    {
        PageHelper.startPage(pageNumber,pageSize);
        CarExample carExample=new CarExample();
        carExample=orderCar(sortName,sortOrder,carExample);
        List<Car> list=carMapper.selectByExample(carExample);
        return pageCar(pageNumber,pageSize,list);
    }

    @Override
    public PageInfo<Car> getPageCar(Integer pageNumber, Integer pageSize, String sortName, String sortOrder, String searchText)
    {
        PageHelper.startPage(pageNumber,pageSize);
        CarExample carExample = new CarExample();
        CarExample.Criteria criteria = carExample.createCriteria();
        searchCar(searchText, criteria);
        carExample = orderCar(sortName, sortOrder, carExample);
        List<Car> list = carMapper.selectByExample(carExample);
        return pageCar(pageNumber, pageSize, list);
    }

}
