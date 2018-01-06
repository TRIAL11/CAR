package com.car.controller;

import com.car.dao.example.Car;
import com.car.service.CarService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/searchCar/{searchText}")
    public ModelAndView searchCar(@PathVariable String searchText,ModelAndView modelAndView)
    {
        modelAndView.addObject("searchText",searchText);
        modelAndView.setViewName("searchTry");
        return modelAndView;
    }

    @RequestMapping("/Search/PageCar")
    public @ResponseBody
    Map<String,Object> PageCarBy(String searchText,Integer pageNum,Integer pageSize,String pageOrder,Float minPrice,Float maxPrice)
    {
        Map<String,Object> map=new HashMap<>();
        PageInfo<Car> pageInfo=null;
        if(pageOrder==null||pageOrder.equals(""))
        {
            pageInfo=carService.getPageCarByPrice(pageNum,pageSize,searchText,minPrice,maxPrice);
        }
        else
        {
            pageInfo=carService.getPageCarByPrice(pageNum,pageSize,pageOrder,searchText,minPrice,maxPrice);
        }
        List<Car> list=pageInfo.getList();
        map.put("total",pageInfo.getTotal());
        map.put("car",list);
        return map;
    }

}
