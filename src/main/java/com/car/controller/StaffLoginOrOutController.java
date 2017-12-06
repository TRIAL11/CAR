package com.car.controller;

import com.car.dao.example.Staff;
import com.car.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class StaffLoginOrOutController {
    @Resource
    private StaffService staffService;

    @RequestMapping("/staffLogin.do")
    public @ResponseBody
    Map<String,Object> stafflogin(HttpServletRequest request, HttpServletResponse response)throws IOException
    {
        Map<String,Object> map=new HashMap<>();
        String Saccount=request.getParameter("Saccount");
        String Spaw=request.getParameter("Spaw");
        HttpSession httpSession=request.getSession();
        Map<String,Object> staMap=staffService.staffisreg(Saccount,Spaw);
        if(staMap.get("status").equals("right"))
        {
            map.put("meg","ok");
            Staff staff=(Staff)staffService.getStaffByAccount(Saccount).get(0);
            httpSession.setAttribute("staff",staff);
        }
        else if(staMap.get("status").equals("null"))
        {
            map.put("meg","null");
        }
        else if(staMap.get("status").equals("passerror"))
        {
            map.put("meg","passerror");
        }
        return map;
    }

    @RequestMapping("/staffOut.do")
    public String staffOut(HttpSession httpSession)
    {
        httpSession.removeAttribute("staff");
        return "redirect:staffMainPage";
    }
}
