package com.wss.maker.generator.file;

import cn.hutool.core.io.FileUtil;

/**
 * ClassName: StaticGenerator
 * Package: com.wss.generator
 * Description:静态文件生成器
 *
 * @Author
 * @Create 2025/3/6 17:13
 * @Version 1.0
 */
public class StaticFileGenerator {


    /**
     * 拷贝文件（Hutool 实现，会将输入目录完整拷贝到输出目录下）
     * @param inputPath 输入路径
     * @param outputPath 输出路径
     */
    public static void copyFilesByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }


}
