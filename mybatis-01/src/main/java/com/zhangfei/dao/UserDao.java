package com.zhangfei.dao;

import com.zhangfei.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author MagiskBoy
 */
public interface UserDao {
    List<User> selectUser();

    User selectUserById(int id);

    User selectUserByNP(@Param("name")String name,@Param("password") String pwd);

    User selectUserByNP2(Map<String,Object> map);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

    List<User> selectLikes(String value);

}
