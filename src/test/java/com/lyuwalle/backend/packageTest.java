package com.lyuwalle.backend;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.GifCaptcha;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.generator.AbstractGenerator;
import cn.hutool.captcha.generator.CodeGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class packageTest {

    @Test
    public void testVerifyCode() throws IOException {
        int width = 100;
        int height = 25;
        Image image = new CircleCaptcha(width, height).createImage("4rn3");

        File file = new File("/Users/lyuxiyang/Downloads/vericode2.png");
        ImageIO.write((RenderedImage) image, "png", file);


    }

    /**
     * 线段干扰验证码
     *
     * @throws IOException
     */
    @Test
    public void testVerifyCode2() throws IOException{
        //默认生成5位验证码
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(100, 30);
        System.out.println(lineCaptcha.getCode());
        BufferedImage image = lineCaptcha.getImage();
        File file = new File("/Users/lyuxiyang/Downloads/vericode3.png");
        ImageIO.write(image, "png", file);
    }
}
