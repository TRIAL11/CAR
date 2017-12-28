package com.car.controller;

import com.car.dao.example.Car;
import com.car.service.CarService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

}
