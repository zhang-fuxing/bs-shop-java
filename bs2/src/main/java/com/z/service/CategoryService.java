package com.z.service;

import com.z.model.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.z.vo.CategoryVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author z
 * @since 2022-04-19
 */
public interface CategoryService extends IService<Category> {
    List<CategoryVO> getLv2List();
}
