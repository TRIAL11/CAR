package com.car.controller;

import com.car.dao.example.User;
import com.car.service.UserService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserInfoController {
    @Resource
    private UserService userService;

    @RequestMapping("/UserInfo")
    public String userinfo(HttpSession httpSession)
    {
        User caruser=(User)httpSession.getAttribute("user");
        if(caruser==null)
        {
            return "redirect:home";
        }
        else
        {
            return "UserInfo";
        }
    }

    @RequestMapping("/UpEmail.do")
    public @ResponseBody
    Map<String,Object> upemail(@RequestParam String Uemail,HttpSession httpSession)
    {
        Map<String,Object> map=new HashMap<>();
        List list=userService.getCarUserByEmail(Uemail);
        User caruser=(User)httpSession.getAttribute("user");
        User caruser1=null;
        if(list.size()!=0)
        {
            caruser1=(User)list.get(0);
        }
        if(list.size()==0||(list.size()==1&&caruser.getUcode().equals(caruser1.getUcode())))
        {
            map.put("message","success");
        }
        else
        {
            map.put("message","error");
        }
        return map;
    }

    //改用path 前台提交表单
    @RequestMapping(path="upUserInfo")
    public String uoUserInfo(HttpServletRequest request, HttpServletResponse response,HttpSession session)
    {
        Integer ucode=Integer.parseInt(request.getParameter("Ucode"));
        User caruser=userService.getCarUserByCode(ucode);
        String Uname=request.getParameter("Uname");
        String Uphone=request.getParameter("Uphone");
        String Uid=request.getParameter("Uid");
        String Uemail=request.getParameter("Uemail");
        caruser.setUname(Uname);
        caruser.setUphone(Uphone);
        caruser.setUid(Uid);
        caruser.setUemail(Uemail);
        userService.updateUserInfo(caruser);
        User caruser2=userService.getCarUserByCode(caruser.getUcode());
        session.setAttribute("user",caruser2);
        return "redirect:/UserInfo";
    }
}
