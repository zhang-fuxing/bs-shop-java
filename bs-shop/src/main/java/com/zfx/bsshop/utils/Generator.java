package com.zfx.bsshop.utils;

/**
 * @author zfx
 * @date 2022-03-03 22:03
 */
public class Generator {
    public static void main(String[] args) {
        /*
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/netmall?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8",
                        "root", "000000")
                .globalConfig(builder -> {
                    builder.author("zfx") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            // 指定输出目录
                            .outputDir("C:\\Users\\zfx\\Desktop\\workspaces\\k\\java\\shop\\bs-shop\\src\\main\\java");
                })
                .packageConfig(builder -> {
                    builder.parent("com.zfx") // 设置父包名
                            .moduleName("bsshop") // 设置父包模块名
                            .entity("model")
                            .mapper("mapper")
                            .xml("mapper")
                            .service("service")
                            // 设置mapperXml生成路径
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,
                                    "C:\\Users\\zfx\\Desktop\\workspaces\\k\\java\\shop\\bs-shop\\src\\main\\resources\\mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("customer","product","pimage","cimage","category","address") // 设置需要生成的表名
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
        */

        /*
        String host = "smtp.163.com";
        // 获取系统属性
        Properties props = System.getProperties();

        // 设置邮件服务器
        props.setProperty("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.setProperty("mail.user", "13648586653@163.com");
        props.setProperty("mail.password", "kfk.mylp0");
        Session session = Session.getDefaultInstance(props);

        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress("13648586653@163.com"));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress("13312467520@163.com"));

            // Set Subject: 头部头字段
            message.setSubject("我是头部!");

            // 设置消息体
            message.setText("这是正体");
            // 发送消息
            Transport.send(message);
            System.out.println("Sent message successfully....");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
        */
    }
}
