package com.z.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.z.common.util.ResultModel;
import com.z.model.Product;
import com.z.model.Recommend;
import com.z.service.ProductService;
import com.z.service.RecommendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author z
 * @since 2022-04-28
 */
@RestController
@RequestMapping("/recommend")
@CrossOrigin
public class RecommendController {

    private final Logger logger = LoggerFactory.getLogger(RecommendController.class);

    @Autowired
    private RecommendService recommendService;

    @Autowired
    private ProductService productService;


    @PostMapping("/list")
    public String list() {
        logger.info("执行RecommendController==》list");
        return recommendService.getRecommendList();
    }


    @PostMapping("/remove/{rid}")
    public String cancel(@PathVariable("rid") int rid){
        boolean id = recommendService.remove(new QueryWrapper<Recommend>().eq("id", rid));
        return ResultModel.success(id);
    }

    @PostMapping("/add/{pid}/{floor}")
    public String add(@PathVariable("pid") int pid,@PathVariable("floor") int floor){
        Product product = productService.getById(pid);
        Recommend recommend = new Recommend();
        recommend.setPid(product.getId());
        recommend.setFloor(floor);
        recommend.setPimg(product.getPimg());
        recommend.setPname(product.getPname());
        recommend.setPrice(product.getUnitPrice());
        recommend.setCreateTime(LocalDateTime.now());
        recommend.setIsCancel(0);
        boolean save = recommendService.save(recommend);
        return ResultModel.success(save);
    }

}
