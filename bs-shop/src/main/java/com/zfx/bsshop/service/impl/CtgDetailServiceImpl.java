package com.zfx.bsshop.service.impl;

import com.zfx.bsshop.dao.CtgDetailDAO;
import com.zfx.bsshop.model.CtgDetail;
import com.zfx.bsshop.model.CtgDetailExample;
import com.zfx.bsshop.service.CtgDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zfx
 * @since 2022-03-12
 */
@Service
public class CtgDetailServiceImpl implements CtgDetailService {
    @Autowired
    private CtgDetailDAO ctgDetailDAO;

    @Override
    public List<CtgDetail> getAllLevel2() {
        CtgDetailExample ctgDetailExample = new CtgDetailExample();
        ctgDetailExample.createCriteria();
        return ctgDetailDAO.selectByExample(ctgDetailExample);
    }
}
