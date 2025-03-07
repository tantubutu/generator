package com.wss.generator;

import com.wss.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;


/**
 * ClassName: MainGenerator
 * Package: com.wss.generator
 * Description:
 *
 * @Author
 * @Create 2025/3/7 8:53
 * @Version 1.0
 */
public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        //复制静态文件
        String projectPath = System.getProperty("user.dir");
        //输入路径
        String inputPath =projectPath + File.separator + "wss-generator-demo-projects"+ File.separator + "acm-template";
        //输出路径
        String outputPath = projectPath;
        StaticGenerator.copyFilesByRecursive(inputPath,outputPath);

        //动态文件

       String DynamicInputPath = projectPath + File.separator +"wss-generator-basic/src/main/resources/templates/MainTemplate.java.ftl";
        String DynamicOutputPath = projectPath +  File.separator + "acm-template/src/com/wss/acm/MainTemplate.java";

        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("wss");
        mainTemplateConfig.setOutputText("outputResult2");
        mainTemplateConfig.setLoop(false);
        DynamicGenerator.doGenerator(DynamicInputPath, DynamicOutputPath, mainTemplateConfig);

    }
}
