package com.company.spring.customer;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @AUTHOR: 小于
 * @DATE: [2019/11/2  19:12]
 * @DESC:
 */
public class TestNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("user",new CustomerBeanDefinitionPaerser());
    }
}
