package com.taylor.spb;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
public class DatasourceConfig implements TransactionManagementConfigurer {
	@Autowired
	private DataSource dataSource;

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);

		// 添加XML目录
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setTypeAliasesPackage("com.taylor.spb.entity");

		try {
			sessionFactory.setMapperLocations(resolver.getResources("classpath:/mapper/*Mapper.xml"));
			sessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
			return sessionFactory.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {

		return new SqlSessionTemplate(sqlSessionFactory);
	}

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {

		return new DataSourceTransactionManager(dataSource);
	}
}
