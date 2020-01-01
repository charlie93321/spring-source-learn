package com.company.spring;

import com.company.spring.circle.IndexService;
import com.company.spring.circle.UserService;
import com.company.spring.factorybean.Person;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/spring-circle.xml");

        applicationContext.close();
    }

    /*
    *  public static void main(String[] args) throws Exception {

        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("./config/spring-circle.xml"));

        // Person person = beanFactory.getBean(Person.class);
        IndexService indexService = (IndexService) beanFactory.getBean("indexService");
        UserService userService = (UserService) beanFactory.getBean("userService");


        // FactoryBean factorybean = (FactoryBean) beanFactory.getBean("&factorybean");

        System.out.println(userService.getIndexService());
    }
    * */
}
