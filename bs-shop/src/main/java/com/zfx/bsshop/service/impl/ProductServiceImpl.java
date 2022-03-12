package com.zfx.bsshop.service.impl;

import com.zfx.bsshop.model.Product;
import com.zfx.bsshop.mapper.ProductMapper;
import com.zfx.bsshop.service.ProductService;
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
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
