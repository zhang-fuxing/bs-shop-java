package com.z;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author zfx
 * @date 2022-04-19 12:02
 */
public class CodeAi {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/netmall?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8",
                        "root", "000000")
                .globalConfig(builder -> {
                    builder.author("z") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            // 指定输出目录
                            .outputDir( "C:\\Users\\zfx\\Desktop\\workspaces\\k\\java\\springbootCollection\\bs2\\src\\main\\java");
                })
                .packageConfig(builder -> {
                    builder.parent("com") // 设置父包名
                            .moduleName("z") // 设置父包模块名
                            .entity("model")
                            .mapper("mapper")
                            .xml("mapper")
                            .service("service")
                            // 设置mapperXml生成路径
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,
                                    "C:\\Users\\zfx\\Desktop\\workspaces\\k\\java\\springbootCollection\\bs2\\src\\main\\resources\\mapper"));
                })
                .strategyConfig(builder -> {
                    // "user","product","pimage","ctg_detail","estimate"，"address","category","cimage",
                    // "prd_attr"，"order","address","cart_item","order_item"，"cart_item","user_estimate"
                    // "recommend"
                    builder.addInclude("estimate") // 设置需要生成的表名
                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                            .mapperBuilder()
                            .enableMapperAnnotation()
                            .superClass(BaseMapper.class)
                            .formatMapperFileName("%sMapper")
                            .formatXmlFileName("%sMapper");
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();

        // MailUtil.send("1789253892@qq.com","sbxxxx","sbxx",false,new File("D:\\localfile\\photos\\1\\1.jpeg"));

    }
}
