package com.wss.maker.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
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
        ClassPathResource classPathResource = new ClassPathResource("");
        String inputResourcesPath = classPathResource.getAbsolutePath();

        //java包的基础路径
        //com.wss
        String outputBasePackage = metaObject.getBasePackage();
        //com/wss
        String outputBasePackagePath = StrUtil.join("/", StrUtil.split(outputBasePackage, "."));
        String outputBaseJavaPackagePath = outputPath + File.separator + "src/main/java/" + outputBasePackagePath;

        String inputFilePath;
        String outputFilePath;

        inputFilePath = inputResourcesPath + File.separator +"templates/java/model/DataModel.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/model/DataModel.java";
        System.out.println(outputFilePath);
        DynamicFileGenerator.doGenerator(inputFilePath,outputFilePath,metaObject);


    }

}
