package com.car.controller;

import com.car.dao.example.*;
import com.car.service.*;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;

@Controller
public class ManageController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private DepService depService;
    @Autowired
    private CarService carService;
    @Autowired
    private UserService userService;
    @Autowired
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

    @RequestMapping(path="/Admin/{cno}")
    public String adminCar(@PathVariable Integer cno, HttpServletRequest request)
    {
        Car car=carService.getCarByNo(cno);
        Staff staff=staffService.getStaffByNo(car.getSno());
        Cartype cartype=carTypeService.getCarTypeByTno(car.getTno());
        request.setAttribute("staff",staff);
        request.setAttribute("cartype",cartype);
        request.setAttribute("car",car);
        return "EditCar";
    }

    @RequestMapping("/getAllCarType")
    public @ResponseBody Map<String,Object> getAllCattype()
    {
        Map<String,Object> map=new HashMap<>();
        List<Cartype> list=carTypeService.getAllCarType();
        map.put("cartype",list);
        return map;
    }

    @RequestMapping("/addNewCar.do")
    public String addNewCar(HttpSession session)
    {
        return "manageCar";
    }


    @RequestMapping("/PageCarTable")
    public @ResponseBody Map<String,Object> pageCarTable(Integer pageNumber,Integer pageSize, String sortName, String sortOrder, String searchText)
    {
        Map<String,Object> map=new HashMap<>();
        List<Map> list=new ArrayList<>();
        PageInfo<Car> pageInfo=null;
        if(sortName!=null)
        {
            String[] sortObject = sortName.split("\\.");
            if(sortObject[0].equals("cartype")&&sortObject[1].equals("tname"))
            {
                sortObject[1]="tno";
            }
            else if(sortObject[0].equals("staff")&&sortObject[1].equals("sname"))
            {
                sortObject[1]="sno";
            }

            if(searchText==null||searchText.equals(""))
            {
                pageInfo=carService.getPageCar(pageNumber,pageSize,sortObject[1],sortOrder);
            }
            else
            {
                pageInfo=carService.getPageCar(pageNumber,pageSize,sortObject[1],sortOrder,searchText);
            }
        }
        else
        {
            if(searchText==null||searchText.equals(""))
            {
                pageInfo=carService.getPageCar(pageNumber,pageSize,"cno","asc");
            }
            else
            {
                pageInfo=carService.getPageCar(pageNumber,pageSize,"cno","asc",searchText);
            }
        }
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

    @RequestMapping(path="editCar")
    public String editCarAdmin(HttpServletRequest request, HttpServletResponse response)
    {
        Integer cno=Integer.parseInt(request.getParameter("edit-car-cno"));
        Car car=carService.getCarByNo(cno);
        String name=request.getParameter("edit-car-name");
        String carlong=request.getParameter("edit-car-long");
        Float price=Float.valueOf(request.getParameter("edit-car-price"));
        Integer state=Integer.parseInt(request.getParameter("edit-car-state"));
        car.setCname(name);
        car.setClong(carlong);
        car.setCprice(price);
        car.setCstate(state);
        carService.updateCar(car);
        return "redirect:/manageCar";
    }

    @RequestMapping("/deleteCarByNo.do")
    public @ResponseBody Map<String,Object> deleteCarByNo(@RequestBody Car[] car)
    {
        Map<String,Object> map=new HashMap<>();
        for(Car car1:car)
        {
            carService.deleteCarByNo(car1.getCno());
        }
        map.put("message","right");
        return map;
    }
}
