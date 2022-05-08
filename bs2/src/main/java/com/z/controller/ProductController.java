package com.z.controller;


import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.z.common.util.IPages;
import com.z.common.util.ResultModel;
import com.z.dto.ProductDTO;
import com.z.model.Pimage;
import com.z.model.Product;
import com.z.service.PimageService;
import com.z.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author z
 * @since 2022-04-19
 */
@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ProductService productService;

    @Autowired
    private PimageService pimageService;

    @PostMapping("/add")
    public String addProduct(@RequestBody ProductDTO productDTO, HttpServletRequest request) {

        System.out.println(productDTO);
        Product product = productDTO.getProduct();
        Pimage[] preview = productDTO.getPreviewImage();
        Pimage[] detail = productDTO.getDetailImage();

        if (product == null) {
            logger.info("参数错误");
            return ResultModel.error("不能添加空商品");
        }


        String uname = (String) JWTUtil.parseToken(request.getHeader("token")).getPayload("uname");
        boolean save = productService.save(product);
        Integer pid = null;
        if (save) {
            pid = product.getId();
            if (preview != null) {
               for (Pimage pimage : preview) {
                   pimage.setPid(pid);
                   pimage.setCreatedUser(uname);
                   pimage.setCreatedTime(LocalDateTime.now());
                   pimageService.save(pimage);
               }
           }
           if (detail != null) {
               for (Pimage pimage : detail) {
                   pimage.setPid(pid);
                   pimage.setCreatedUser(uname);
                   pimage.setCreatedTime(LocalDateTime.now());
                   pimageService.save(pimage);
               }
           }
        }

        return ResultModel.success("添加成功",pid);
    }

    /**
     * 根据商品的id移除商品 该删除为伪删除
     *
     * @param pid     需要删除的商品id
     * @param request 根据请求头获取token，解析出当前用户名，更新修改商品的用户
     * @return 执行情况
     */
    @GetMapping("/remove")
    public String removeProduct(Integer pid, HttpServletRequest request) {
        if (pid == null) {
            return ResultModel.error();
        }
        String username = "";
        if (!productService.removeProduct(pid, username)) {
            return ResultModel.error("数据库异常，移除失败");
        }
        return ResultModel.success("删除成功");
    }

    /**
     * @param product 更新的商品对象
     * @param request 根据请求头获取token，解析出当前用户名，更新修改商品的用户
     * @return 执行情况
     */
    @PostMapping("/modified")
    public String update(@RequestBody Product product, HttpServletRequest request) {
        logger.info("进入更新方法");
        if (product == null) {
            return ResultModel.error();
        }

        logger.info("开始更新操作");
        String token = request.getHeaders("token").toString();
        String username = "";
        if (!productService.updateProduct(product, username)) {
            return ResultModel.error("更新失败");
        }

        return ResultModel.success("更新完成");

    }

    /**
     * 获取商品总条数
     * @return 商品的数量
     */
    @RequestMapping("/count")
    public String getProductCount() {
        logger.info("获取商品总数");
        int count = (int) productService.count();
        return ResultModel.success(count);
    }

    @GetMapping("/count1/{lv1}")
    public String getCount1(@PathVariable("lv1") Integer id1) {
        QueryWrapper<Product> productQueryWrapper = new QueryWrapper<>();
        productQueryWrapper.eq("category_id", id1).eq("is_delete",0);
        int count1 = (int) productService.count(productQueryWrapper);
        return ResultModel.success(count1);
    }
    /**
     * 获取二级分类商品总条数
     * @return 商品的数量
     */
    @RequestMapping("/count2/{lv2Id}")
    public String getProductCount2(@PathVariable("lv2Id") Integer id2) {
        logger.info("获取商品总数");
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.eq("ctg_id",id2);
        int count = (int) productService.count(wrapper);
        return ResultModel.success(count);
    }

    /**
     * 分页查询商品列表
     * @param pages 分页对象
     * @return 商品列表
     */
    @RequestMapping("/list")
    public String getList(@RequestBody IPages pages) {
        logger.info("查询商品列表，参数 pages:" + pages);
        String msg = "";
        double count = productService.count();
        double maxPage =  Math.ceil(count / pages.getPageSize());
        logger.info("maxpage:" + maxPage);
        if (pages.getCurrentPage() > maxPage) {
            return ResultModel.error("查无此页");
        }

        if (pages.getPageSize() > 100) {
            msg = "一次最多查询100条数据";
            pages.setPageSize(100);
        }

        List<Product> productList = productService.getProductList(pages);
        if (CollectionUtils.isEmpty(productList)) {
            return ResultModel.error("未查寻到数据");
        }

        return ResultModel.success(msg,productList);
    }


    @GetMapping("/productInfo/{productId}")
    public String getProductById(@PathVariable("productId") Integer productId) {
        return productService.getProductById(productId);
    }


    @PostMapping("/search/{searchText}")
    public String searchProduct(@PathVariable("searchText") String searchText) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.like("pname",searchText).eq("is_delete",0);
        List<Product> list = productService.list(wrapper);
        if (CollectionUtils.isEmpty(list)) {
            return ResultModel.error(-1,"查询列表为空");
        }
        return ResultModel.success(list);
    }

}
