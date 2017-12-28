package com.car.controller;

import com.car.dao.example.Car;
import com.car.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RentMainPageController {
    @Resource
    private CarService carService;

    @RequestMapping(path="/oneCar/{cno}")
    public String singleCar(@PathVariable Integer cno, HttpServletRequest request)
    {
        Car car=carService.getCarByNo(cno);
        request.setAttribute("car",car);
        return "OneCar";
    }


}
