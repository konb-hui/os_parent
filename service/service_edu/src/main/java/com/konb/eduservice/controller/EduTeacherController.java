package com.konb.eduservice.controller;


import com.konb.commonutils.R;
import com.konb.eduservice.entity.EduTeacher;
import com.konb.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-09-06
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {

    //把service注入
    @Autowired
    private EduTeacherService teacherService;

    //查询讲师表所有数据
    //rest风格
    @GetMapping("findAll")
    @ApiOperation(value = "获得所有讲师")
    public R findAllTeacher() {
        //调用service的方法实心调用
        List<EduTeacher> teachers = teacherService.list(null);
        return R.ok().data("items", teachers);
    }

    //逻辑删除讲师的方法
    @DeleteMapping("{id}")                                  //表示id需要路径来传递
    @ApiOperation(value = "逻辑删除讲师")
    public R removeTeacher(@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable String id) { //获取路径中的id值
        boolean flag = teacherService.removeById(id);
        if (flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }


}

