package com.zfx.bsshop.service.impl;

import com.zfx.bsshop.dao.CategorytDAO;
import com.zfx.bsshop.dao.space.CategoryDetailSpaceDAO;
import com.zfx.bsshop.model.Category;
import com.zfx.bsshop.model.CategoryExample;
import com.zfx.bsshop.service.CategoryService;
import com.zfx.bsshop.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private CategoryDetailSpaceDAO cdet;

    @Override
    public List<Category> getAllLevel1() {
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria();
        return categorytDAO.selectByExample(categoryExample);
    }



    @Override
    public List<CategoryVO> getAllLevel2() {
        List<CategoryVO> list = cdet.selectCategoryDetail(new HashMap<>());
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list;
    }

    @Override
    public List<CategoryVO> getLevelById(int id) {
        Map<String,Integer> map = new HashMap<>();
        map.put("lv1id",id);
        List<CategoryVO> list = cdet.selectCategoryDetail(map);
        if (CollectionUtils.isEmpty(list))
            return null;
        return list;
    }

}
