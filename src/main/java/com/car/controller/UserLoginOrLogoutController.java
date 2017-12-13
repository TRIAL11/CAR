package com.car.controller;

import com.car.dao.example.User;
import com.car.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserLoginOrLogoutController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/login.do")
    public @ResponseBody Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> map = new HashMap<>();
        String Uaccount = request.getParameter("Uaccount");
        String Upassword = request.getParameter("Upassword");
        HttpSession httpSession = request.getSession();
        Map<String, Object> statusMap = userService.isreg(Uaccount, Upassword);
        if (statusMap.get("status").equals("right")) {
            map.put("meg", "ok");
            User user = (User)userService.getCarUserByAccount(Uaccount).get(0);
            httpSession.setAttribute("user", user);
        } else if (statusMap.get("status").equals("null")) {
            map.put("meg", "null");
        } else if (statusMap.get("status").equals("passError")) {
            map.put("meg", "passError");
        }
        return map;
    }

    @RequestMapping("/logout.do")
    public String logout(HttpSession httpSession)
    {
        httpSession.removeAttribute("user");
        return "redirect:home";
    }

    @RequestMapping("/register.do")
    public @ResponseBody Map<String,Object> register (HttpServletRequest request,HttpServletResponse response)throws IOException
    {
        Map<String,Object> map=new HashMap<>();
        User caruser=new User();
        String Uaccount=request.getParameter("Uaccount");
        String Upassword=request.getParameter("Upassword");
        String Uname=request.getParameter("Uname");
        String Uphone=request.getParameter("Uphone");
        String Uid=request.getParameter("Uid");
        String Uemail=request.getParameter("Uemail");
        caruser.setUaccount(Uaccount);
        caruser.setUpassword(Upassword);
        caruser.setUname(Uname);
        caruser.setUphone(Uphone);
        caruser.setUid(Uid);
        caruser.setUemail(Uemail);

        List<User> user1=userService.getCarUserByAccount(Uaccount);

        if(user1.size()!=0)
        {
            map.put("meg","null");
        }
        else
        {
            user1=userService.getCarUserByEmail(Uemail);
            if(user1.size()!=0)
            {
                map.put("meg","emailError");
            }
            else
            {
                map.put("meg","right");
                userService.insertUser(caruser);
            }
        }
        return map;
    }

    @RequestMapping("/register.in")
    public String registerIn(HttpServletRequest request,HttpSession httpSession)
    {
        String Uaccount=request.getParameter("Uaccount");
        User caruser=(User)userService.getCarUserByAccount(Uaccount).get(0);
        httpSession.setAttribute("user",caruser);
        return "MainPage";
    }

    @RequestMapping("/register.Uaccount")
    public @ResponseBody Map<String,Object> registerUaccount(@RequestParam String Uaccount)
    {
        Map<String,Object> map=new HashMap();
        List list=userService.getCarUserByAccount(Uaccount);
        if(list.size()==0)
        {
            map.put("message","right");
        }
        else
        {
            map.put("message","error");
        }
        return map;
    }

    @RequestMapping("/register.Uemail")
    public @ResponseBody Map<String,Object> registerUemail(@RequestParam String Uemail) {
        Map<String, Object> map = new HashMap<>();
        List list = userService.getCarUserByEmail(Uemail);
        if (list.size() == 0) {
            map.put("message", "right");
        } else
        {
            map.put("message","error");
        }
        return map;
    }

    @RequestMapping("/changePass.judge")
    public @ResponseBody Map<String,Object> changePassjudge(HttpSession session,@RequestParam String Upassword)
    {
        Map<String,Object> map=new HashMap<>();
        User caruser=(User)session.getAttribute("user");
        if(userService.JudgeUserPass(caruser,Upassword))
        {
            map.put("message","right");
        }
        else
        {
            map.put("message","error");
        }
        return map;
    }

    @RequestMapping("/changePass.do")
    public @ResponseBody Map<String,Object> changepassdo(@RequestParam String Upassword,HttpSession session)
    {
        Map<String,Object> map=new HashMap<>();
        User caruser=(User)session.getAttribute("user");
        userService.updateUserPassword(caruser.getUcode(),Upassword);
        User caruser1=userService.getCarUserByCode(caruser.getUcode());
        session.setAttribute("user",caruser1);
        map.put("message","success");
        return map;
    }

    @RequestMapping("/rechargeBalance.do")
    public @ResponseBody Map<String ,Object> rechargebalance(@RequestParam Float Ubalance,HttpSession session)
    {
        Map<String,Object> map=new HashMap<>();
        User caruser=(User)session.getAttribute("user");
        userService.updateUserBalance(caruser.getUcode(),Ubalance);
        User caruser1=userService.getCarUserByCode(caruser.getUcode());
        session.setAttribute("user",caruser1);
        map.put("message","success");
        return map;
    }

}
