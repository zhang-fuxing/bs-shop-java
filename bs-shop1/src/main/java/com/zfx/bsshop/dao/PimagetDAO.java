package com.zfx.bsshop.dao;

import com.zfx.bsshop.model.Pimage;
import com.zfx.bsshop.model.PimageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PimagetDAO {
    long countByExample(PimageExample example);

    int deleteByExample(PimageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Pimage record);

    int insertSelective(Pimage record);

    List<Pimage> selectByExample(PimageExample example);

    Pimage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Pimage record, @Param("example") PimageExample example);

    int updateByExample(@Param("record") Pimage record, @Param("example") PimageExample example);

    int updateByPrimaryKeySelective(Pimage record);

    int updateByPrimaryKey(Pimage record);
}