package com.car.controller;

import com.car.dao.example.Car;
import com.car.dao.example.Rent;
import com.car.dao.example.User;
import com.car.service.CarService;
import com.car.service.OrderService;
import com.car.service.UserService;
import com.sun.javafx.collections.MappingChange;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {
    @Resource
    private UserService userService;

    @Resource
    private CarService carService;

    @Resource
    private OrderService orderService;


    @RequestMapping("/rentSuccess")
    public ModelAndView successRent() throws Exception
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("RentSuccess");
        return modelAndView;
    }

    @RequestMapping(path="/userOrderList")
    public ModelAndView userOrderList(HttpSession session)
    {
        User user=(User)session.getAttribute("user");
        ModelAndView modelAndView=new ModelAndView();
        List<Rent> list1=orderService.getAllRentsByUcodeReturn(user.getUcode());
        List<Rent> list=orderService.getAllRentsByUcode(user.getUcode());
        modelAndView.addObject("orderList1",list1);
        modelAndView.addObject("orderList",list);
        modelAndView.setViewName("UserOrderList");
        return modelAndView;
    }

    @RequestMapping(path="addOrderList/{ucode} +{cno}")
    public String addOrderList(@PathVariable Integer ucode,@PathVariable Integer cno)
    {
        User user=userService.getCarUserByCode(ucode);
        Car car=carService.getCarByNo(cno);
        Rent orderList=orderService.setRent(user,car);
        orderService.insertRent(orderList);
        car.setCstate(1);
        carService.updateCar(car);
        return "redirect:/rentSuccess";
    }

    @RequestMapping(path="returnOrderList/{rno}")
    public String returnOrderList(@PathVariable Integer rno)
    {
        Rent orderList=orderService.getRentByNo(rno);
        Car car=carService.getCarByNo(orderList.getCno());
        Rent orderList1=orderService.setRentReturn(orderList);
        orderService.updateRent(orderList1);
        car.setCstate(0);
        carService.updateCar(car);
        return "redirect:/pay/"+ orderList1.getRno();
    }

    @RequestMapping(path="/pay/{rno}")
    public ModelAndView payMoney(@PathVariable Integer rno)
    {
        ModelAndView modelAndView=new ModelAndView();
        Rent rent=orderService.getRentByNo(rno);
        modelAndView.addObject("onePay",rent);
        modelAndView.setViewName("PayMainPage");
        return modelAndView;
    }
}
