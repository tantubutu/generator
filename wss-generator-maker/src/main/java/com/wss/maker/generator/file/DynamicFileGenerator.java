package com.wss.maker.generator.file;

import cn.hutool.core.io.FileUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * ClassName: DynamicGenerator
 * Package: com.wss.generator
 * Description:动态文件按生成器
 *
 * @Author
 * @Create 2025/3/6 20:01
 * @Version 1.0
 */
public class DynamicFileGenerator {
    /**
     * 生成文件
     *
     * @param inputPath 模板文件输入路径
     * @param outputPath 输出路径
     * @param obj 数据模型
     * @throws IOException
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
        System.out.println(outputPath);
        //如果文件不存在则创建目录
        if(!FileUtil.exist(outputPath)){
            System.out.println(123);
            FileUtil.touch(outputPath);
        }

        Writer out = new FileWriter(outputPath);

        template.process(obj, out);

// 生成文件后别忘了关闭哦
        out.close();
    }

}
