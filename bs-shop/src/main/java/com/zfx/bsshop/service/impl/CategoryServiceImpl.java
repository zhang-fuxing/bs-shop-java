package com.zfx.bsshop.service.impl;

import com.zfx.bsshop.model.Category;
import com.zfx.bsshop.mapper.CategoryMapper;
import com.zfx.bsshop.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zfx
 * @since 2022-03-06
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
