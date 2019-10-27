package com.lin.test;

import com.lin.dao.ItemsDao;
import com.lin.domain.Items;
import com.lin.service.ItemService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@SuppressWarnings("all")
public class daoTest {
    @Test
    public void findById(){
        //获取spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //dao测试
//        从容器中拿到所需的dao的代理对象
        ItemsDao itemsDao = ac.getBean(ItemsDao.class);
//        调用方法
        Items items = itemsDao.findItemById(1);
        System.out.println(items.getName());

        //service测试
        System.out.println(items.getName());
    }
    @Test
    public void findByIdService(){
        //获取spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //dao测试
//        从容器中拿到所需的dao的代理对象
        ItemService itemService = ac.getBean("itemService", ItemService.class);

//        调用方法
        Items items = itemService.findItemById(1);
        System.out.println(items.getName());

    }




}
