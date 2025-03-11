package ${basePackage}.generator.file;

import ${basePackage}.model.DataModel;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;


/**
 * ClassName: MainGenerator
 * Package: ${basePackage}.generator
 * Description:
 *
 * @Author
 * @Create 2025/3/7 8:53
 * @Version 1.0
 */
public class FileGenerator {
    public static void doGenerate(DataModel mainTemplateConfig) throws TemplateException, IOException {
        //todo 路径写死，优化
        //复制静态文件
        String projectPath = System.getProperty("user.dir");
        //输入路径
        String inputPath =projectPath + File.separator + "wss-generator-demo-projects"+ File.separator + "acm-template";
        //输出路径
        String outputPath = projectPath;
        StaticFileGenerator.copyFilesByHutool(inputPath,outputPath);

        //动态文件

       String DynamicInputPath = projectPath + File.separator +"wss-generator-maker/src/main/resources/templates/MainTemplate.java.ftl";
        String DynamicOutputPath = projectPath +  File.separator + "acm-template/src/com/wss/acm/MainTemplate.java";
        DynamicFileGenerator.doGenerator(DynamicInputPath, DynamicOutputPath, mainTemplateConfig);

    }
}
