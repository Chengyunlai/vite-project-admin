package top.chengyunlai.config;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import javax.sql.DataSource;

/**
 * @ClassName JDBC使用Druild作为数据源
 * @Description
 * @Author:chengyunlai
 * @Date
 * @Version 1.0
 **/
public class DruidDataSourceConfig {
    @Value("${driverClassName}")
    private String driverClassName;
    @Value("${url}")
    private String url;
    @Value("${userName}")
    private String userName;
    @Value("${password}")
    private String password;
    @Value("${initialSize}")
    private int initialSize;

    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setInitialSize(initialSize);
        return dataSource;
    }
}
