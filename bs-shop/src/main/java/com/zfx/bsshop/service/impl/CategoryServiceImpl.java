package com.zfx.bsshop.service.impl;

import com.zfx.bsshop.dao.CategorytDAO;
import com.zfx.bsshop.model.Category;
import com.zfx.bsshop.model.CategoryExample;
import com.zfx.bsshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zfx
 * @since 2022-03-12
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategorytDAO categorytDAO;

    @Override
    public List<Category> getAllLevel1() {
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria();
        return categorytDAO.selectByExample(categoryExample);
    }
}
