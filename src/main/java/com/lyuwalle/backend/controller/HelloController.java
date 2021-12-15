package com.lyuwalle.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /**
     * 测试hello方法时，要把Hr类的getAuthorities返回null，才能输完用户密码之后跳转到/hello页面
     * @return
     */
    @GetMapping("/hello")
    public String hello() {
        return "hello test";
    }

    @GetMapping("/employee/advanced/hello2")
    public String hello2() {
        return "/employee/advanced/hello2";
    }

    @GetMapping("/employee/basic/hello3")
    public String hello3() {
        return "/employee/advanced/hello3";
    }

}
