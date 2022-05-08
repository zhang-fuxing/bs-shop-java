package com.z.controller;


import com.z.common.util.ResultModel;
import com.z.service.PimageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author z
 * @since 2022-04-19
 */
@RestController
@RequestMapping("/pimage")
@CrossOrigin
public class PimageController {
    @Autowired
    private PimageService ps;


    /**
     * 图片上传接口，处理商品图片上传
     * @param files 单个文件
     * @param imgType 图片类型：1.预览图；2.详情图
     * @return 上传成功，返回图片对象
     * @throws IOException 可能出现io异常
     */
    @PostMapping("/file/{imgType}")
    public String fileupload(@RequestParam("file") MultipartFile files,@PathVariable("imgType") int imgType) throws IOException {
        if(files == null) {
            return ResultModel.error("未选择文件");
        }

        String imageObject = ps.fileupload(files,imgType);
        if (imageObject == null) {
            return ResultModel.error("上传错误");
        }

        return (imageObject);
    }

    @GetMapping("/imgList/{productId}")
    public String getImageByPid(@PathVariable("productId") Integer productId) {
        String imageListByPid = ps.getImageListByPid(productId);
        return imageListByPid;
    }
}
