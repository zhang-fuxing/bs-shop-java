package com.zfx.bsshop.dao.space;

import com.zfx.bsshop.vo.CategoryVO;

import java.util.List;
import java.util.Map;

/**
 * @author zfx
 * @date 2022-03-20 13:35
 */
public interface CategoryDetailSpaceDAO {
    List<CategoryVO> selectCategoryDetail(Map map);
}
