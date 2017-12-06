package com.car.dao;

import com.car.dao.example.Cartype;
import com.car.dao.example.CartypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CartypeMapper {
    int countByExample(CartypeExample example);

    int deleteByExample(CartypeExample example);

    int deleteByPrimaryKey(Integer tno);

    int insert(Cartype record);

    int insertSelective(Cartype record);

    List<Cartype> selectByExample(CartypeExample example);

    Cartype selectByPrimaryKey(Integer tno);

    int updateByExampleSelective(@Param("record") Cartype record, @Param("example") CartypeExample example);

    int updateByExample(@Param("record") Cartype record, @Param("example") CartypeExample example);

    int updateByPrimaryKeySelective(Cartype record);

    int updateByPrimaryKey(Cartype record);
}