package com.z.controller;


import cn.hutool.core.lang.Snowflake;
import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.z.model.User;
import com.z.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
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
@RequestMapping("/cimage")
@CrossOrigin
public class CimageController {

    @Autowired
    private Snowflake snowflake;
    @Autowired
    private UserService userService;

    @PostMapping("/header")
    public void header(@RequestParam("file")MultipartFile files, HttpServletRequest request) throws IOException {
        int uid = (int) JWTUtil.parseToken(request.getHeader("token")).getPayload("id");
        String fileName = snowflake.nextIdStr();
        String oldName = files.getOriginalFilename();
        assert oldName != null;
        String[] suffix = oldName.split("\\.");
        String newName = fileName + "." + suffix[suffix.length - 1];
        files.transferTo(new File("D:\\project-resources\\head-img\\",newName));
        userService.update(
                new UpdateWrapper<User>().eq("id",uid)
                        .set("head_img","http://localhost:9000/static/head-img/"+newName)
        );
    }

}
