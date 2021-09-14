package com.zhangfei.mapper;

import com.zhangfei.pojo.Student;

import java.util.List;

/**
 * @author MagiskBoy
 */
public interface StudentMapper {


    /**
     * 按查询嵌套处理
     * @return
     */
    public List<Student> getStudents();
    /**
     * 结果嵌套处理
     * @return
     */
    public List<Student> getStudents2();
}
