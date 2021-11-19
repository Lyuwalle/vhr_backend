package com.lyuwalle.backend.utils;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * @author lyuxiyang
 *
 * 生成验证码的工具类
 */
public class VerificationCode {

    private int width = 100;
    private int height = 30;
    private int disturbLines = 5;
    private int verificationCodes = 4;
    private String[] fontNames = {"宋体", "楷体", "隶书", "微软雅黑"};
    private Color background = new Color(255, 255, 255);
    private Random random = new Random();
    private String codes = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String text;

    /**
     * 获取随机一个颜色
     * @return
     */
    private Color randomColor() {
        int red = random.nextInt(150);
        int green = random.nextInt(150);
        int blue = random.nextInt(150);
        return new Color(red, green, blue);
    }

    /**
     * 获取一个随机字体
     * @return
     */
    private Font randomFont() {
        String name = fontNames[random.nextInt(fontNames.length)];
        int style = random.nextInt(4);
        int size = random.nextInt(5) + 24;
        return new Font(name, style, size);
    }

    /**
     * 获取一个随机字符
     * @return
     */
    private char randomChar() {
        return codes.charAt(random.nextInt(codes.length()));
    }

    /**
     * 创建一个背景为白色的BufferedImage对象
     * @return
     */
    private BufferedImage createBackgroundImg() {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(background);
        graphics.fillRect(0, 0, width, height);
        return image;
    }

    /**
     * 绘制5条干扰线
     * @param image
     */
    private void drawLine(BufferedImage image) {
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        for (int i = 0; i < disturbLines; i++) {
            //线段的起点和终点的坐标
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            graphics.setColor(randomColor());
            //笔画的宽度
            graphics.setStroke(new BasicStroke(1.5f));
            graphics.drawLine(x1, y1, x2, y2);
        }
    }

    public BufferedImage getImage() {
        BufferedImage backgroundImg = createBackgroundImg();
        Graphics2D graphics = (Graphics2D) backgroundImg.getGraphics();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < verificationCodes; i++) {
            String s = randomChar() + "";
            sb.append(s);
            graphics.setColor(randomColor());
            graphics.setFont(randomFont());
            float x = i * width * 1.0f / 4;
            graphics.drawString(s, x, height - 8);
        }
        this.text = sb.toString();
        drawLine(backgroundImg);
        return backgroundImg;
    }

    public String getText() {
        return this.text;
    }
    public static void output(BufferedImage image, OutputStream out) throws IOException {
        ImageIO.write(image, "JPEG", out);

    }
}
