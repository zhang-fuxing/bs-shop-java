package com.z.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.z.common.util.IPages;
import com.z.mapper.ProductMapper;
import com.z.model.Product;
import com.z.service.ProductService;
import com.z.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
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
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductVO> getProductList(IPages pages) {
        List<ProductVO> productList = productMapper.selectProductList(pages);
        if (CollectionUtils.isEmpty(productList)) {
            return null;
        }
        return productList;
    }

    @Override
    public boolean removeProduct(Integer id,String username) {
        Assert.notNull(id,"id不能为空");
        UpdateWrapper<Product> wrapper = new UpdateWrapper<>();
        wrapper.eq("id",id).set("is_delete",1).set("modified_time",LocalDateTime.now()).set("modified_user",username);
        return this.update(wrapper);
    }

    @Override
    public boolean updateProduct(Product product, String username) {
        UpdateWrapper<Product> wrapper = new UpdateWrapper<>();
        wrapper.eq("id",product.getId());
        if (product.getCategoryId() != null) {
            wrapper.set("category_id", product.getCategoryId());
        }
        if (product.getCtgId() != null) {
            wrapper.set("ctg_id", product.getCtgId());
        }
        if (product.getPname() != null) {
            wrapper.set("pname",product.getPname());
        }
        if (product.getDescription() != null) {
            wrapper.set("description",product.getDescription());
        }
        if (product.getUnitPrice() != null) {
            wrapper.set("unit_price", product.getUnitPrice());
        }
        if (product.getInventoryNum() != null) {
            wrapper.set("inventory_num", product.getInventoryNum());
        }
        wrapper.set("modified_time", LocalDateTime.now());
        wrapper.set("modified_user", username);

        return this.update(wrapper);
    }


}
