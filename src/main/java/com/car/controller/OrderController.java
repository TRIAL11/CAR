package com.car.controller;

import com.car.dao.example.Rent;
import com.car.dao.example.User;
import com.car.service.CarService;
import com.car.service.OrderService;
import com.car.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {
    @Resource
    private UserService userService;

    @Resource
    private CarService carService;

    @Resource
    private OrderService orderService;


    @RequestMapping(path="/userOrderList")
    public ModelAndView userOrderList(HttpSession session)
    {
        User user=(User)session.getAttribute("user");
        ModelAndView modelAndView=new ModelAndView();
        List<Rent> list=orderService.getAllRentsByUcode(user.getUcode());
        modelAndView.addObject("orderList",list);
        modelAndView.setViewName("UserOrderList");
        return modelAndView;
    }
}
