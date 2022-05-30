package org.yu.study.mybatis.sqlSession;


import org.yu.study.mybatis.pojo.Configuration;

/**
 * @Author: YHY
 * @desc: SqlSession工厂
 * @Date: 2022/11/13
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }


    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
