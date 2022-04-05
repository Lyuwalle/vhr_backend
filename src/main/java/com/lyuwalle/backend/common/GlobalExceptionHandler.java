package com.lyuwalle.backend.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author: Lyuwalle  @date: 2022/04/05 19:48
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 表示当异常的类型是括号里面的类型时，就会生效
     * @param e
     * @return
     */
    @ExceptionHandler(SQLException.class)
    public RespBean mySQLException(SQLException e){
        if (e instanceof SQLIntegrityConstraintViolationException) {
            return RespBean.error("该数据有关联数据，操作失败!");
        }
        return RespBean.error("数据库异常，操作失败！");
    }
}
