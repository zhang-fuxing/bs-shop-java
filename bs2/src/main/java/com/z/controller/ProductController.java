package com.z.controller;


import com.z.common.util.IPages;
import com.z.common.util.JwtUtils;
import com.z.common.util.ResultModel;
import com.z.model.Product;
import com.z.service.ProductService;
import com.z.vo.ProductVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    /**
     * 添加商品的接口
     *
     * @param product 添加的目标对象
     * @return 根据情况返回方法执行情况
     */
    @PostMapping("/add")
    public String addProduct(@RequestBody Product product) {
        logger.info("进入添加商品方法，参数 product:" + product);
        if (product == null) {
            logger.info("参数错误");
            return ResultModel.error("不能添加空商品");
        }
        boolean save = productService.save(product);
        if (!save) {
            logger.info("插入数据库失败");
            return ResultModel.error("插入失败");
        }
        return ResultModel.success("添加成功");
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
        String token = request.getHeaders("token").toString();
        String username = JwtUtils.getClaimByName(token, "username", String.class);
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
        String username = JwtUtils.getClaimByName(token, "username", String.class);
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
        long count = productService.count();
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
        long count = productService.count();
        int maxPage = (int) (count / pages.getPageSize());
        if (pages.getCurrentPage() > maxPage) {
            return ResultModel.error("查无此页");
        }

        if (pages.getPageSize() > 100) {
            msg = "一次最多查询100条数据";
            pages.setPageSize(100);
        }

        List<ProductVO> productList = productService.getProductList(pages);
        if (CollectionUtils.isEmpty(productList)) {
            return ResultModel.error("未查寻到数据");
        }

        return ResultModel.success(msg,productList);
    }
}
