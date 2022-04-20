package com.zfx.bsshop.service;

import com.zfx.bsshop.model.Category;
import com.zfx.bsshop.vo.CategoryVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zfx
 * @since 2022-03-12
 */
public interface CategoryService {
    List<Category> getAllLevel1();
    List<CategoryVO> getAllLevel2();
    List<CategoryVO> getLevelById(int id);
}
