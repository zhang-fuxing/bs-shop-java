package com.z.service;

import com.z.model.Pimage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author z
 * @since 2022-04-19
 */
public interface PimageService extends IService<Pimage> {
    String fileupload(MultipartFile[] files, String path, String prefix);
}
