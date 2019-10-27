package com.lin.bean;

import java.io.InputStream;
import java.util.Properties;

/**
 * 一个创建bean对象的工厂,降低耦合性
 *
 */
@SuppressWarnings("all")
public class AccountBean {
    private static Properties pro;
    static {
        try {
            pro = new Properties();
            InputStream in = AccountBean.class.getClassLoader().getResourceAsStream("bean.properties");
            pro.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 通过beanName 得到object bean
     * @param beanName
     * @return
     */

        public static Object getBean(String beanName) {
        Object bean = null;
        try {
            String beanPath = pro.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
