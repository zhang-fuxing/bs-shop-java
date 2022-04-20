package com.z.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.z.common.util.IPages;
import com.z.model.Product;
import com.z.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author z
 * @since 2022-04-19
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
    int selectProductNum();
    List<ProductVO> selectProductList(IPages iPages);
}
