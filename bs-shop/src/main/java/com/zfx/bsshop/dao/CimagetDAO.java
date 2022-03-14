package com.zfx.bsshop.dao;

import com.zfx.bsshop.model.Cimage;
import com.zfx.bsshop.model.CimageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CimagetDAO {
    long countByExample(CimageExample example);

    int deleteByExample(CimageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cimage record);

    int insertSelective(Cimage record);

    List<Cimage> selectByExample(CimageExample example);

    Cimage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cimage record, @Param("example") CimageExample example);

    int updateByExample(@Param("record") Cimage record, @Param("example") CimageExample example);

    int updateByPrimaryKeySelective(Cimage record);

    int updateByPrimaryKey(Cimage record);
}