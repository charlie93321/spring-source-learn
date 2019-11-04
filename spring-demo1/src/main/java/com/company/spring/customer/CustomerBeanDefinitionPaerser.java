package com.company.spring.customer;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

/**
 * @AUTHOR: 小于
 * @DATE: [2019/11/2  18:59]
 * @DESC:
 */
public class CustomerBeanDefinitionPaerser extends AbstractSingleBeanDefinitionParser {


    @Override
    protected Class getBeanClass(Element element){
        return User.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder bean){
        String userName = element.getAttribute("userName");
        String email = element.getAttribute("email");
        if(StringUtils.isNotEmpty(userName)){
            bean.addPropertyValue("userName",userName);
        }
        if(StringUtils.isNotEmpty("email")){
            bean.addPropertyValue("email",email);
        }
    }
}
