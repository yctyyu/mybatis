package org.yu.study.mybatis;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.yu.study.mybatis.controller.IUserDao;
import org.yu.study.mybatis.controller.User;
import org.yu.study.mybatis.io.Resources;
import org.yu.study.mybatis.sqlSession.SqlSession;
import org.yu.study.mybatis.sqlSession.SqlSessionFactory;
import org.yu.study.mybatis.sqlSession.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

@SpringBootTest
public class MybatisApplicationTests {

    @Test
    public void contextLoads() throws Exception {
        //获取配置文件数据
        InputStream resourceAsSteam = Resources.getResourceAsSteam("SqlMapConfig.xml");
        //创建sqlSession工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        //生产sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //调用
        User user = new User();
        user.setId(1);
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        User byCondition = userDao.findByCondition(user);
        List<User> all = userDao.findAll();
        for (User user1 : all) {
            System.out.println(user1);
        }
    }

}
