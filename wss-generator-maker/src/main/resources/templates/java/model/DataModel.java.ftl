package ${basePackage}.maker.model;

import lombok.Data;

/**
* 数据模型
*/
@Data
public class DataModel {




<#list modelConfig.models as modelInto>

    <#if modelInto.description??>
        /**
         * ${modelInto.description}
         */
    </#if>
    private ${modelInto.type} ${modelInto.fieldName} <#if modelInto.defaultValue??> = ${modelInto.defaultValue?c}</#if>;

</#list>
}
