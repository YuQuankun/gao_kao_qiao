package soft.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author: YangGang
 * @date: 2021/11/3 2:19 下午
 */
@Configuration
@MapperScan(basePackages = MySqlDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "mysqlSessionFactory")
@EnableConfigurationProperties({DataSourceProperties.class, DataSourceCommonProperties.class})
public class MySqlDataSourceConfig {

    static final String PACKAGE = "soft.mapper";
    static final String MAPPER_LOCATION = "classpath*:mybatis/mapper/*.xml";
    static final String CONFIG_LOCATION = "classpath:mybatis-plus/mybatis-config.xml";

    @Autowired
    private DataSourceProperties dataSourceProperties;
    @Autowired
    private DataSourceCommonProperties dataSourceCommonProperties;

    @Bean(name = "mysqlDataSource")
    @Primary
    public DataSource mysqlDataSource() {
        DruidDataSource datasource = new DruidDataSource();
        //配置数据源属性
        datasource.setUrl(dataSourceProperties.getMysql().get("jdbc-url"));
        datasource.setUsername(dataSourceProperties.getMysql().get("username"));
        datasource.setPassword(dataSourceProperties.getMysql().get("password"));
        datasource.setDriverClassName(dataSourceProperties.getMysql().get("driver-class-name"));

        //配置统一属性
        datasource.setInitialSize(dataSourceCommonProperties.getInitialSize());
        datasource.setMinIdle(dataSourceCommonProperties.getMinIdle());
        datasource.setMaxActive(dataSourceCommonProperties.getMaxActive());
        datasource.setMaxWait(dataSourceCommonProperties.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(dataSourceCommonProperties.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(dataSourceCommonProperties.getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(dataSourceCommonProperties.getValidationQuery());
        datasource.setTestWhileIdle(dataSourceCommonProperties.isTestWhileIdle());
        datasource.setTestOnBorrow(dataSourceCommonProperties.isTestOnBorrow());
        datasource.setTestOnReturn(dataSourceCommonProperties.isTestOnReturn());
        datasource.setPoolPreparedStatements(dataSourceCommonProperties.isPoolPreparedStatements());
        datasource.setPoolPreparedStatements(false);

        return datasource;
    }

    @Bean(name = "mysqlTransactionManager")
    @Primary
    public DataSourceTransactionManager mysqlTransactionManager(@Qualifier("mysqlDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "mybatisPlusInterceptor")
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 设置分页
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    @Bean(name = "mysqlSessionFactory")
    @Primary
    public SqlSessionFactory mysqlSessionFactory(@Qualifier("mysqlDataSource") DataSource mysqlDataSource,
        @Qualifier("mybatisPlusInterceptor") MybatisPlusInterceptor mybatisPlusInterceptor) throws Exception {
        final MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
        sessionFactory.setDataSource(mysqlDataSource);
        sessionFactory.setMapperLocations(
            new PathMatchingResourcePatternResolver().getResources(MySqlDataSourceConfig.MAPPER_LOCATION));
        sessionFactory.setConfigLocation(
            new PathMatchingResourcePatternResolver().getResource(MySqlDataSourceConfig.CONFIG_LOCATION));
        sessionFactory.setGlobalConfig(new GlobalConfig().setBanner(false));
        MybatisPlusInterceptor[] plugins = {mybatisPlusInterceptor};
        sessionFactory.setPlugins(plugins);
        return sessionFactory.getObject();
    }

}