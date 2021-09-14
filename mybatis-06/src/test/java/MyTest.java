import com.zhangfei.mapper1.TeacherMapper;
import com.zhangfei.pojo.Teacher;
import com.zhangfei.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


public class MyTest {
    @Test
    public  void testGetTeacher(){
//        SqlSession session = MybatisUtils.getSqlSession();
//        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
//        Teacher teacher = mapper.getTeacher(1);
//        System.out.println(teacher.getName());
//        System.out.println(teacher.getStudents());
        SqlSession session = MybatisUtils.getSqlSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher.getName());
        System.out.println(teacher.getStudents());

    }

    @Test
    public void testGetTeacher2(){
        SqlSession session = MybatisUtils.getSqlSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher2(1);
        System.out.println(teacher.getName());
        System.out.println(teacher.getStudents());
    }

}
