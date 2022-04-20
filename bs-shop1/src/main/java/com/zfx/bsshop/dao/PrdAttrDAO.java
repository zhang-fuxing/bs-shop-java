package com.zfx.bsshop.dao;

import com.zfx.bsshop.model.PrdAttr;
import com.zfx.bsshop.model.PrdAttrExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrdAttrDAO {
    long countByExample(PrdAttrExample example);

    int deleteByExample(PrdAttrExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PrdAttr record);

    int insertSelective(PrdAttr record);

    List<PrdAttr> selectByExample(PrdAttrExample example);

    PrdAttr selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PrdAttr record, @Param("example") PrdAttrExample example);

    int updateByExample(@Param("record") PrdAttr record, @Param("example") PrdAttrExample example);

    int updateByPrimaryKeySelective(PrdAttr record);

    int updateByPrimaryKey(PrdAttr record);
}