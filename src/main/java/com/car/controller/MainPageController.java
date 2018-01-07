package com.car.controller;

import com.car.dao.example.Car;
import com.car.dao.example.Staff;
import com.car.service.CarService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

@Controller
public class MainPageController {

    @Autowired
    private CarService carService;

    @RequestMapping("/home")
    public ModelAndView findUser() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("MainPage");
        return modelAndView;
    }

    @RequestMapping("/userInfo")
    public ModelAndView UserIf() throws Exception
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("UserInfo");
        return modelAndView;
    }

    @RequestMapping("/rentMainPage")
    public ModelAndView RentMainPage(ModelAndView modelAndView)
    {
        List<Car> list1=carService.getAllCar();
        modelAndView.addObject("cars",list1);
        modelAndView.setViewName("RentMainPage");
        return modelAndView;
    }

    @RequestMapping("/staffMainPage")
    public ModelAndView StaffMainPage() throws Exception
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("StaffMainPage");
        return modelAndView;
    }
    @RequestMapping("/rechargeCenter")
    public ModelAndView RechargeCenter() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("RechargeCenter");
        return modelAndView;
    }
    @RequestMapping("/manageCar")
    public ModelAndView ManageCar() throws Exception
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("ManageCar");
        return modelAndView;
    }
    @RequestMapping("/manageStaff")
    public ModelAndView ManageStaff() throws Exception
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("ManageStaff");
        return modelAndView;
    }
    @RequestMapping("/text")
    public ModelAndView text() throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("vueText");
        return modelAndView;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(HttpSession session, MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Staff staff=(Staff) session.getAttribute("staff");
        Car car=new Car();
        String carName=request.getParameter("carName");
        String carLong=request.getParameter("carLong");
        Float carPrice=Float.valueOf(request.getParameter("carPrice"));
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        String substring = fileName.substring(fileName.lastIndexOf("."));
        String replace = UUID.randomUUID().toString().replace("-", "");
        String newFileName=replace+substring;
        File dir = new File(path, newFileName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        //MultipartFile自带的解析方法
        file.transferTo(dir);
        String newAdd=path +"/" +newFileName;
        car.setCname(carName);
        car.setSno(staff.getSno());
        car.setTno(1);
        car.setCprice(carPrice);
        car.setClong(carLong);
        car.setCpicture(newAdd);
        carService.insertCar(car);
        return newAdd;
    }

}
