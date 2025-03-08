package ${basePackage}.maker.cli.command;

import cn.hutool.core.util.ReflectUtil;
import ${basePackage}.maker.model.DataModel;
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
@CommandLine.Command(name="config",description = "查看参数信息",mixinStandardHelpOptions = true)
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
