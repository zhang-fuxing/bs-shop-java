package com.zfx.bsshop.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/**
 * @author zfx
 * @date 2022-03-03 22:03
 */
public class Generator {
//    public static void main(String[] args) {
//        FastAutoGenerator.create("jdbc:mysql://localhost:3306/netmall?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8",
//                        "root", "000000")
//                .globalConfig(builder -> {
//                    builder.author("zfx") // 设置作者
//                            .fileOverride() // 覆盖已生成文件
//                            // 指定输出目录
//                            .outputDir("C:\\Users\\zfx\\Desktop\\workspaces\\k\\java\\shop\\bs-shop\\src\\main\\java");
//                })
//                .packageConfig(builder -> {
//                    builder.parent("com.zfx") // 设置父包名
//                            .moduleName("bsshop") // 设置父包模块名
//                            .entity("model")
//                            .mapper("mapper")
//                            .xml("mapper")
//                            .service("service")
//                            // 设置mapperXml生成路径
//                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,
//                                    "C:\\Users\\zfx\\Desktop\\workspaces\\k\\java\\shop\\bs-shop\\src\\main\\resources\\mapper"));
//                })
//                .strategyConfig(builder -> {
//                    builder.addInclude("user","product","pimage","cimage","category","address","ctg_detail","prd_attr") // 设置需要生成的表名
//                            .serviceBuilder()
//                            .formatServiceFileName("%sService")
//                            .mapperBuilder()
//                            .enableMapperAnnotation()
//                            .superClass(BaseMapper.class)
//                            .formatMapperFileName("%sMapper")
//                            .formatXmlFileName("%sMapper");
//                })
//                .templateEngine(new FreemarkerTemplateEngine())
//                .execute();
//
//        /*
//        String host = "smtp.163.com";
//        // 获取系统属性
//        Properties props = System.getProperties();
//
//        // 设置邮件服务器
//        props.setProperty("mail.smtp.host", host);
//        props.put("mail.smtp.auth", "true");
//        props.setProperty("mail.user", "13648586653@163.com");
//        props.setProperty("mail.password", "kfk.mylp0");
//        Session session = Session.getDefaultInstance(props);
//
//        try{
//            // 创建默认的 MimeMessage 对象
//            MimeMessage message = new MimeMessage(session);
//
//            // Set From: 头部头字段
//            message.setFrom(new InternetAddress("13648586653@163.com"));
//
//            // Set To: 头部头字段
//            message.addRecipient(Message.RecipientType.TO,
//                    new InternetAddress("13312467520@163.com"));
//
//            // Set Subject: 头部头字段
//            message.setSubject("我是头部!");
//
//            // 设置消息体
//            message.setText("这是正体");
//            // 发送消息
//            Transport.send(message);
//            System.out.println("Sent message successfully....");
//        }catch (MessagingException mex) {
//            mex.printStackTrace();
//        }
//        */
//    }

    private String from = "136485866563@163.com";// 发件人的邮箱地址
    private String user = "zfx";// 发件人称号，同邮箱地址
    private String password = "CUFQRPHKKZQCRZMK";// 发件人邮箱客户端的授权码

    public static void main(String[] args) {
        new Generator().sendMail("bujin08819wdu@163.com","123123","title");
    }
    /* 发送验证信息的邮件 */
    public boolean sendMail(String to, String text, String title) {
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.163.com"); // 设置发送邮件的邮件服务器的属性（这里使用网易的smtp服务器）
        props.put("mail.smtp.host", "smtp.163.com"); // 需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条）
        props.put("mail.smtp.auth", "true"); // 用刚刚设置好的props对象构建一个session
        Session session = Session.getDefaultInstance(props); // 有了这句便可以在发送邮件的过程中在console处显示过程信息，供调试使
        // 用（你可以在控制台（console)上看到发送邮件的过程）
        session.setDebug(true); // 用session为参数定义消息对象
        MimeMessage message = new MimeMessage(session); // 加载发件人地址
        try {
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); // 加载收件人地址
            message.setSubject(title); // 加载标题
            Multipart multipart = new MimeMultipart(); // 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
            BodyPart contentPart = new MimeBodyPart(); // 设置邮件的文本内容
            contentPart.setContent(text, "text/html;charset=utf-8");
            multipart.addBodyPart(contentPart);
            message.setContent(multipart);
            message.saveChanges(); // 保存变化
            Transport transport = session.getTransport("smtp"); // 连接服务器的邮箱
            transport.connect("smtp.163.com", user, password); // 把邮件发送出去
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
