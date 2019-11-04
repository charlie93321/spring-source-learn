package com.company.spring.bean.lookup;

import org.springframework.beans.factory.parsing.*;

/**
 * @AUTHOR: 小于
 * @DATE: [2019/11/1  22:39]
 * @DESC: beanDefinition 监听注册事件
 */
public class ReaderEventListenerImpl implements ReaderEventListener {
    @Override
    public void defaultsRegistered(DefaultsDefinition defaultsDefinition) {
        System.out.println("defaultsRegistered");
    }

    @Override
    public void componentRegistered(ComponentDefinition componentDefinition) {
        System.out.println("componentDefinition");
    }

    @Override
    public void aliasRegistered(AliasDefinition aliasDefinition) {
        System.out.println("aliasRegistered");
    }

    @Override
    public void importProcessed(ImportDefinition importDefinition) {
        System.out.println("importProcessed");
    }
}
