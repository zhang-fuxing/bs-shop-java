package com.z.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.z.common.util.IPages;
import com.z.model.Product;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author z
 * @since 2022-04-19
 */
public interface ProductService extends IService<Product> {
    List<Product> getProductList(IPages pages);
    boolean removeProduct(Integer id,String username);
    boolean updateProduct(Product product,String username);
    String getProductById(Integer productId);

}
