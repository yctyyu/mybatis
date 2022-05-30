package org.yu.study.mybatis.sqlSession;


import org.yu.study.mybatis.pojo.Configuration;
import org.yu.study.mybatis.pojo.MappedStatement;

import java.util.List;

/**
 * @Author: YHY
 * @desc: 执行器接口
 * @Date: 2022/11/13
 */
public interface Executor {

    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws Exception;

}
