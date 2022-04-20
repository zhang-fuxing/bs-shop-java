package com.zfx.bsshop.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zfx
 * @since 2022-03-12
 */
public interface PimageService {
    String fileupload(MultipartFile[] files, String path,  String prefix);
}
