package com.springboot.cloud.gen.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author: dongwei
 * @date: 2019/11/2 16:15
 * @description: mybatis plus 配置
 */
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {


    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
