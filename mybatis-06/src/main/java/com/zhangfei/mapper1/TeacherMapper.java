package com.zhangfei.mapper1;

import com.zhangfei.pojo.Teacher;

/**
 * @author MagiskBoy
 */
public interface TeacherMapper {

    //获取指定老师，及老师下的所有学生
    public Teacher getTeacher(int id);


    public Teacher getTeacher2(int id);
}
