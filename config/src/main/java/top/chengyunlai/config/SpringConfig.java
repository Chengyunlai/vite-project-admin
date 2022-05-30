package top.chengyunlai.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName 这是Spring的主配置类
 * @Description
 * @Author:chengyunlai
 * @Date
 * @Version 1.0
 **/
@Configuration
@ComponentScan("top.chengyunlai")
@PropertySource({"classpath:druid.properties"})
@Import({DruidDataSourceConfig.class,MybatisConfig.class})
public class SpringConfig {

}
