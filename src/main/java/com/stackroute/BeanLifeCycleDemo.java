package com.stackroute;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemo implements InitializingBean, DisposableBean {



    public  static  void main(String gopal []) {

            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("BeanFile.xml");

            ((ClassPathXmlApplicationContext) applicationContext).registerShutdownHook();
            BeanLifeCycleDemo beanLifeCycleDemo = (BeanLifeCycleDemo) applicationContext.getBean("lifecycle");





    }
    public void Init ()
    {
        System.out.println("Initialization");
    }

    public  void clean()
    {
        System.out.println("custom destroy");
    }
    public void destroy ()
    {
        System.out.println("Destroy");
    }

    public void afterPropertiesSet () throws Exception {
        System.out.println("After properties");

    }
    }
