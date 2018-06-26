package com.cliang.application.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.sql.DataSource;


@Configuration
public class Config {

    @Autowired
    private Environment env;

    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));//用户名
        dataSource.setPassword(env.getProperty("spring.datasource.password"));//密码
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setInitialSize(2);//初始化时建立物理连接的个数
        dataSource.setMaxActive(20);//最大连接池数量
        dataSource.setMinIdle(0);//最小连接池数量
        dataSource.setMaxWait(60000);//获取连接时最大等待时间，单位毫秒。
        dataSource.setValidationQuery("SELECT 1");//用来检测连接是否有效的sql
        dataSource.setTestOnBorrow(false);//申请连接时执行validationQuery检测连接是否有效
        dataSource.setTestWhileIdle(true);//建议配置为true，不影响性能，并且保证安全性。
        dataSource.setPoolPreparedStatements(false);//是否缓存preparedStatement，也就是PSCache
        return dataSource;
    }


    @Bean("ThreadPoolA")
    public ThreadPoolTaskExecutor getexcutorA(){
        ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(5);
        executor.setKeepAliveSeconds(200);
        executor.setQueueCapacity(10);
        executor.setThreadNamePrefix("chang-");
        return executor;
    }

    @Bean("ThreadPoolB")
    public ThreadPoolTaskExecutor getexcutorB(){
        ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(5);
        executor.setKeepAliveSeconds(100);
        executor.setQueueCapacity(10);
        executor.setThreadNamePrefix("liang-");
        return executor;
    }
}
