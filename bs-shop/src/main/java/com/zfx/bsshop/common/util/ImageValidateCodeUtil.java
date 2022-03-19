package com.zfx.bsshop.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author zfx
 * @date 2022-03-05 10:15
 */
public class ImageValidateCodeUtil {

    private static final Logger logger = LoggerFactory.getLogger(ImageValidateCodeUtil.class);


    /**
     * 放到session中的key
     */
    public static final String RANDOM_CODE_KEY = "RANDOM_VALIDATE_CODE_KEY";
    /**
     * 随机产生只有数字的字符串 private String
     * private final String randString = "0123456789";
     */
    private final String randString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    // 图片宽
    private final int width = 95;
    // 图片高
    private final int height = 25;
    // 干扰线数量
    private final int lineSize = 40;
    // 随机产生字符数量
    private final int stringNum = 4;


    private Random random = new Random();


    /**
     * 生成随机图片
     */
    public  void getAuthCode(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        // BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();// 产生Image对象的Graphics对象,改对象可以在图像上进行各种绘制操作
        g.fillRect(0, 0, width, height);//图片大小
        g.setFont(new Font("Times New Roman", Font.PLAIN, 18));//字体大小
        g.setColor(getRandColor(random.nextInt(111), random.nextInt(128) + 128));//字体颜色
        // 绘制干扰线
        for (int i = 0; i <= lineSize; i++) {
            drowLine(g);
        }
        // 绘制随机字符
        String randomString = "";
        for (int i = 1; i <= stringNum; i++) {
            randomString = drowString(g, randomString, i);
        }
        logger.info(randomString);
        //将生成的随机字符串保存到session中
        session.removeAttribute(RANDOM_CODE_KEY);
        session.setAttribute(RANDOM_CODE_KEY, randomString);
        session.setMaxInactiveInterval(60 * 3);
        g.dispose();
        try {
            // 将内存中的图片通过流动形式输出到客户端
            ImageIO.write(image, "JPEG", response.getOutputStream());
        } catch (Exception e) {
            logger.error("将内存中的图片通过流动形式输出到客户端失败>>>>   ", e);
        }


    }

    /**
     * 绘制字符串
     */
    private String drowString(Graphics g, String randomString, int i) {
        g.setFont(getFont());
        g.setColor(new Color(random.nextInt(101), random.nextInt(111), random
                .nextInt(121)));
        String rand = String.valueOf(getRandomString(random.nextInt(randString
                .length())));
        randomString += rand;
        g.translate(random.nextInt(3), random.nextInt(3));
        g.drawString(rand, 13 * i, 16);
        return randomString;
    }

    /**
     * 绘制干扰线
     */
    private void drowLine(Graphics g) {
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        int xl = random.nextInt(13);
        int yl = random.nextInt(15);
        g.drawLine(x, y, x + xl, y + yl);
    }

    /**
     * 获取随机的字符
     */
    private String getRandomString(int num) {
        return String.valueOf(randString.charAt(num));
    }

    /**
     * 获得字体
     *
     * @return 字体
     */
    private Font getFont() {
        return new Font("Fixedsys", Font.BOLD, 18);
    }

    /**
     * 获得颜色
     */
    private Color getRandColor(int fc, int bc) {
        int r = fc + random.nextInt(bc - fc - 16);
        int g = fc + random.nextInt(bc - fc - 14);
        int b = fc + random.nextInt(bc - fc - 18);
        return new Color(r, g, b);
    }
}


