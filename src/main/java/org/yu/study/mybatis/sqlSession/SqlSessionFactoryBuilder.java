package org.yu.study.mybatis.sqlSession;

import org.dom4j.DocumentException;
import org.yu.study.mybatis.config.XMLConfigBuilder;
import org.yu.study.mybatis.pojo.Configuration;

import java.beans.PropertyVetoException;
import java.io.InputStream;

/**
 * @Author: YHY
 * @desc: SQLSession工厂构建器
 * @Date: 2022/11/13
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream in) throws DocumentException, PropertyVetoException {
        // 1、使用dom4j解析配置文件，将解析出来的内容封装到Configuration中
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parseConfig(in);

        // 2、创建sqlSessionFactory对象：工厂类：生产sqlSession:会话对象
        DefaultSqlSessionFactory defaultSqlSessionFactory = new DefaultSqlSessionFactory(configuration);

        return defaultSqlSessionFactory;
    }


}
