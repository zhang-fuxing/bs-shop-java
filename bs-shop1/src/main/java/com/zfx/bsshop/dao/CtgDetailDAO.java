package com.zfx.bsshop.dao;

import com.zfx.bsshop.model.CtgDetail;
import com.zfx.bsshop.model.CtgDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CtgDetailDAO {
    long countByExample(CtgDetailExample example);

    int deleteByExample(CtgDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CtgDetail record);

    int insertSelective(CtgDetail record);

    List<CtgDetail> selectByExample(CtgDetailExample example);

    CtgDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CtgDetail record, @Param("example") CtgDetailExample example);

    int updateByExample(@Param("record") CtgDetail record, @Param("example") CtgDetailExample example);

    int updateByPrimaryKeySelective(CtgDetail record);

    int updateByPrimaryKey(CtgDetail record);
}