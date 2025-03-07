package com.wss.model;

import lombok.Data;

/**
 * ClassName: MainTemaplateConfig
 * Package: com.wss.model
 * Description:
 *
 * @Author
 * @Create 2025/3/6 19:52
 * @Version 1.0
 */
@Data
public class MainTemplateConfig {
    //在代码开头增加作者 @Author 注释（增加代码）
    //修改程序输出的信息提示（替换代码）
    //将循环读取输入改为单次读取（可选代码）
    private String author = "wss";
    private String outputText = "Sum =";
    /**
     * 是否循环
     */
    private boolean loop;

}
