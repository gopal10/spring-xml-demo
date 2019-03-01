package com.stackroute;

/*
Create a Maven project and add required dependency of spring-context 5.1.4.RELEASE
Create a Main class in package com.stackroute and two Spring Beans – Movie, and Actor in
package com.stackroute.domain.
Actor has two String properties, name and gender, and an age property of type int.
An Actor can be initialized with the three properties via the corresponding setter methods. Use
property based injection in the bean definition file (beans.xml)
Movie “has a” Actor that can be initialized via the corresponding setter method. Use property
based object injection in the bean definition file (beans.xml)
The Main class looks up Movie bean via three ways to print out actor information:
1. Using XmlBeanFactory
2. Using Spring 3.2 BeanDefinitionRegistry and BeanDefinitionReader
3. Using ApplicationContext
Create a spring-xml-demo repo and push the code to master branch.

 */
import com.stackroute.domain.Movie;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Main {

    public  static  void main(String gopal []) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("BeanFile.xml");
         Movie movie=(Movie)applicationContext.getBean("movie2");
        Movie movie2=(Movie)applicationContext.getBean("movie3");

        XmlBeanFactory xmlBeanFactory= new XmlBeanFactory ( new ClassPathResource("BeanFile.xml"));
        Movie movieFirst= (Movie)xmlBeanFactory.getBean("movie2");

        System.out.println(movie.getActor());
        System.out.println(movie2.getActor());

        movie.setApplicationContext(applicationContext);
        movieFirst.setBeanFactory(xmlBeanFactory);
        movie.setBeanName("beam123");
    }
}
/*
Exception in thread "main" org.springframework.beans.factory.BeanCreationException:
 Error creating bean with name 'movie2' defined in class path resource [BeanFile.xml]:
  Instantiation of bean failed; nested exception is org.springframework.beans.
  BeanInstantiationException: Failed to instantiate [com.stackroute.domain.Movie]:
  No default constructor found; nested exception is java.lang.NoSuchMethodException:
  com.stackroute.domain.Movie.<init>()
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.
	instantiateBean(AbstractAutowireCapableBeanFactory.java:1287)
 */