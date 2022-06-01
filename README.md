# mybatis
学习mybatis项目笔记

# 项目介绍
    本项目通过模仿mybatis实现封装jdbc的核心功能
    
# 核心类介绍
    org.yu.study.mybatis.config.XMLConfigBuilder：主要用来解析数据库连接配置，项目中数据库配置文件为SqlConfig.xml
    org.yu.study.mybatis.config.XMLMapperBuilder: 主要用来解析我们编写的sql文件，项目中体现为UserMapper.xml
    
    org.yu.study.mybatis.pojo.Configuration: 用来封装数据库和mapperstatement对象
    org.yu.study.mybatis.pojo.MappedStatement：用来封装我们编写的sql文件解析出来的对象
    
    org.yu.study.mybatis.io.Resources：用来解析资源文件，获取InputStream
    
    org.yu.study.mybatis.sqlSession.Executor： 执行器接口，用来做一些查询操作的接口规范定义
    
    org.yu.study.mybatis.sqlSession.SimpleExecutor：执行器的具体实现类，封装jdbc，解析映射出入参
    
    org.yu.study.mybatis.sqlSession.DefaultSqlSession：sqlSession实现类，主要用来创建代理对象
    
# 启动流程
1. 通过执行配置文件 SqlConfig.xml，来读取配置
2. 解析配置中的数据库信息，和sql信息，封装成对象
3. 通过SqlSessionFactoryBuilder快速构建一个SqlSessionFactor
4. 通过SqlSessionFactor获取到一个SqlSession
5. 通过sqlSession给需要执行的dao生成一个代理对象
6. 执行dao里的方法，最终会执行到代理对象中的InvocationHandler.invoke方法 

# 总结
    之前为实现这个项目也花费了两天时间，适合有一年工作经验左右的同学，项目中主要也是借鉴mybatis的核心
    思路（解析入参和映射出参直接套用的mybatis源码）来实现主要流程，后续该项目并没有优化迭代的计划。
    需要学习mybatis的朋友可以继续在这个基础上迭代。
    
