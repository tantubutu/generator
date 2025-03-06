package com.wss.generator;

import com.wss.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: DynamicGenerator
 * Package: com.wss.generator
 * Description:动态文件按生成器
 *
 * @Author
 * @Create 2025/3/6 20:01
 * @Version 1.0
 */
public class DynamicGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir") + File.separator + "wss-generator-basic";
        String inputPath = projectPath + File.separator +"src/main/resources/templates/MainTemplate.java.ftl";
        String s = File.separator + "MainTemplate.java";
        String outputPath = projectPath +  File.separator + "MainTemplate.java";
        System.out.println(inputPath);
        System.out.println(outputPath);
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("wss");
        mainTemplateConfig.setOutputText("ou1tputReslt");
        mainTemplateConfig.setLoop(true);
        doGenerator(inputPath, outputPath, mainTemplateConfig);



    }
    /**
     * 生成文件
     *
     * @param inputPath 模板文件输入路径
     * @param outputPath 输出路径
     * @param obj 数据模型
     * @throws IOException
     * @throws TemplateException
     */
    public static void doGenerator(String inputPath,String outputPath,Object obj) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_22);

        File templateDir = new File(inputPath).getParentFile();

        configuration.setDirectoryForTemplateLoading(templateDir);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setNumberFormat("0.#####");

        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);



        Writer out = new FileWriter(outputPath );

        template.process(obj, out);

// 生成文件后别忘了关闭哦
        out.close();
    }

}
