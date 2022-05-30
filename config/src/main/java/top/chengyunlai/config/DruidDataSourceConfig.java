package top.chengyunlai.config;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import top.chengyunlai.utils.Decrypt;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @ClassName JDBC使用Druild作为数据源
 * @Description
 * @Author:chengyunlai
 * @Date
 * @Version 1.0
 **/
public class DruidDataSourceConfig {
    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String userName;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.initialSize}")
    private int initialSize;

    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(getDecryptPassword(password));
        dataSource.setInitialSize(initialSize);
        return dataSource;
    }

    private String getDecryptPassword(String password){
        try {
            return Decrypt.decrypt(password);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
