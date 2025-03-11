
package com.wss.maker.meta;


import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

import static cn.hutool.json.JSONUtil.toBean;

/**
 * ClassName: MetaManager
 * Package: com.wss.maker.meta
 * Description:
 *
 * @Author
 * @Create 2025/3/8 15:33
 * @Version 1.0
 */

public class MetaManager {

    private static volatile Meta meta;

    public static Meta getMetaObject(){
        if(meta == null){
            synchronized (MetaManager.class){
                if(meta == null){
                    meta = initMeta();
                }
            }
        }
        return meta;
    }
    private static Meta initMeta(){
        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        Meta newMeta = JSONUtil.toBean(metaJson, Meta.class);
        //todo 配置文件处理默认值

         return newMeta;
    }


}

