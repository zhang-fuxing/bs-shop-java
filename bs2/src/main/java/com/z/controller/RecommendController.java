package com.z.controller;


import com.z.service.RecommendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @PostMapping("/list")
    public String list() {
        logger.info("执行RecommendController==》list");
        return recommendService.getRecommendList();
    }

}
