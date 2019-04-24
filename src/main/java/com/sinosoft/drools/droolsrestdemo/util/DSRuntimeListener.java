package com.sinosoft.drools.droolsrestdemo.util;

import com.alibaba.fastjson.JSON;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;

public class DSRuntimeListener  implements RuleRuntimeEventListener {
    @Override
    public void objectInserted(ObjectInsertedEvent event) {
        System.out.println(event.getRule()+"   插入对象  : "+ JSON.toJSONString(event.getObject()));
    }

    @Override
    public void objectUpdated(ObjectUpdatedEvent event) {

        System.out.print(event.getRule().getName()+"   修改对象  : "+ JSON.toJSONString(event.getOldObject()));
        System.out.println("   to  "+JSON.toJSONString(event.getObject()));
    }

    @Override
    public void objectDeleted(ObjectDeletedEvent event) {
        System.out.println("删除对象  : "+ event.getFactHandle().toExternalForm());
    }
}
