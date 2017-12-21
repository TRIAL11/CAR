package com.car.service;

import com.car.dao.example.User;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

@Service
public interface UserService {
    User getCarUserByCode(Integer Ucode);
    Map<String,Object> isreg(String Uaccount,String Upassword);
    List getCarUserByAccount(String Uaccount);
    void insertUser(User caruser);
    List getCarUserByEmail(String Uemail);
    List getCarUserByName(String Uname);
    List getCarUserById(String Uid);
    List getCarUserByTel(String Uphone);
    void updateUserEmail(String Uemail,Integer Ucode);
    void updateUserInfo(User caruser);
    void updateUser(User caruser);
    boolean JudgeUserPass(User caruser,String Upassword);
    void updateUserPassword(Integer Ucode,String Upassword);
    void updateUserBalance(Integer Ucode,Float Ubalance);
    void updateUserBalanceReturn(Integer Ucode,Float Ubalance);
}
