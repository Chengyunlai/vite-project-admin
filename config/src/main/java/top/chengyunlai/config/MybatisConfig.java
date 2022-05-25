package top.chengyunlai.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @ClassName 第三方Mybatis交给Spring容器管理
 * @Description
 * @Author:chengyunlai
 * @Date
 * @Version 1.0
 **/
public class MybatisConfig {
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
        // 实体类别名
        sf.setTypeAliasesPackage("top.chengyunlai.base.pojo");
        sf.setDataSource(dataSource);
        return sf;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("top.chengyunlai.dao");
        return msc;
    }

}
