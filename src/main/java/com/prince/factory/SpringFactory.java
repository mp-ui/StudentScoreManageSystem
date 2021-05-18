/**
 * @AUTHOR Prince
 * @TIME 2021/5/17 16:20
 */

package com.prince.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringFactory {
    private static ApplicationContext applicationContext;

    static {
        //Spring
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    public static ApplicationContext getInstance(){
        return applicationContext;
    }

}
