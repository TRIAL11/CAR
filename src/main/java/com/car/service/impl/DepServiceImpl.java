package com.car.service.impl;

import com.car.dao.DepartmentMapper;
import com.car.dao.example.Department;
import com.car.dao.example.DepartmentExample;
import com.car.service.DepService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepServiceImpl implements DepService{
    @Resource
    private DepartmentMapper departmentMapper;

    public Department getDepByNo(Integer dNo)
    {
        Department department=new Department();
        return department;
    }

    public List<Department> getAllDep()
    {
        DepartmentExample departmentExample=new DepartmentExample();
        List<Department> list=departmentMapper.selectByExample(departmentExample);
        return list;
    }

}
