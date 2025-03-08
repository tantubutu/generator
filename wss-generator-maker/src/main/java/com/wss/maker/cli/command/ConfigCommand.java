package com.wss.maker.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.wss.maker.model.DataModel;
import picocli.CommandLine;
import java.lang.reflect.Field;

/**
 * ClassName: ConfigCommand
 * Package: com.wss.cli.command
 * Description:
 *
 * @Author
 * @Create 2025/3/7 14:11
 * @Version 1.0
 */
@CommandLine.Command(name="config",mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{

    @Override
    public void run() {
        Field[] fields = ReflectUtil.getFields(DataModel.class);
        for(Field field : fields){
            System.out.println("字段名称：" + field.getName());
            System.out.println("字段类型：" + field.getType());
//            System.out.println("Modifiers: " + java.lang.reflect.Modifier.toString(field.getModifiers()));
            System.out.println("---");
        }

    }
}
