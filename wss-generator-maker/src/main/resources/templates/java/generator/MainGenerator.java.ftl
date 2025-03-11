package ${basePackage}.generator;

import ${basePackage}.generator.file.DynamicFileGenerator;
import ${basePackage}.generator.file.StaticFileGenerator;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * ClassName: MainGenerator
 * Package: ${basePackage}.generator
 * Description:
 *
 * @Author
 * @Create 2025/3/8 15:54
 * @Version 1.0
 */
public class MainGenerator {

    public static void doGenerate(Object model) throws TemplateException, IOException {

        //输出的根路径
        String inputRootPath = "${fileConfig.inputRootPath}";
        String outputRootPath = "${fileConfig.outputRootPath}";
        String inputPath;
        String outputPath;

    <#list fileConfig.files as fileInfo>
        inputPath = new File(inputRootPath,"${fileInfo.inputPath}").getAbsolutePath();
        outputPath = new File(outputRootPath,"${fileInfo.outputPath}").getAbsolutePath();
        <#if fileInfo.generateType == dynamic>
        DynamicFileGenerator.doGenerator(inputPath,outputPath,model);
        <#else>
        StaticFileGenerator.copyFilesByHutool(inputPath,outputPath);
        </#if>
    </#list>



    }

}
