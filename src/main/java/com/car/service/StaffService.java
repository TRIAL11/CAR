package com.car.service;

import com.car.dao.example.Staff;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;

@Service
public interface StaffService {
    Staff getStaffByNo(Integer Sno);
    Map<String,Object> staffisreg(String Saccount,String Spaw);
    List getStaffByAccount(String Saccount);
    void updateStaff(Staff staff);
    List<Staff> getAllStaff();
    void insertStaff(Staff staff);
    void deleteStaffByNo(Integer Sno);
}
