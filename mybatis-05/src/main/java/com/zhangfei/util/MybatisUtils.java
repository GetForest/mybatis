package com.zhangfei.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//sqlSessionFactory --> sqlSession

/**
 * 我的第一个mabatis 程序
 *
 * @author MagiskBoy
 */
public class MybatisUtils {

    static SqlSessionFactory sqlSessionFactory = null;

    static {
        try {
            //使用Mybatis第一步 ：获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";


            InputStream inputStream = Resources.getResourceAsStream(resource);

            // 第一步 通过 Resource 加载全局配置文件

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //第二步骤 实例化 sqlsessionFactoryBUider
            //第三部 是build 方法中 xmlCONFIGbuider解析xml
            //第四部  将解析的配置内容放到 configuration中去
            // 第五步 返回的 是新建的 sqlfsessionfactory


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例.

    // SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}