package com.car.service.impl;

import com.car.dao.RentMapper;
import com.car.dao.example.Car;
import com.car.dao.example.Rent;
import com.car.dao.example.RentExample;
import com.car.dao.example.User;
import com.car.service.OrderService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class OrderServiceImpl implements OrderService{
    @Resource
    private RentMapper rentMapper;

    public Rent setRentReturn(User user,Car car,Date userReturn,Float userPrice)
    {
        Rent rent=new Rent();
        rent.setUcode(user.getUcode());
        rent.setCno(car.getCno());
        rent.setRreturn(userReturn);
        rent.setRprice(userPrice);
        rent.setRstate(1);
        return rent;
    }

    public Rent setRent(User user, Car car, Date userLend)
    {
        Rent rent=new Rent();
        rent.setCno(car.getCno());
        rent.setUcode(user.getUcode());
        rent.setRlend(userLend);
        return rent;
    }

    public void insertRent(Rent rent)
    {
        rentMapper.insertSelective(rent);
    }

    public void updateRent(Rent rent)
    {
        rentMapper.updateByPrimaryKeySelective(rent);
    }

    public Rent getRentByNo(Integer rno)
    {
        Rent rent=rentMapper.selectByPrimaryKey(rno);
        return rent;
    }

    public List<Rent> getAllRents(Integer rno)
    {
        RentExample rentExample=new RentExample();
        List<Rent> list=rentMapper.selectByExample(rentExample);
        return list;
    }

    public List<Rent> getAllRentsByUcode(Integer ucode)
    {
        RentExample rentExample=new RentExample();
        RentExample.Criteria criteria=rentExample.createCriteria();
        rentExample.setOrderByClause("rlend desc");
        criteria.andUcodeEqualTo(ucode);
        return rentMapper.selectByExample(rentExample);
    }
}
