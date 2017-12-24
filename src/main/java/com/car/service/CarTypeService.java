package com.car.service;

import com.car.dao.example.Cartype;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarTypeService {
    List<Cartype> getAllCarType();
    Cartype getCarTypeByTno(Integer Tno);
}
