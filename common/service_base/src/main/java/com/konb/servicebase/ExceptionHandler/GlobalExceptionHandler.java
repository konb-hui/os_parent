package com.konb.servicebase.ExceptionHandler;

import com.konb.commonutils.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    //指定出现什么异常执行这个方法
    @ExceptionHandler(Exception.class)
    //返回数据
    @ResponseBody
    public R error(Exception e) {
        e.printStackTrace();
        return R.error().message("执行了全局异常处理...");
    }

    //特定异常
    @ExceptionHandler(ArithmeticException.class)
    //返回数据
    @ResponseBody
    public R error(ArithmeticException e) {
        e.printStackTrace();
        return R.error().message("执行了ArithmeticException异常处理...");
    }

    //自定义异常
    @ExceptionHandler(OsException.class)
    //返回数据
    @ResponseBody
    public R error(OsException e) {
        e.printStackTrace();
        return R.error().message("执行了OsException异常处理...");
    }

}
