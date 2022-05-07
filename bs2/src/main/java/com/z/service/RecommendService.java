package com.z.service;

import com.z.model.Recommend;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author z
 * @since 2022-04-28
 */
public interface RecommendService extends IService<Recommend> {
    String getRecommendList();
}
