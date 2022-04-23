package com.lyuwalle.backend.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.lyuwalle.backend.common.RespBean;
import com.lyuwalle.backend.common.VerificationCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author lyuxiyang
 */
@Slf4j
@RestController
public class LoginController {

    /**
     * 用于提示：当没有登录而访问资源的时候，security会重定向到/login页面
     * @return
     */
    @GetMapping("/login")
    public RespBean login() {
        return RespBean.error("尚未登录，请登录！");
    }

    /**
     * 登录的时候会访问这个地址，把生成的验证码图片发给前端，对应的text放在session里面
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //CaptchaUtil是生成验证码的工具类, 参数分别表示长，宽，字符数量，干扰元素的个数
        CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(150, 35, 4, 20);
        BufferedImage image = circleCaptcha.getImage();
        String code = circleCaptcha.getCode();
        log.info("后台生成验证码：{}", code);
        HttpSession session = request.getSession(true);
        session.setAttribute("verify_code", code);
        ImageIO.write(image, "JPEG", response.getOutputStream());
        //circleCaptcha.write(response.getOutputStream());
    }
}
