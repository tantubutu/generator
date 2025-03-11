package com.wss.model;

import lombok.Data;


/**
 * 数据模型
 */
@Data
public class DataModel {

    /**
     * 是否生成循环
     */
    public boolean loop = false;

    /**
     * 作者注释
     */
    public String author = "wss";

    /**
     * 输出信息
     */
    public String outputText = "sum = ";
}