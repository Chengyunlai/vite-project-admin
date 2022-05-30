package top.chengyunlai.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.chengyunlai.config.SpringConfig;

public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void usersList() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        UserMapper bean = ctx.getBean(UserMapper.class);
        bean.selectAll();

    }
}