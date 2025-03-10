import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * ClassName: FreeMarkerTest
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author
 * @Create 2025/3/6 19:17
 * @Version 1.0
 */
public class FreeMarkerTest {
    @Test
    public void test() throws IOException, TemplateException {

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_22);
        File file = new File("src/main/resources/templates");
        System.out.println(file.getAbsoluteFile());
        configuration.setDirectoryForTemplateLoading(file);
        configuration.setDefaultEncoding("UTF-8");
//IdeaProjects\wss-generator\wss-generator-basic\src\main\resources\templates
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setNumberFormat("0.#####");
        Template template = configuration.getTemplate("myweb.htm.ftl");
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("currentYear", 2023);
        List<Map<String, Object>> menuItems = new ArrayList<>();
        Map<String, Object> menuItem1 = new HashMap<>();
        menuItem1.put("url", "https://codefather.cn");
        menuItem1.put("label", "编程导航");
        Map<String, Object> menuItem2 = new HashMap<>();
        menuItem2.put("url", "https://laoyujianli.com");
        menuItem2.put("label", "老鱼简历");
        menuItems.add(menuItem1);
        menuItems.add(menuItem2);
        dataModel.put("menuItems", menuItems);
        Writer out = new FileWriter("myweb.html");
        template.process(dataModel, out);

// 生成文件后别忘了关闭哦
        out.close();



    }

}
