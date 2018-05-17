package net.sj.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"net.sj.shoppingbackend.dto"})
@EnableTransactionManagement

public class HibernateConfig {
	
	private  final static String Database_Url="jdbc:h2:tcp://localhost/~/onlineshopping";
	private final static String Database_Driver="org.h2.Driver";
	private final static String Database_Dialect="org.hibernate.dialect.H2Dialect";
	private final static String Database_Username="sa";
	private final static String Database_Password="";
	
	
	
	//////// DataSource Bean ////////////
	
	@Bean
	public DataSource getDatasource(){
		
		BasicDataSource datasource=new BasicDataSource();
		datasource.setDriverClassName(Database_Driver);
		datasource.setUrl(Database_Url);
		datasource.setUsername(Database_Username);
		datasource.setPassword(Database_Password);
		
		return datasource;
		
	}
	
	
	//////  SessionFactory Bean //////////////
	@Bean
	public SessionFactory getSessionFactory(DataSource datasource){
		
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(datasource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.sj.shoppingbackend.dto");
		
		return builder.buildSessionFactory();
		
	}
	
	
	////// All the Hibernate Properties will be returned in this method
	private Properties getHibernateProperties() {
		
		Properties prop=new Properties();
		
		prop.put("hibernate.dialect", Database_Dialect);
		prop.put("hibernate.show_sql", true);
		prop.put("hibernate.format_sql", true);
		prop.put("hibernate.hbm2ddl.auto", "update");
		return prop;
	}
	
	
	///////////////// Transaction Bean ////////////////////////////
	
	@Bean
	public HibernateTransactionManager getTransaction(SessionFactory sf){
		HibernateTransactionManager transaction=new HibernateTransactionManager(sf);
		return transaction;
		
	}
	
}
