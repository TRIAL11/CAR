package com.car.service.impl;


import com.car.dao.StaffMapper;
import com.car.service.StaffService;
import com.car.dao.example.Staff;
import com.car.dao.example.StaffExample;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StaffServiceImpl implements StaffService{
    @Resource
    private StaffMapper staffMapper;


    public Staff getStaffByNo(Integer Sno) {
        Staff staff=staffMapper.selectByPrimaryKey(Sno);
        return staff;
    }

    public Map<String,Object> staffisreg(String Saccount,String Spaw)
    {
        Map<String,Object> map=new HashMap<>();
        StaffExample staffExample=new StaffExample();
        StaffExample.Criteria criteria=staffExample.createCriteria();
        criteria.andSaccountEqualTo(Saccount);
        List<Staff> stafflist=staffMapper.selectByExample(staffExample);
        if(stafflist.size()==0)
        {
            map.put("status","null");
        }
        else if(!stafflist.get(0).getSpaw().equals(Spaw))
        {
            map.put("status","passerror");
        }
        else
        {
            map.put("status","right");
        }
        return map;
    }

    public List getStaffByAccount(String Saccount)
    {
        StaffExample staffExample=new StaffExample();
        StaffExample.Criteria criteria=staffExample.createCriteria();
        criteria.andSaccountEqualTo(Saccount);
        List<Staff> list=staffMapper.selectByExample(staffExample);
        return list;
    }

    public void updateStaff(Staff staff)
    {
        staffMapper.updateByPrimaryKeySelective(staff);
    }

    public List<Staff> getAllStaff()
    {
        StaffExample staffExample=new StaffExample();
        List<Staff> list=staffMapper.selectByExample(staffExample);
        return list;
    }

    public void insertStaff(Staff staff)
    {
        staffMapper.insertSelective(staff);
    }

    public void deleteStaffByNo(Integer Sno)
    {
        staffMapper.deleteByPrimaryKey(Sno);
    }
}
