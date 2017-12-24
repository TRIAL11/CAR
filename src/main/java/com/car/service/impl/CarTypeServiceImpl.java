package com.car.service.impl;

import com.car.dao.CartypeMapper;
import com.car.dao.example.Cartype;
import com.car.dao.example.CartypeExample;
import com.car.service.CarTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CarTypeServiceImpl implements CarTypeService{
    @Resource
    CartypeMapper cartypeMapper;

    public List<Cartype> getAllCarType()
    {
        CartypeExample cartypeExample=new CartypeExample();
        List<Cartype> list=cartypeMapper.selectByExample(cartypeExample);
        return list;
    }

    public Cartype getCarTypeByTno(Integer Tno)
    {
        Cartype cartype=cartypeMapper.selectByPrimaryKey(Tno);
        return cartype;
    }
}
