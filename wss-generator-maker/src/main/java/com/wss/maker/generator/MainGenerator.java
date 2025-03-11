package com.wss.maker.generator;
import com.wss.maker.meta.Meta.ModelConfigDTO;
import com.wss.maker.meta.Meta.FileConfigDTO;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.wss.maker.generator.file.DynamicFileGenerator;
import com.wss.maker.generator.file.StaticFileGenerator;
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

    public static void doGenerate(Object model) throws TemplateException, IOException {

        //输出的根路径
        String inputRootPath = "D:\\workspace_program\\workspace_JAVA\\IdeaProjects\\wss-generator\\wss-generator-demo-projects\\acm-template-pro";
        String outputRootPath = "D:\\workspace_program\\workspace_JAVA\\IdeaProjects\\wss-generator";
        String inputPath;
        String outputPath;
        inputPath = new File(inputRootPath,"src/com/wss/acm/MainTemplate.java.ftl").getAbsolutePath();
        outputPath = new File(outputRootPath,"src/com/wss/acm/MainTemplate.java").getAbsolutePath();
        DynamicFileGenerator.doGenerator(inputPath,outputPath,model);

        inputPath = new File(inputRootPath,".gitignore").getAbsolutePath();
        outputPath = new File(outputRootPath,".gitignore").getAbsolutePath();
        StaticFileGenerator.copyFilesByHutool(inputPath,outputPath);

        inputPath = new File(inputRootPath,".README.md").getAbsolutePath();
        outputPath = new File(outputRootPath,"README.md").getAbsolutePath();
        StaticFileGenerator.copyFilesByHutool(inputPath,outputPath);
/*

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

*/



    }

}
