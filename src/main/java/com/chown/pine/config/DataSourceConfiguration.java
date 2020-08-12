/**
 * 文 件 名:  DataBaseConfiguration
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2019/3/1 0001
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.chown.pine.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * <数据源配置>
 *
 * @author zping
 * @version 2019/3/1 0001
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Configuration
@PropertySource ("classpath:mybatis.properties")
public class DataSourceConfiguration
{

	/**
	 * 数据源类型：Druid、Jdbc、JNI
	 */
	@Value ("${spring.datasource.type}")
	private Class<? extends DataSource> dataSourceType;

	/**
	 * 主数据源 : 负责数据写操作
	 *
	 * @return
	 */
	@Bean (name = "writeDataSource", destroyMethod = "close", initMethod = "init")
	@Primary
	@ConfigurationProperties (prefix = "spring.datasource")
	public DataSource writeDataSource ()
	{
		System.out.println ("-------------------- writeDataSource init ---------------------");
		return DataSourceBuilder.create ().type (dataSourceType).build ();
	}

	/**
	 * 备数据库 ：负责数据读操作
	 *
	 * @return
	 */
	@Bean (name = "readDataSource01")
	@ConfigurationProperties (prefix = "spring.slave01")
	public DataSource readDataSourceOne ()
	{
		System.out.println ("-------------------- read01 DataSourceOne init ---------------------");
		return DataSourceBuilder.create ().type (dataSourceType).build ();
	}

	@Bean(name = "readDataSource02")
	@ConfigurationProperties(prefix = "spring.slave02")
	public DataSource readDataSourceTwo() {
		System.out.println ("-------------------- read02 DataSourceTwo init ---------------------");
		return DataSourceBuilder.create().type(dataSourceType).build();
	}

	@Bean(name = "readDataSources")
	public List<DataSource> readDataSources(){
		List<DataSource> dataSources=new ArrayList<>();
		dataSources.add(readDataSourceOne());
		dataSources.add(readDataSourceTwo());
		return dataSources;
	}
}
