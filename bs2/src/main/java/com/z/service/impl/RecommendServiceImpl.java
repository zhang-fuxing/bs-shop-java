package com.z.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.z.common.util.ResultModel;
import com.z.model.Recommend;
import com.z.mapper.RecommendMapper;
import com.z.service.RecommendService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author z
 * @since 2022-04-28
 */
@Service
public class RecommendServiceImpl extends ServiceImpl<RecommendMapper, Recommend> implements RecommendService {

    @Autowired
    private RecommendMapper recommendMapper;

    @Override
    public String getRecommendList() {
        QueryWrapper<Recommend> wrapper = new QueryWrapper<>();

        List<Recommend> list = recommendMapper.selectList(wrapper);
        if (CollectionUtils.isEmpty(list)) {
            return ResultModel.error(-1,"推荐列表为空");
        }
        return ResultModel.success(list);
    }
}
