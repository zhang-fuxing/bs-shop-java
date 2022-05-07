package com.z.controller;


import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.z.common.util.ResultModel;
import com.z.model.Estimate;
import com.z.service.EstimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author z
 * @since 2022-05-05
 */
@RestController
@RequestMapping("/estimate")
@CrossOrigin
public class EstimateController {

    @Autowired
    private EstimateService estimateService;

    @PostMapping("/add")
    public String addEstimate(@RequestBody Estimate estimate, HttpServletRequest request) {
        int uid = (int) JWTUtil.parseToken(request.getHeader("token")).getPayload("id");
        String nickname = String.valueOf(JWTUtil.parseToken(request.getHeader("token")).getPayload("nickname"));
        estimate.setUid(uid);
        estimate.setNickname(nickname);
        estimate.setCreateTime(LocalDateTime.now());
        boolean save = estimateService.save(estimate);
        if (!save) {
            return ResultModel.error(-1,"评论失败");
        }
        return ResultModel.success("评论成功");

    }

    @PostMapping("/product/{pid}")
    public String getEstimateByProduct(@PathVariable("pid") Integer pid) {
        List<Estimate> list = estimateService.list(new QueryWrapper<Estimate>().eq("pid", pid).eq("is_delete", 0));
        if (CollectionUtils.isEmpty(list)) {
            return ResultModel.success(1,"暂无评论");
        }
        return ResultModel.success(list);
    }

    @PostMapping("/user")
    public String getEstimateByUser(HttpServletRequest request) {
        int uid = (int) JWTUtil.parseToken(request.getHeader("token")).getPayload("id");
        List<Estimate> list = estimateService.list(new QueryWrapper<Estimate>().eq("uid", uid).eq("is_delete", 0));
        if (CollectionUtils.isEmpty(list)) {
            return ResultModel.success(1,"暂无评论");
        }
        return ResultModel.success(list);
    }

}
