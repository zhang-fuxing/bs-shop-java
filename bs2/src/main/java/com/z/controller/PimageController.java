package com.z.controller;


import com.alibaba.fastjson.JSON;
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

    @PostMapping("/file")
    public String fileupload(@RequestParam("file") MultipartFile[] files) throws IOException {
        if(files.length == 0) {
            return JSON.toJSONString( ResultModel.error("未选择文件"));
        }
        if (!ps.fileupload(files,"D:/project-resources","det").equals("success")) {
            return JSON.toJSONString( ResultModel.error("上传错误"));
        }

        return JSON.toJSONString(ResultModel.success("上传成功"));
    }
}
