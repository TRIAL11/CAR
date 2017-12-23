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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        List<Rent> list=orderService.getAllRentsByUcode(user.getUcode());
        modelAndView.addObject("order",list);
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

    @RequestMapping("/returnTime.do")
    public @ResponseBody Map<String,Object> returnTime(@RequestParam Integer rno,@RequestParam String sPrice)
    {
        Map<String,Object> map=new HashMap<>();
        Rent rent=orderService.getRentByNo(rno);
        User user=userService.getCarUserByCode(rent.getUcode());
        Float returnPrice=Float.valueOf(sPrice);
        if(returnPrice>user.getUbalance())
        {
            rent.setRreturn(new Date());
            orderService.updateRent(rent);
            map.put("message","error");
        }
        else
        {
            rent.setRreturn(new Date());
            orderService.updateRent(rent);
            map.put("message","ok");
        }
        return map;
    }

    @RequestMapping(path="returnCar")
    public String returnOrderList(HttpServletRequest request,HttpServletResponse response,HttpSession session)
    {
        Integer rno=Integer.parseInt(request.getParameter("orderListId"));
        Rent orderList=orderService.getRentByNo(rno);
        Car car=carService.getCarByNo(orderList.getCno());
        User user=userService.getCarUserByCode(orderList.getUcode());
        Float payMoney=Float.valueOf(request.getParameter("userPayMoney"));
        orderList.setRprice(payMoney);
        orderList.setRstate(1);
        orderService.updateRent(orderList);
        car.setCstate(0);
        carService.updateCar(car);
        user.setUbalance(user.getUbalance()-payMoney);
        userService.updateUser(user);
        User user1=userService.getCarUserByCode(user.getUcode());
        session.setAttribute("user",user1);
        return "redirect:/userOrderList";
    }

    @RequestMapping("/getMappingOrder.do")
    public @ResponseBody Rent getMappingOrder(@RequestParam Integer rno)
    {
        Rent rent=orderService.getRentByNo(rno);
        return rent;
    }
}
