package com.z.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.z.common.util.ResultModel;
import com.z.model.Pimage;
import com.z.mapper.PimageMapper;
import com.z.service.PimageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author z
 * @since 2022-04-19
 */
@Service
public class PimageServiceImpl extends ServiceImpl<PimageMapper, Pimage> implements PimageService {

    @Autowired
    private PimageMapper pimageMapper;

    @Override
    public String fileupload(MultipartFile files, int imgType) {
        String oldName = files.getOriginalFilename();
        assert oldName != null;
        String result = null;
        String[] suffix = oldName.split("\\.");
        if (imgType == 1) {
            String newName = "previewImage-" + System.currentTimeMillis() + "." + suffix[suffix.length - 1];
            try {
                files.transferTo(new File("D:\\project-resources\\active\\preview\\" + newName));
                result = ResultModel.success(
                        new Pimage(imgType, newName, "D:\\project-resources\\active\\preview\\",
                                "static/active/preview/", "http://localhost:9000/",
                                LocalDateTime.now(), null, null, null));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if (imgType == 2) {
            String newName = "detailImage-" + System.currentTimeMillis() + "." + suffix[suffix.length - 1];
            try {
                files.transferTo(new File("D:\\project-resources\\active\\details\\" + newName));
                result = ResultModel.success(
                        new Pimage(imgType, newName, "D:\\project-resources\\active\\details\\",
                                "static/active/details/", "http://localhost:9000/",
                                LocalDateTime.now(), null, null, null));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return result;
    }

    @Override
    public String getImageListByPid(int productId) {
        QueryWrapper<Pimage> wrapper = new QueryWrapper<>();
        wrapper.eq("pid", productId);
        List<Pimage> pimages = pimageMapper.selectList(wrapper);
        if (CollectionUtils.isEmpty(pimages)) {
            return ResultModel.error(-1, "该商品没有图片");
        }
        return ResultModel.success(pimages);
    }
}
