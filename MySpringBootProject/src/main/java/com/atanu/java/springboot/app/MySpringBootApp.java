package com.atanu.java.springboot.app;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.atanu.java.springboot.logger.ApplicationLogger;

/**
 * 
 * @author Atanu Bhowmick
 *
 */

@SpringBootApplication(scanBasePackages = { "com.atanu.java.springboot" })
@EnableAutoConfiguration(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class })
public class MySpringBootApp {

	private static final ApplicationLogger logger = new ApplicationLogger(MySpringBootApp.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MySpringBootApp.class, args);
	}

	@Autowired
    private Environment env;
	
	@Bean(name = "dataSource")
    public DataSource getDataSource() {
		
		logger.info("Creating Data Source..");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
 
        // See: application.properties
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        logger.info("Data Source: {}", dataSource);
 
        return dataSource;
    }
 
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) throws IOException {
    	logger.info("Creating Session Factory..");
    	Properties properties = new Properties();
 
        // Setting JPA/HibernateProperties in session factory. See: application.properties
        properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
        properties.put("hibernate.ddl-auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
        properties.put("hibernate.enable_lazy_load_no_trans", env.getProperty("spring.jpa.properties.hibernate.enable_lazy_load_no_trans"));
        properties.put("current_session_context_class", //
                env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
 
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
 
        // Packages to scan for entity classes
        factoryBean.setPackagesToScan("com.atanu.java.springboot.entity");
        factoryBean.setDataSource(dataSource);
        factoryBean.setHibernateProperties(properties);
        factoryBean.afterPropertiesSet();
        
        //Get Session Factory from factory bean.
        SessionFactory sessionFactory = factoryBean.getObject();
        logger.debug("Session Factory created: {}", sessionFactory);
        return sessionFactory;
    }
 
    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
    	logger.info("Creating Transaction Manager..");
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
        return transactionManager;
    }
}