package org.yu.study.mybatis.io;

import java.io.InputStream;

/**
 * @Author: YHY
 * @desc: 读取文件信息
 * @Date: 2022/11/13
 */
public class Resources {

    // 根据配置文件的路径，将配置文件加载成字节输入流，存储在内存中
    public static InputStream getResourceAsSteam(String path) {
        InputStream resourceAsStream = Resources.class.getClassLoader().getResourceAsStream(path);
        return resourceAsStream;
    }
}
