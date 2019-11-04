package com.company.spring;

import com.company.spring.factorybean.Person;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {

        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("./config/spring.xml"));

        // Person person = beanFactory.getBean(Person.class);

        FactoryBean factorybean = (FactoryBean) beanFactory.getBean("&factorybean");


        Person person = (Person) beanFactory.getBean(Person.class);

        System.out.println(person);
    }
}
