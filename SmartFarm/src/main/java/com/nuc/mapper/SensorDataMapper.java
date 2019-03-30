package com.nuc.mapper;

import com.nuc.pojo.SensorData;
import com.nuc.pojo.SensorDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SensorDataMapper {
    long countByExample(SensorDataExample example);

    int deleteByExample(SensorDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SensorData record);

    int insertSelective(SensorData record);

    List<SensorData> selectByExample(SensorDataExample example);

    SensorData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SensorData record, @Param("example") SensorDataExample example);

    int updateByExample(@Param("record") SensorData record, @Param("example") SensorDataExample example);

    int updateByPrimaryKeySelective(SensorData record);

    int updateByPrimaryKey(SensorData record);
    
   List<SensorData> selectLatestBySensorId();
}