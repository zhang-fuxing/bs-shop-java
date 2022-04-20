package com.z.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.z.mapper.CategoryMapper;
import com.z.model.Category;
import com.z.service.CategoryService;
import com.z.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author z
 * @since 2022-04-19
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryVO> getLv2List() {
        List<CategoryVO> detail = categoryMapper.selectLv2List();
        if (CollectionUtils.isEmpty(detail)) {
            return null;
        }
        return detail;
    }
}
