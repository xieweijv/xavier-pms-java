package com.xavier.pms.config;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import lombok.AllArgsConstructor;
import org.apache.ibatis.type.EnumTypeHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * mybatis plus配置中心
 */
@Configuration
@AllArgsConstructor
@MapperScan(basePackages = {"com.xavier.pms.**.dao"})
@EnableTransactionManagement(proxyTargetClass = true)
public class MybatisPlusConfiguration {

    @Bean
    public MybatisPlusInterceptor paginationInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        BlockAttackInnerInterceptor blockAttackInnerInterceptor = new BlockAttackInnerInterceptor();
        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        interceptor.addInnerInterceptor(blockAttackInnerInterceptor);
        // 乐观锁拦截器
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }

    /**
     * 自动填充数据
     */
    @Bean
    @ConditionalOnMissingBean(XavierMetaObjectHandler.class)
    public XavierMetaObjectHandler mateMetaObjectHandler() {
        return new XavierMetaObjectHandler();
    }


    /**
     * IEnum 枚举配置
     */
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return new MybatisPlusCustomizers();
    }

    /**
     * 自定义配置
     */
    public static class MybatisPlusCustomizers implements ConfigurationCustomizer {
        @Override
        public void customize(MybatisConfiguration configuration) {
            configuration.setDefaultEnumTypeHandler(EnumTypeHandler.class);
        }
    }
}
