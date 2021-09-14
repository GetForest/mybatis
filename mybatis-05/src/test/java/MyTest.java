import com.zhangfei.mapper.StudentMapper;
import com.zhangfei.pojo.Student;
import com.zhangfei.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;



public class MyTest {
    @Test
    public void testGetStudents(){
        SqlSession session = MybatisUtils.getSqlSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        List<Student> students = mapper.getStudents();

        for (Student student : students){
            System.out.println(
                    "学生id："+student.getId()+
                            "\t学生名:" + student.getName()
                            +"\t老师:"+student.getTeacher().getName());
        }
    }
    @Test
    public void testGetStudents2() {
        SqlSession session = MybatisUtils.getSqlSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        List<Student> students = mapper.getStudents2();

        for (Student student : students) {
            System.out.println(
                        "学生id："+student.getId()+
                    "\t学生名:" + student.getName()
                            + "\t老师:" + student.getTeacher().getName());
        }


    }

}
