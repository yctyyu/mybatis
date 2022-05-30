package org.yu.study.mybatis.sqlSession;


import org.yu.study.mybatis.pojo.Configuration;
import org.yu.study.mybatis.pojo.MappedStatement;

import java.lang.reflect.*;
import java.util.List;

/**
 * @Author: YHY
 * @desc: SqlSession默认对象
 * @Date: 2022/11/13
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <E> List<E> selectList(String statementid, Object... params) throws Exception {

        //将要去完成对simpleExecutor里的query方法的调用
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementid);
        List<Object> list = simpleExecutor.query(configuration, mappedStatement, params);

        return (List<E>) list;
    }

    @Override
    public <T> T selectOne(String statementid, Object... params) throws Exception {
        List<Object> objects = selectList(statementid, params);
        if (objects.size() == 1) {
            return (T) objects.get(0);
        } else {
            throw new RuntimeException("查询结果为空或者返回结果过多");
        }


    }

    @Override
    public <T> T getMapper(Class<?> mapperClass) {
        // 使用JDK动态代理来为Dao接口生成代理对象，并返回
        System.out.println(mapperClass);
        Object proxyInstance = Proxy.newProxyInstance(DefaultSqlSession.class.getClassLoader(), new Class[]{mapperClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 底层都还是去执行JDBC代码 //根据不同情况，来调用selctList或者selectOne
                // 准备参数 1：statmentid :sql语句的唯一标识：namespace.id= 接口全限定名.方法名
                // 方法名：findAll
                String methodName = method.getName();
                System.out.println("methodName = " + methodName);
                String className = method.getDeclaringClass().getName();
                System.out.println("className = " + className);

                String statementId = className + "." + methodName;
                System.out.println("statementId = " + statementId);

                // 准备参数2：params:args
                // 获取被调用方法的返回值类型
                Type genericReturnType = method.getGenericReturnType();
                System.out.println("genericReturnType = " + genericReturnType);
                // 判断是否进行了 泛型类型参数化
                if (genericReturnType instanceof ParameterizedType) {
                    List<Object> objects = selectList(statementId, args);
                    return objects;
                }
                return selectOne(statementId, args);
            }
        });

        return (T) proxyInstance;
    }


}
