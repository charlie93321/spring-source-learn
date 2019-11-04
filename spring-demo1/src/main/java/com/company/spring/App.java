package com.company.spring;

import com.company.spring.bean.lookup.Person;
import org.junit.Test;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("./config1/spring.xml"));

        BeanDefinition beanDefiniton = beanFactory.getBeanDefinition("chinaWeiWeiCompany");

       Object user01 = beanFactory.getBean("user01");


       System.out.println(user01);

       System.out.println(user01.getClass());


    }

    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/config1/spring.xml");

        Object user01 = applicationContext.getBean("user01");


        System.out.println(user01);

        System.out.println(user01.getClass());

        ((ClassPathXmlApplicationContext) applicationContext).close();
    }
}
