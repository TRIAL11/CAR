package com.car.service;

import com.car.dao.example.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepService {
    Department getDepByNo(Integer dNo);
    List<Department> getAllDep();
}
