package org.yu.study.mybatis.utils;

/**
 * @Author: YHY
 * @desc: 参数映射 借鉴mybatis源码
 * @Date: 2022/11/13
 */
public class ParameterMapping {

    private String content;

    public ParameterMapping(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
