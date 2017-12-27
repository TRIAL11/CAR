package com.car.controller;

import com.car.dao.example.*;
import com.car.service.*;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.result.JsonPathResultMatchers;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.*;

@Controller
public class ManageController {
    @Resource
    private StaffService staffService;
    @Resource
    private DepService depService;
    @Resource
    private CarService carService;
    @Resource
    private UserService userService;
    @Resource
    private CarTypeService carTypeService;

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

    @RequestMapping("/addNewCar")
    public ModelAndView addNewCar() throws Exception
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("AddNewCar");
        return modelAndView;
    }

    @RequestMapping("/PageCarTable")
    public @ResponseBody Map<String,Object> pageCarTable(Integer pageNumber,Integer pageSize)
    {
        Map<String,Object> map=new HashMap<>();
        List<Map> list=new ArrayList<>();
        PageInfo<Car> pageInfo=null;
        pageInfo=carService.getPageCar(pageNumber,pageSize);
        List<Car> carList=pageInfo.getList();
        for(int i=0;i<carList.size();i++)
        {
            Car car=carList.get(i);
            Map<String,Object> map1=new HashMap<>();
            Staff staff=staffService.getStaffByNo(car.getSno());
            Cartype cartype=carTypeService.getCarTypeByTno(car.getTno());
            map1.put("car",car);
            map1.put("staff",staff);
            map1.put("cartype",cartype);
            list.add(map1);
        }
        map.put("total",pageInfo.getTotal());
        map.put("rows",list);
        return map;
    }

    @RequestMapping("/getCarTable")
    public @ResponseBody List<Map> getCarTable()
    {
        List<Map> list=new ArrayList<>();
        List<Car> carList=carService.getCarTable();
        for(Car car:carList)
        {
            Map<String,Object> map=new HashMap<>();
            Cartype cartype=carTypeService.getCarTypeByTno(car.getTno());
            Staff staff=staffService.getStaffByNo(car.getSno());
            map.put("car",car);
            map.put("cartype",cartype);
            map.put("staff",staff);
            list.add(map);
        }
        return list;
    }

}
