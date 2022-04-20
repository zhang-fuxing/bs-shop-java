package com.z.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.z.model.Category;
import com.z.model.CtgDetail;
import com.z.vo.CategoryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author z
 * @since 2022-04-19
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
    List<CategoryVO> selectLv2List();
}
