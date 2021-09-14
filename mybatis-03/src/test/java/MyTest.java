import com.zhangfei.dao.UserDao;
import com.zhangfei.pojo.User;
import com.zhangfei.util.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {

    static Logger logger = Logger.getLogger(MyTest.class);
    @Test
    public void selectUser() {

        logger.info("info：进入selectUser方法");
        logger.debug("debug：进入selectUser方法");
        logger.error("error: 进入selectUser方法");
        SqlSession session = MybatisUtils.getSqlSession();
//        //方法一:
//        List<User> users = session.selectList("com.zhangfei.dao.UserMapper.selectUser");

        //方法二:
        //session 先获得通过 getMapper 获得 实现的接口.mapper
        UserDao mapper = session.getMapper(UserDao.class);
        //实现的mapper 调用需要重写的方法  获得return的对象
        List<User> users = mapper.selectUser();

        for (User user: users){
            System.out.println(user);
        }

        //关闭 session
        session.close();
    }
    @Test
    public void selectUserById() {

        SqlSession session = MybatisUtils.getSqlSession();  //获取SqlSession连接
        UserDao mapper = session.getMapper(UserDao.class);
        User user = mapper.selectUserById(1);
        System.out.println(user);
        session.close();
    }


    @Test
    public void selectUserByNP() {

        SqlSession session = MybatisUtils.getSqlSession();  //获取SqlSession连接
        UserDao mapper = session.getMapper(UserDao.class);
        User user = mapper.selectUserByNP("狂神","123456");
        System.out.println(user);
        session.close();
    }



    @Test
    public void selectUserByNP2() {

        Map<String, Object> map=new HashMap<String, Object>();
        map.put("name1","狂神");
        map.put("password","123456");

        SqlSession session = MybatisUtils.getSqlSession();  //获取SqlSession连接
        UserDao mapper = session.getMapper(UserDao.class);
        User user = mapper.selectUserByNP2(map);
        System.out.println(user);
        session.close();
    }


    @Test
    public void addUser() {

        SqlSession session = MybatisUtils.getSqlSession();  //获取SqlSession连接
        UserDao mapper = session.getMapper(UserDao.class);
        User user = new User(5,"王五","zxcvbn");
        int i = mapper.addUser(user);
        System.out.println(i);
        session.commit();//提交事务,重点!不写的话不会提交到数据库
        session.close();
    }
    @Test
    public void testUpdateUser() {
        SqlSession session = MybatisUtils.getSqlSession();
        UserDao mapper = session.getMapper(UserDao.class);
        User user = mapper.selectUserById(1);
        user.setPwd("asdfgh");
        int i = mapper.updateUser(user);
        System.out.println(i);
        session.commit(); //提交事务,重点!不写的话不会提交到数据库
        session.close();
    }

    @Test
    public void testDeleteUser() {
        SqlSession session = MybatisUtils.getSqlSession();
        UserDao mapper = session.getMapper(UserDao.class);
        int i = mapper.deleteUser(5);
        System.out.println(i);
        session.commit(); //提交事务,重点!不写的话不会提交到数据库
        session.close();
    }

    @Test
    public void selectLikes() {
        SqlSession session = MybatisUtils.getSqlSession();


        UserDao mapper = session.getMapper(UserDao.class);
        String value="%张%";
        List<User> userList = mapper.selectLikes(value);
        for (User user:
             userList) {
            System.out.println(user);

        }
        session.close();
    }

    @Test
    public void selectUser1(){
        SqlSession session = MybatisUtils.getSqlSession();
        UserDao mapper = session.getMapper(UserDao.class);
        int currentPage = 1;  //第几页
        int pageSize = 2;  //每页显示几个
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("index",(currentPage-1)*pageSize);
        map.put("size",pageSize);

        List<User> userList = mapper.selectUser1(map);
        for (User user : userList) {
            System.out.println(user);
        }
        session.close();

    }

    @Test
    public void testUserByRowBounds() {
        SqlSession session = MybatisUtils.getSqlSession();

        int currentPage = 2;  //第几页
        int pageSize = 2;  //每页显示几个
        RowBounds rowBounds = new RowBounds((currentPage-1)*pageSize,pageSize);

        //通过session.**方法进行传递rowBounds，[此种方式现在已经不推荐使用了]
        List<User> users = session.selectList("com.zhangfei.dao.UserDao.getUserByRowBounds", null, rowBounds);

        for (User user: users){
            System.out.println(user);
        }
        session.close();
    }


}
