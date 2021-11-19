package com.lyuwalle.backend.controller;

import com.lyuwalle.backend.common.RespBean;
import com.lyuwalle.backend.common.VerificationCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

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

    @GetMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        VerificationCode verificationCode = new VerificationCode();
        BufferedImage image = verificationCode.getImage();
        String text = verificationCode.getText();
        HttpSession session = request.getSession(true);
        session.setAttribute("verifyCode", text);
        VerificationCode.output(image, response.getOutputStream());
    }
}
