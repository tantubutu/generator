package com.wss.maker.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.wss.maker.generator.file.DynamicFileGenerator;
import com.wss.maker.meta.Meta;
import com.wss.maker.meta.MetaManager;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * ClassName: MainGenerator
 * Package: com.wss.maker.generator
 * Description:
 *
 * @Author
 * @Create 2025/3/8 15:54
 * @Version 1.0
 */
public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        Meta metaObject = MetaManager.getMetaObject();
        System.out.println(metaObject);

        //输出的根路径
        String projectPath = System.getProperty("user.dir");
        String outputPath = projectPath + File.separator +"generated";
        if(!FileUtil.exist(outputPath)){
            FileUtil.mkdir(outputPath);
        }
        //读取 resources 目录
        String inputResourcesPath = projectPath + File.separator + "src/main/resources";

       // ClassPathResource classPathResource = new ClassPathResource("src/main/resources");
       // String inputResourcesPath = classPathResource.getAbsolutePath();
        /**
         * D:/workspace_program/workspace_JAVA/IdeaProjects/wss-generator/wss-generator-maker/target/classes/
         * 在 Maven 项目中，src/main/resources 和 src/main/java 中的文件在编译后会被复制到 target/classes 目录。
         */

        //java包的基础路径
        //com.wss
        String outputBasePackage = metaObject.getBasePackage();
        //com/wss
        String outputBasePackagePath = StrUtil.join("/", StrUtil.split(outputBasePackage, "."));
        String outputBaseJavaPackagePath = outputPath + File.separator + "src/main/java/" + outputBasePackagePath;

        String inputFilePath;
        String outputFilePath;

        //model.DataModel,java
        inputFilePath = inputResourcesPath + File.separator +"templates/java/model/DataModel.java.ftl";
        outputFilePath = outputBaseJavaPackagePath +File.separator +"model/DataModel.java";
        DynamicFileGenerator.doGenerator(inputFilePath,outputFilePath,metaObject);
        //src/main/java/com/wss/maker/cli/command/GenerateCommand.java
        inputFilePath = inputResourcesPath + File.separator + "templates/java/cli/command/GenerateCommand.java.ftl";
        outputFilePath = outputBaseJavaPackagePath +File.separator+ "cli/command/GenerateCommand.java";
        DynamicFileGenerator.doGenerator(inputFilePath,outputFilePath,metaObject);
//\wss-generator-maker\src\main\resources\templates\java\cli\command does not exist.
//
        // cli.command.ConfigCommand
        inputFilePath = inputResourcesPath + File.separator + "templates/java/cli/command/ConfigCommand.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/cli/command/ConfigCommand.java";
        DynamicFileGenerator.doGenerator(inputFilePath , outputFilePath, metaObject);

        // cli.command.ListCommand
        inputFilePath = inputResourcesPath + File.separator + "templates/java/cli/command/ListCommand.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/cli/command/ListCommand.java";
        DynamicFileGenerator.doGenerator(inputFilePath , outputFilePath, metaObject);

        // cli.CommandExecutor
        inputFilePath = inputResourcesPath + File.separator + "templates/java/cli/CommandExecutor.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/cli/CommandExecutor.java";
        DynamicFileGenerator.doGenerator(inputFilePath , outputFilePath, metaObject);

        // Main
        inputFilePath = inputResourcesPath + File.separator + "templates/java/Main.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/Main.java";
        DynamicFileGenerator.doGenerator(inputFilePath , outputFilePath, metaObject);
    }

}
