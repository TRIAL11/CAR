package com.car.service.impl;

import com.car.dao.UserMapper;
import com.car.service.UserService;
import com.car.dao.example.User;
import com.car.dao.example.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    public User getCarUserByCode(Integer Ucode) {
        User caruser = userMapper.selectByPrimaryKey(Ucode);
        return caruser;
    }

    public Map<String, Object> isreg(String Uaccount, String Upassword) {
        Map<String, Object> map = new HashMap<>();
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUaccountEqualTo(Uaccount);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.size() == 0) {
            map.put("status", "null");
        } else if (!userList.get(0).getUpassword().equals(Upassword)) {
            map.put("status", "passError");
        } else {
            map.put("status", "right");
        }
        return map;
    }

    public List getCarUserByAccount(String Uaccount) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUaccountEqualTo(Uaccount);
        List<User> list = userMapper.selectByExample(userExample);
        return list;
    }

    @Override
    public List<User> getCarUserByName(String Uname) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUnameEqualTo(Uname);
        List<User> list = userMapper.selectByExample(userExample);
        return list;
    }

    @Override
    public List<User> getCarUserById(String Uid) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUidEqualTo(Uid);
        List<User> list = userMapper.selectByExample(userExample);
        return list;
    }

    @Override
    public List<User> getCarUserByTel(String Uphone) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUphoneEqualTo(Uphone);
        List<User> list = userMapper.selectByExample(userExample);
        return list;
    }

    @Override
    public List<User> getCarUserByEmail(String Uemail) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUemailEqualTo(Uemail);
        List<User> list = userMapper.selectByExample(userExample);
        return list;
    }

    public void insertUser(User caruser) {
        userMapper.insertSelective(caruser);
    }

    public void updateUserEmail(String Uemail, Integer Ucode) {
        User caruser = new User();
        caruser.setUemail(Uemail);
        caruser.setUcode(Ucode);
        userMapper.updateByPrimaryKeySelective(caruser);
    }

    public void updateUserInfo(User caruser) {
        userMapper.updateByPrimaryKeySelective(caruser);
    }

    public boolean JudgeUserPass(User caruser,String Upassword)
    {
        if(caruser.getUpassword().equals(Upassword))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void updateUserPassword(Integer Ucode,String Upassword)
    {
        User caruser=new User();
        caruser.setUpassword(Upassword);
        caruser.setUcode(Ucode);
        userMapper.updateByPrimaryKeySelective(caruser);
    }

    public void updateUserBalance(Integer Ucode,Float Ubalance)
    {
        User user = userMapper.selectByPrimaryKey(Ucode);
        user.setUbalance(user.getUbalance() + Ubalance);
        userMapper.updateByPrimaryKeySelective(user);
    }

    public void updateUser(User caruser)
    {
        userMapper.updateByPrimaryKeySelective(caruser);
    }


}
