package com.wss.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.wss.generator.MainGenerator;
import com.wss.model.MainTemplateConfig;
import freemarker.template.TemplateException;
import lombok.Data;
import picocli.CommandLine;

import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * ClassName: GenerateCommand
 * Package: com.wss.cli.command
 * Description:
 *
 * @Author
 * @Create 2025/3/7 14:10
 * @Version 1.0
 */
@CommandLine.Command(name = "generate",mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable<Integer> {

    @CommandLine.Option(names= {"-a","--author"},description = "作者名称",arity = "0..1",interactive = true,echo = true)
    private String author = "wss";

    @CommandLine.Option(names= {"-o","--output"},description = "输出文本",arity = "0..1",interactive = true,echo = true)
    private String outputText = "Sum = ";
    /**
     * 是否循环
     */
    @CommandLine.Option(names={"-l", "--loop"},description = "是否循环",arity = "0..1",interactive = true,echo = true)
    private boolean loop = true;

    @Override
    public Integer call() throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        BeanUtil.copyProperties(this,mainTemplateConfig);
        MainGenerator.doGenerate(mainTemplateConfig);
        return 0;
    }



}
