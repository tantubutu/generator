package com.wss.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine;
import java.io.File;
import java.util.List;

/**
 * ClassName: ListCommand
 * Package: com.wss.cli.command
 * Description:
 *
 * @Author
 * @Create 2025/3/7 14:11
 * @Version 1.0
 */
@CommandLine.Command(name = "list" ,mixinStandardHelpOptions = true)
public class ListCommand  implements Runnable{


    @Override
    public void run() {
        String projectPath = System.getProperty("user.dir");
        // 整个项目的根路径
        File parentFile = new File(projectPath);
        // 输入路径
        String inputPath = new File(parentFile, "wss-generator-demo-projects/acm-template").getAbsolutePath();
        List<File> files = FileUtil.loopFiles(inputPath);
        for (File file : files) {
            System.out.println(file);
        }
    }
}
