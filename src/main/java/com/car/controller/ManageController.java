package com.car.controller;

import com.car.dao.example.Department;
import com.car.dao.example.Staff;
import com.car.service.DepService;
import com.car.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.result.JsonPathResultMatchers;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

@Controller
public class ManageController {
    @Resource
    private StaffService staffService;
    @Resource
    private DepService depService;

    @RequestMapping("/staffTable.do")
    public @ResponseBody
    List<Map> tableStaff()
    {
        List<Staff> list=staffService.getAllStaff();
        List<Map> returnList=new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            Map<String,Object> map=new HashMap<>();
            Staff staff=list.get(i);
            map.put("staff",staff);
            returnList.add(map);
        }
        return returnList;
    }

    @RequestMapping("/EditableStaff.do")
    public @ResponseBody Map<String,Object> EditableStaff(@RequestBody Staff staff)
    {
        Map<String,Object> map=new HashMap<>();
        staffService.updateStaff(staff);
        map.put("errorLog","right");
        return map;
    }

    @RequestMapping("/addStaffTable.do")
    public @ResponseBody Map<String,Object> addStaffTable(@RequestParam Integer Dno,@RequestParam String Sname,@RequestParam String Sphone,@RequestParam String Saccount,@RequestParam String Spaw)
    {
        Staff staff=new Staff();
        staff.setDno(Dno);
        staff.setSname(Sname);
        staff.setSphone(Sphone);
        staff.setSaccount(Saccount);
        staff.setSpaw(Spaw);

        staffService.insertStaff(staff);
        staffService.updateStaff(staff);
        Map<String,Object> map=new HashMap<>();
        map.put("errorLog","right");
        return map;
    }

    @RequestMapping("/deleteStaffTable.do")
    public @ResponseBody Map<String,Object> deleteTable(@RequestBody Staff[] staff)
    {
        Map<String,Object> map=new HashMap<>();
        for(Staff staff1:staff)
        {
            staffService.deleteStaffByNo(staff1.getSno());
        }
        map.put("errorLog","right");
        return map;
    }
}
